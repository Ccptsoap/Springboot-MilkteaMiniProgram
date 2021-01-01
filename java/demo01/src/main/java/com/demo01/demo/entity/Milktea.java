package com.demo01.demo.entity;

/**
 * NULL
 */
public class Milktea {
    String id;
    String name;
    String price;
    String type;
    String type_name;
    String image;

    public Milktea(String id, String name, String price, String type, String type_name, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.type_name = type_name;
        this.image = image;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
