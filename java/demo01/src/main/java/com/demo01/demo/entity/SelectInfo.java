package com.demo01.demo.entity;

/**
 *
 */
public class SelectInfo {
    private String id;
    private int number;
    private String description;
    private double price;
    private int orderId;

    //获取订单详细时使用到
    private String image;
    private String name;



    public SelectInfo() {
    }

    public SelectInfo(String id, int number, String description, double price, int orderId) {
        this.id = id;
        this.number = number;
        this.description = description;
        this.price = price;
        this.orderId = orderId;
    }

    public SelectInfo(String id, int number, String description, double price, int orderId, String image) {
        this.id = id;
        this.number = number;
        this.description = description;
        this.price = price;
        this.orderId = orderId;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
