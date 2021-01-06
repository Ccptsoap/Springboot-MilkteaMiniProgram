package com.demo01.demo.entity;

/**
 * @author Soap
 * time 2021-01-06 2:41
 */
public class Admin {
    private int id;
    private String username;
    private String password_md5;

    public Admin() {

    }

    public Admin(int id, String username, String password_md5) {
        this.id = id;
        this.username = username;
        this.password_md5 = password_md5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_md5() {
        return password_md5;
    }

    public void setPassword_md5(String password_md5) {
        this.password_md5 = password_md5;
    }


}
