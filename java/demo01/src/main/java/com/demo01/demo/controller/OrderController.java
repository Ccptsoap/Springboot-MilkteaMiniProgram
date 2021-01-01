package com.demo01.demo.controller;

import com.demo01.demo.entity.MiniOrder;
import com.demo01.demo.entity.Order;
import com.demo01.demo.entity.SelectInfo;
import com.demo01.demo.mappers.OrderMapper;
import com.demo01.demo.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@Api(tags="订单控制器")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderMapper orderMapper;


    //查询用户所有订单详细信息
    @GetMapping("findAllOrderByID")
    @ApiOperation(value = "查询用户所有订单详细信息")
    public List<Order> findAllOrderByID(String openid)
    {
        return orderService.findAllOrderByID(openid);
    }

    //查询用户今日订单缩略信息
    @GetMapping("findTodayMiniOrder")
    @ApiOperation(value = "查询用户今日订单缩略信息")
    public List<MiniOrder> findTodayMiniOrder(String openid)
    {
        return orderService.findTodayMiniOrder(openid);
    }
    //查询用户所有订单缩略信息
    @GetMapping("findAllMiniOrder")
    @ApiOperation(value = "查询用户所有订单缩略信息")
    public List<MiniOrder> findAllMiniOrder(String openid)
    {
        return orderService.findAllMiniOrder(openid);
    }

    //查询一个订单的详细信息
    @GetMapping("findOneOrder")
    @ApiOperation(value = "查询一个订单的详细信息")
    public Order findOneOrder(int orderId)
    {
        return orderService.findOneOrder(orderId);
    }

    //查询用户所有订单




    //增加一个订单条目
    @PostMapping("addOneOrderByStr")
    @ApiOperation(value = "增加一个订单条目")
    public boolean addOneOrderByStr(String openid,String drinkStr,String address,String phoneNum,String name)
    {

        return orderService.addOneOrderByStr(openid,drinkStr,address,phoneNum,name);
    }

}
