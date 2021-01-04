package com.demo01.demo.service;

import com.demo01.demo.entity.MiniOrder;
import com.demo01.demo.entity.Order;

import java.util.List;

public interface OrderService {
     List<Order> findAllOrderByID(String openid);
     List<Order> findAllOrder();
     List<MiniOrder> findAllMiniOrder(String openid);
     List<MiniOrder> findTodayMiniOrder(String openid);
     Order findOneOrder(int orderId);
     boolean addOneOrderByStr(String openid,String drinkStr,String address,String phoneNum,String name);
}
