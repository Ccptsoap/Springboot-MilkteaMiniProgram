package com.demo01.demo.service;

import com.demo01.demo.entity.*;
import com.demo01.demo.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.sf.json.JSONArray;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl  implements OrderService{
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> findAllOrderByID(String openid)    //未完成,未来接口
    {
        int a[] = orderMapper.findAllOrderByID(openid);
        return null;
    }
    public List<MiniOrder> findAllMiniOrder(String openid)
    {
        List<MiniOrderEntry> entryList=orderMapper.findAllMiniOrder(openid);
        List<MiniOrder> orderList=new ArrayList<>();
        List<String> drinkIdList=new ArrayList<>();
        List<String> imageList=new ArrayList<>();
        MiniOrder orderTmp = new MiniOrder();
        int drinkId;
        int orderId=-1;
        double total=0;
        //查询结果为空
        if(entryList.size()==0)
            return null;
        //根据订单编号合并订单条目，组成一个完整订单
        for(MiniOrderEntry e : entryList)
        {
            //当前条目属于一个新订单
            if(orderId!=e.getOrderId())
            {
                //不是第一个订单才需要添加到orderList
                if(orderId!=-1)
                {
                    orderTmp.setTotal(total);
                    orderTmp.setDrinkIdList(drinkIdList);
                    orderTmp.setImageList(imageList);
                    orderList.add(orderTmp);
                }
                //清空上个订单用到的变量
                orderTmp = new MiniOrder();
                drinkIdList=new ArrayList<>();
                imageList=new ArrayList<>();
                total = 0;
                //不是第一个订单才需要清空drinkList,imageList
                if(orderId!=-1) {
                    drinkIdList.clear();
                    imageList.clear();
                }
                //
                orderId=e.getOrderId();
                orderTmp.setOrderId(e.getOrderId());
                orderTmp.setOrderTime(e.getTime());
                orderTmp.setOpenid(e.getOpenid());
                total+=e.getPrice();
                //加入一种饮品
                drinkIdList.add(e.getId());
                imageList.add(e.getImage());

            }
            //当前条目与上条条目属于同一个订单，仅添加饮品
            else
            {
                total+=e.getPrice();
                drinkIdList.add(e.getId());
                imageList.add(e.getImage());
            }
        }

        orderTmp.setTotal(total);
        orderTmp.setDrinkIdList(drinkIdList);
        orderTmp.setImageList(imageList);
        orderList.add(orderTmp);
        return orderList;
    }
    public List<MiniOrder> findTodayMiniOrder(String openid)
    {
        List<MiniOrderEntry> entryList=orderMapper.findTodayMiniOrder(openid);
        List<MiniOrder> orderList=new ArrayList<>();
        List<String> drinkIdList=new ArrayList<>();
        List<String> imageList=new ArrayList<>();
        MiniOrder orderTmp = new MiniOrder();
        int drinkId;
        int orderId=-1;
        double total=0;
        //查询结果为空
        if(entryList.size()==0)
            return null;
        //根据订单编号合并订单条目，组成一个完整订单
        for(MiniOrderEntry e : entryList)
        {
            //当前条目属于一个新订单
            if(orderId!=e.getOrderId())
            {
                //不是第一个订单才需要添加到orderList
                if(orderId!=-1)
                {
                    orderTmp.setTotal(total);
                    orderTmp.setDrinkIdList(drinkIdList);
                    orderTmp.setImageList(imageList);
                    orderList.add(orderTmp);
                }
                //清空上个订单用到的变量
                orderTmp = new MiniOrder();
                drinkIdList=new ArrayList<>();
                imageList=new ArrayList<>();
                total = 0;
                //不是第一个订单才需要清空drinkList,imageList
                if(orderId!=-1) {
                    drinkIdList.clear();
                    imageList.clear();
                }
                //
                orderId=e.getOrderId();
                orderTmp.setOrderId(e.getOrderId());
                orderTmp.setOrderTime(e.getTime());
                orderTmp.setOpenid(e.getOpenid());
                total+=e.getPrice();
                //加入一种饮品
                drinkIdList.add(e.getId());
                imageList.add(e.getImage());

            }
            //当前条目与上条条目属于同一个订单，仅添加饮品
            else
            {
                total+=e.getPrice();
                drinkIdList.add(e.getId());
                imageList.add(e.getImage());
            }
        }

        orderTmp.setTotal(total);
        orderTmp.setDrinkIdList(drinkIdList);
        orderTmp.setImageList(imageList);
        orderList.add(orderTmp);
        return orderList;
    }
    public Order findOneOrder(int orderId)
    {
        List<SelectInfo> entryList=orderMapper.findSelectInfo(orderId);
        Order order=new Order();
        List<OrderDrink> drinkList=new ArrayList<>();
        OrderDrink drinkTmp;
        double totalPrice=0;
        int i=0;
        //合并订单条目，组成一个完整订单
        for(SelectInfo e : entryList)
        {
            //第一个条目设置订单除饮品外的成员
            if(i==0)
            {
                order.setOrderId(e.getOrderId());
                i++;
            }
            drinkTmp = new OrderDrink();
            drinkTmp.setDrinkId(e.getId());
            drinkTmp.setDrinkInfo(e.getDescription());
            drinkTmp.setDrinkNum(e.getNumber());
            drinkTmp.setDrinkPrice(e.getPrice());
            drinkTmp.setDrinkName(e.getName());
            drinkTmp.setDrinkImage(e.getImage());
            totalPrice+=e.getPrice();
            drinkList.add(drinkTmp);
        }
        Order orderEntry = orderMapper.findOneOrder(order.getOrderId());
        order.setTime(orderEntry.getTime());
        order.setStatus(orderEntry.getStatus());
        order.setDrinkList(drinkList);
        order.setTotal(totalPrice);

        order.setAddress(orderEntry.getAddress());
        order.setPhonenum(orderEntry.getPhonenum());
        order.setName(orderEntry.getName());
        return order;
    }

    public boolean addOneOrderByStr(String openid,String drinkStr,String address,String phoneNum,String name)
    {
        //转对象集合
        JSONArray json = JSONArray.fromObject(drinkStr);
        List<OrderDrink> drinkList = (List<OrderDrink>)JSONArray.toCollection(json, OrderDrink.class);
        //加入时间、订单编号以及取茶号
        Timestamp time=new Timestamp(System.currentTimeMillis()); ;
        int orderId=orderMapper.findLastOrderId()+1;
        double totalPrice = 0;


        SelectInfo selectInfo;

        //拆分drinklist,组成为单条条目，插入数据库
        for(OrderDrink d:drinkList)
        {
            selectInfo =new SelectInfo();
            selectInfo.setId(d.getDrinkId());
            selectInfo.setDescription(d.getDrinkInfo());
            selectInfo.setNumber(d.getDrinkNum());
            selectInfo.setPrice(d.getDrinkPrice());
            selectInfo.setOrderId(orderId);
            totalPrice = totalPrice + d.getDrinkPrice();
            if(orderMapper.addOneSelectInfo(selectInfo)==0)
                return false;
        }

        Order order = new Order();

        order.setOrderId(orderId);
        order.setOpenid(openid);
        order.setTime(time);
        order.setTotal(totalPrice);
        order.setStatus(0);
        order.setAddress(address);
        order.setPhonenum(phoneNum);
        order.setName(name);
        if(orderMapper.addOneOrderInfo(order)==0)
            return false;
        return true;
    }
}
