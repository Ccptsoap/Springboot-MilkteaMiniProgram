package com.demo01.demo.entity;

import java.sql.Timestamp;

public class OrderInfo {
    private int orderId;
    private String openid;
    private Timestamp timestamp;
    private double total;
    private String statu;


    public OrderInfo() {
    }

    public OrderInfo(int orderId, String openid, Timestamp timestamp, double total, String statu) {
        this.orderId = orderId;
        this.openid = openid;
        this.timestamp = timestamp;
        this.total = total;
        this.statu = statu;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }
}
