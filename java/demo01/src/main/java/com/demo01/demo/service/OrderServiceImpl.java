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
    public List<Order> findAllOrderByName(String userName)
    {
//        List<SelectInfo> entryList=orderMapper.findAllOrderByName(userName);
//        List<Order> orderList=new ArrayList<>();
//        List<OrderDrink> drinkList=new ArrayList<>();
//        Order orderTmp = new Order();
//        OrderDrink drinkTmp=new OrderDrink();
//        int orderId=-1;
//        double totalPrice=0;
//        //根据订单编号合并订单条目，组成一个完整订单
//        for(SelectInfo e : entryList)
//        {
//            //当前条目属于一个新订单
//            if(orderId!=e.getOrderId())
//            {
//
//                //不是第一个条目才需要添加orderList
//                if(orderId!=-1)
//                {
//                    orderTmp.setTotalPrice(totalPrice);
//                    orderTmp.setDrinkList(drinkList);
//                    orderList.add(orderTmp);
//                }
//
//                //清空上个订单用到的变量
//                orderTmp = new Order();
//                drinkTmp = new OrderDrink();
//                totalPrice = 0;
//                drinkList=new ArrayList<>();
//
//                orderId=e.getOrderId();
//                orderTmp.setOrderId(e.getOrderId());
//                orderTmp.setOrderTime(e.getOrderTime());
//                orderTmp.setPickId(e.getPickId());
//                orderTmp.setUserName(e.getUserName());
//                //加入一种饮品
//                drinkTmp.setDrinkId(e.getDrinkId());
//                drinkTmp.setDrinkInfo(e.getDrinkInfo());
//                drinkTmp.setDrinkName(e.getDrinkName());
//                drinkTmp.setDrinkNum(e.getDrinkNum());
//                drinkTmp.setDrinkPrice(e.getDrinkPrice());
//                totalPrice+=e.getDrinkPrice()*e.getDrinkNum();
//                drinkList.add(drinkTmp);
//
//            }
//            //当前条目与上条条目属于同一个订单，仅添加饮品
//            else
//            {
//                totalPrice+=e.getDrinkPrice()*e.getDrinkNum();
//                drinkTmp = new OrderDrink();
//                drinkTmp.setDrinkId(e.getDrinkId());
//                drinkTmp.setDrinkInfo(e.getDrinkInfo());
//                drinkTmp.setDrinkName(e.getDrinkName());
//                drinkTmp.setDrinkNum(e.getDrinkNum());
//                drinkTmp.setDrinkPrice(e.getDrinkPrice());
//                drinkList.add(drinkTmp);
//            }
//        }
//        orderTmp.setTotalPrice(totalPrice);
//        orderTmp.setDrinkList(drinkList);
//        orderList.add(orderTmp);
//        return orderList;
        return null;
    }
    public List<MiniOrder> findAllMiniOrder(String userName)
    {
        List<MiniOrderEntry> entryList=orderMapper.findAllMiniOrder(userName);
        List<MiniOrder> orderList=new ArrayList<>();
        List<String> drinkIdList=new ArrayList<>();
        MiniOrder orderTmp = new MiniOrder();
        String drinkId;
        int orderId=-1;
        double totalPrice=0;
        //查询结果为空
        if(entryList.size()==0)
            return null;
        //根据订单编号合并订单条目，组成一个完整订单
        for(MiniOrderEntry e : entryList)
        {
            //当前条目属于一个新订单
            if(orderId!=e.getOrderId())
            {
                //不是第一个条目才需要添加orderList
                if(orderId!=-1)
                {
                    orderTmp.setTotalPrice(totalPrice);
                    orderTmp.setDrinkIdList(drinkIdList);
                    orderList.add(orderTmp);
                }
                //清空上个订单用到的变量
                orderTmp = new MiniOrder();
                drinkIdList=new ArrayList<>();
                totalPrice = 0;
                //不是第一个条目才需要清空drinkList
                if(orderId!=-1)
                    drinkIdList.clear();
                //
                orderId=e.getOrderId();
                orderTmp.setOrderId(e.getOrderId());
                orderTmp.setOrderTime(e.getOrderTime());
                orderTmp.setUserName(e.getUserName());
                totalPrice+=e.getDrinkPrice()*e.getDrinkNum();
                //加入一种饮品
                drinkIdList.add(e.getDrinkId());

            }
            //当前条目与上条条目属于同一个订单，仅添加饮品
            else
            {
                totalPrice+=e.getDrinkPrice()*e.getDrinkNum();
                drinkIdList.add(e.getDrinkId());
            }
        }
        orderTmp.setTotalPrice(totalPrice);
        orderTmp.setDrinkIdList(drinkIdList);
        orderList.add(orderTmp);
        return orderList;
    }
    public List<MiniOrder> findTodayMiniOrder(String userName)
    {
        List<MiniOrderEntry> entryList=orderMapper.findTodayMiniOrder(userName);
        List<MiniOrder> orderList=new ArrayList<>();
        List<String> drinkIdList=new ArrayList<>();
        MiniOrder orderTmp = new MiniOrder();
        int drinkId;
        int orderId=-1;
        double totalPrice=0;
        //查询结果为空
        if(entryList.size()==0)
            return null;
        //根据订单编号合并订单条目，组成一个完整订单
        for(MiniOrderEntry e : entryList)
        {
            //当前条目属于一个新订单
            if(orderId!=e.getOrderId())
            {
                //不是第一个条目才需要添加orderList
                if(orderId!=-1)
                {
                    orderTmp.setTotalPrice(totalPrice);
                    orderTmp.setDrinkIdList(drinkIdList);
                    orderList.add(orderTmp);
                }
                //清空上个订单用到的变量
                orderTmp = new MiniOrder();
                drinkIdList=new ArrayList<>();
                totalPrice = 0;
                //不是第一个条目才需要清空drinkList
                if(orderId!=-1)
                    drinkIdList.clear();
                //
                orderId=e.getOrderId();
                orderTmp.setOrderId(e.getOrderId());
                orderTmp.setOrderTime(e.getOrderTime());
                orderTmp.setUserName(e.getUserName());
                totalPrice+=e.getDrinkPrice()*e.getDrinkNum();
                //加入一种饮品
                drinkIdList.add(e.getDrinkId());

            }
            //当前条目与上条条目属于同一个订单，仅添加饮品
            else
            {
                totalPrice+=e.getDrinkPrice()*e.getDrinkNum();
                drinkIdList.add(e.getDrinkId());
            }
        }

        orderTmp.setTotalPrice(totalPrice);
        orderTmp.setDrinkIdList(drinkIdList);
        orderList.add(orderTmp);
        return orderList;
    }
    public Order findOneOrder(String userName, int orderId)
    {
//        List<SelectInfo> entryList=orderMapper.findOneOrder(userName,orderId);
//        Order order=new Order();
//        List<OrderDrink> drinkList=new ArrayList<>();
//        OrderDrink drinkTmp=new OrderDrink();
//        double totalPrice=0;
//        int i=0;
//        //合并订单条目，组成一个完整订单
//        for(SelectInfo e : entryList)
//        {
//            //第一个条目设置订单除饮品外的成员
//            if(i==0)
//            {
//                order.setOrderId(e.getOrderId());
//                order.setOrderTime(e.getOrderTime());
//                order.setPickId(e.getPickId());
//                order.setUserName(e.getUserName());
//                i++;
//            }
//            drinkTmp = new OrderDrink();
//            drinkTmp.setDrinkId(e.getDrinkId());
//            drinkTmp.setDrinkInfo(e.getDrinkInfo());
//            drinkTmp.setDrinkName(e.getDrinkName());
//            drinkTmp.setDrinkNum(e.getDrinkNum());
//            drinkTmp.setDrinkPrice(e.getDrinkPrice());
//            totalPrice+=e.getDrinkPrice()*e.getDrinkNum();
//            drinkList.add(drinkTmp);
//        }
//        order.setDrinkList(drinkList);
//        order.setTotalPrice(totalPrice);
//        return order;
        return null;
    }
