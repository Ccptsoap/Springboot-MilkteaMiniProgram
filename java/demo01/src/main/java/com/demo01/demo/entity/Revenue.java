package com.demo01.demo.entity;

import java.util.Date;

/**
 * @author Soap
 * time 2021-01-09 21:10
 */
public class Revenue {
    private Date date;
    private String orderNumber;
    private String revenue;

    public Revenue(Date date, String orderNumber, String revenue) {
        this.date = date;
        this.orderNumber = orderNumber;
        this.revenue = revenue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }
}
