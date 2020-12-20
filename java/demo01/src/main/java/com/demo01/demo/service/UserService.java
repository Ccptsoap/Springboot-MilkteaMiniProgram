package com.demo01.demo.service;

import com.demo01.demo.entity.User;


import java.util.List;

public interface UserService {
//    登录
    public User login(String openid);
//    按openid搜索
    public User findByID(String openid);
//    修改个人信息
    public String changeUser(User user);
    public String logon(String openid);
    public int setNickName(User user);
}
