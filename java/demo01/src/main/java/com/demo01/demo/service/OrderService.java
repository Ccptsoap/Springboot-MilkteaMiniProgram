package com.demo01.demo.service;

import com.demo01.demo.entity.MiniOrder;
import com.demo01.demo.entity.Order;
import com.demo01.demo.entity.OrderForMaker;
import com.demo01.demo.entity.OrderInfoChart;

import java.util.List;

public interface OrderService {
     List<Order> findAllOrderByID(String openid);
     List<Order> findAllOrder();
     List<Order> findAllMakingOrder();
     List<Order> findAllCompletedOrder();
     List<MiniOrder> findAllMiniOrder(String openid);
     List<MiniOrder> findMakingMiniOrder(String openid);
     List<MiniOrder> findCompletedMiniOrder(String openid);
     Order findOneOrder(int orderId);
     boolean addOneOrderByStr(String openid,String drinkStr,String address,String phoneNum,String name);
     Integer getTodayOrderNum();

     List<OrderInfoChart> getOrderInfo_anyTime(int days);
}
