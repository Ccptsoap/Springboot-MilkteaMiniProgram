package com.demo01.demo.entity;

import java.sql.Timestamp;

/**
 * 获取缩略订单，entry直接与数据库对接
 */
public class MiniOrderEntry {
    private String openid;
    private String Id;
    private Timestamp time;
    private int orderId;
    private double price;
    private int number;
    private String image;

    public MiniOrderEntry() {
    }

    public MiniOrderEntry(String openid, String id, Timestamp time, int orderId, double price, int number, String image) {
        this.openid = openid;
        Id = id;
        this.time = time;
        this.orderId = orderId;
        this.price = price;
        this.number = number;
        this.image = image;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
