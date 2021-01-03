package com.demo01.demo.entity;

import java.sql.Timestamp;
import java.util.List;

/**
 * 对应数据库 orderInfo
 */
public class Order {
    private String openid;
    private Timestamp time;
    private int orderId;
    private double total;

    private int status;
    private String address;
    private String phonenum;
    private String name;

    //获取订单详细时使用到
    private List<OrderDrink> drinkList;

    public Order() {
    }

    public Order(String openid, Timestamp time, int orderId, double total, int status, String address, String phonenum, String name) {
        this.openid = openid;
        this.time = time;
        this.orderId = orderId;
        this.total = total;
        this.status = status;
        this.address = address;
        this.phonenum = phonenum;
        this.name = name;
    }

    public Order(String openid, Timestamp time, int orderId, double total, int status, String address, String phoneNum, String name, List<OrderDrink> drinkList) {
        this.openid = openid;
        this.time = time;
        this.orderId = orderId;
        this.total = total;
        this.status = status;
        this.address = address;
        this.phonenum = phoneNum;
        this.name = name;
        this.drinkList = drinkList;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrderDrink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<OrderDrink> drinkList) {
        this.drinkList = drinkList;
    }
}
