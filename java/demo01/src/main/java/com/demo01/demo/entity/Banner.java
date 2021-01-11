package com.demo01.demo.entity;

/**
 * @author Soap
 * time 2021-01-10 23:26
 */
public class Banner {
    String id;
    String image;

    public Banner(String id, String image) {
        this.id = id;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
