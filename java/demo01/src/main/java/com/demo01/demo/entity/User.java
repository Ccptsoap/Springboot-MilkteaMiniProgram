package com.demo01.demo.entity;


public class User {
    private String openid;
    private String name;
    private String phonenum;
    private String nickname;
    private String address;

    public User() {
    }

    public User(String openid, String name, String phonenum, String address) {
        this.openid = openid;
        this.name = name;
        this.phonenum = phonenum;
        this.address = address;
    }

    public User(String openid) {
        this.openid = openid;
    }

    public User(String openid, String name, String phonenum, String nickname, String address) {
        this.openid = openid;
        this.name = name;
        this.phonenum = phonenum;
        this.nickname = nickname;
        this.address = address;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