//    public boolean addOneOrder(Order order)
//    {
//        //加入时间、订单编号以及取茶号
//        Timestamp time=new Timestamp(System.currentTimeMillis()); ;
//        int orderId=orderMapper.findLastOrderId()+1;
//
//        SelectInfo selectInfo;
//        List<OrderDrink> drinkList=order.getDrinkList();
//        //拆分drinklist,组成为单条条目，插入数据库
//        for(OrderDrink d:drinkList)
//        {
//            selectInfo =new SelectInfo();
//            selectInfo.setUserName(order.getUserName());
//            selectInfo.setDrinkId(d.getDrinkId());
//            selectInfo.setDrinkInfo(d.getDrinkInfo());
//            selectInfo.setDrinkName(d.getDrinkName());
//            selectInfo.setDrinkNum(d.getDrinkNum());
//            selectInfo.setDrinkPrice(d.getDrinkPrice());
//            selectInfo.setOrderId(orderId);
//            selectInfo.setOrderTime(time);
//            if(orderMapper.addOneOrder(selectInfo)==0)
//                return false;
//        }
//        return true;
//    }
    public boolean addOneOrderByStr(String openid,String drinkStr)
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
            selectInfo.setDrinkId(d.getDrinkId());
            selectInfo.setDrinkInfo(d.getDrinkInfo());
            selectInfo.setDrinkNum(d.getDrinkNum());
            selectInfo.setDrinkPrice(d.getDrinkPrice());
            selectInfo.setOrderId(orderId);
            totalPrice = totalPrice + d.getDrinkPrice();
            if(orderMapper.addOneSelectInfo(selectInfo)==0)
                return false;
        }
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOpenid(openid);
        orderInfo.setOrderId(orderId);
        orderInfo.setTimestamp(time);
        orderInfo.setTotal(totalPrice);
        orderInfo.setStatu("制作中");
        if(orderMapper.addOneOrderInfo(orderInfo)==0)
            return false;
        return true;
    }
}
