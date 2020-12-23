package com.demo01.demo.entity;

import java.sql.Timestamp;
import java.util.List;

public class SelectInfo {
    private String drinkId;
    private int drinkNum;
    private String drinkInfo;
    private double drinkPrice;
    private int orderId;

    public SelectInfo() {
    }

    public SelectInfo(String drinkId, int drinkNum, String drinkInfo, double drinkPrice, int orderId) {
        this.drinkId = drinkId;
        this.drinkNum = drinkNum;
        this.drinkInfo = drinkInfo;
        this.drinkPrice = drinkPrice;
        this.orderId = orderId;
    }

    public String getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(String drinkId) {
        this.drinkId = drinkId;
    }

    public int getDrinkNum() {
        return drinkNum;
    }

    public void setDrinkNum(int drinkNum) {
        this.drinkNum = drinkNum;
    }

    public String getDrinkInfo() {
        return drinkInfo;
    }

    public void setDrinkInfo(String drinkInfo) {
        this.drinkInfo = drinkInfo;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
