package com.demo01.demo.service;

import com.demo01.demo.entity.MiniOrder;
import com.demo01.demo.entity.Order;

import java.util.List;

public interface OrderService {
    public List<Order> findAllOrderByID(String openid);
    public List<MiniOrder> findAllMiniOrder(String openid);
    public List<MiniOrder> findTodayMiniOrder(String openid);
    public Order findOneOrder(int orderId);
    public boolean addOneOrderByStr(String openid,String drinkStr,String address,String phoneNum,String name);
}
