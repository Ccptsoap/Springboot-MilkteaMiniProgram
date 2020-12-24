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


    //查询用户所有订单详细信息
    @RequestMapping("findAllOrderByID")
    public List<Order> findAllOrderByID(String openid)
    {
        return orderService.findAllOrderByID(openid);
    }

    //查询用户今日订单缩略信息
    @RequestMapping("findTodayMiniOrder")
    public List<MiniOrder> findTodayMiniOrder(String openid)
    {
        return orderService.findTodayMiniOrder(openid);
    }
    //查询用户所有订单缩略信息
    @RequestMapping("findAllMiniOrder")
    public List<MiniOrder> findAllMiniOrder(String openid)
    {
        return orderService.findAllMiniOrder(openid);
    }

    //查询一个订单的详细信息
    @RequestMapping("findOneOrder")
    public Order findOneOrder(int orderId)
    {
        return orderService.findOneOrder(orderId);
    }

    //查询用户所有订单




    //增加一个订单条目
    @RequestMapping("addOneOrderByStr")
    public boolean addOneOrderByStr(String openid,String drinkStr,String address,String phoneNum,String name)
    {

        return orderService.addOneOrderByStr(openid,drinkStr,address,phoneNum,name);
    }

}
