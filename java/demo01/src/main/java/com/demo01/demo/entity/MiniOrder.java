package com.demo01.demo.entity;

import java.sql.Timestamp;
import java.util.List;

/**
 * 获取缩略订单
 */
public class MiniOrder {
    private String openid;
    private List<String> drinkIdList;
    private List<String> imageList;
    private Timestamp orderTime;
    private int orderId;
    private double total;

    public MiniOrder() {
    }

    public MiniOrder(String openid, List<String> drinkIdList, List<String> imageList, Timestamp orderTime, int orderId, double total) {
        this.openid = openid;
        this.drinkIdList = drinkIdList;
        this.imageList = imageList;
        this.orderTime = orderTime;
        this.orderId = orderId;
        this.total = total;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public List<String> getDrinkIdList() {
        return drinkIdList;
    }

    public void setDrinkIdList(List<String> drinkIdList) {
        this.drinkIdList = drinkIdList;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
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
}
