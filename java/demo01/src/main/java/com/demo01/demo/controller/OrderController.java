package com.demo01.demo.controller;

import com.demo01.demo.entity.MiniOrder;
import com.demo01.demo.entity.Order;
import com.demo01.demo.entity.SelectInfo;
import com.demo01.demo.mappers.OrderMapper;
import com.demo01.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderMapper orderMapper;

/*    @RequestMapping("testO1")
    public List<Order> testO1(){
        //调用mapper层的方法
        return orderService.findAllOrderByName("amy");
    }*/
    //查询用户所有订单详细信息
    @RequestMapping("findAllOrderByName")
    public List<Order> findAllOrderByName(String userName)
    {
        return orderService.findAllOrderByName(userName);
    }

    //查询用户今日订单缩略信息
    @RequestMapping("findTodayMiniOrder")
    public List<MiniOrder> findTodayMiniOrder(String userName)
    {
        return orderService.findTodayMiniOrder(userName);
    }
    //查询用户所有订单缩略信息
    @RequestMapping("findAllMiniOrder")
    public List<MiniOrder> findAllMiniOrder(String userName)
    {
        return orderService.findAllMiniOrder(userName);
    }

    //查询一个订单的详细信息
    @RequestMapping("findOneOrder")
    public Order findOneOrder(String userName,int orderId)
    {
        return orderService.findOneOrder(userName,orderId);
    }

    //////////test
    //查询用户所有订单
//    @RequestMapping("test")
//    public int test()
//    {
//        Timestamp time=new Timestamp(System.currentTimeMillis()); ;
//        SelectInfo selectInfo = new SelectInfo();
//        selectInfo.setUserName("bob");
//        selectInfo.setDrinkId("0001");
//        selectInfo.setDrinkInfo("全糖");
//        selectInfo.setDrinkName("烤奶");
//        selectInfo.setDrinkNum(1);
//        selectInfo.setDrinkPrice(10);
//        selectInfo.setOrderId(114);
//        selectInfo.setOrderTime(time);
//        selectInfo.setPickId(122);
//        return orderMapper.addOneOrder(selectInfo);
//    }



    //增加一个订单条目
    @RequestMapping("addOneOrderByStr")
    public boolean addOneOrderByStr(String openid,String drinkStr)
    {

        return orderService.addOneOrderByStr(openid,drinkStr);
    }

}
