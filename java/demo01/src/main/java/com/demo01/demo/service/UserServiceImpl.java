package com.demo01.demo.service;

import com.demo01.demo.entity.User;
import com.demo01.demo.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String openid) {
        if(openid.equals("")){
            System.out.println("ID是空的，无法登陆");
            return new User();
        }
       User successUser=userMapper.login(openid);
        if(null==successUser){
            this.logon(openid);
            User user = new User();
            user.setOpenid(openid);
            return user;
        }
       return successUser;
    }

    @Override
    public User findByID(String openid) {
        if(openid.equals("")){
            System.out.println("ID是空的，无法查找");
            User user = new User();
            return user;
        }
        User successUser=userMapper.findByID(openid);
        return successUser;
    }



    @Override
    public String changeUser(User user) {
//        调用 mapper中的方法
        User beforeUser = userMapper.findByID(user.getOpenid());
        if(beforeUser==null){
            return "您尚未登录，请先登录！！！！";
        }
        else{
            int count=userMapper.changeUser(user);
            if(count==0){
                return "修改失败，请稍后修改";
            }
            return "修改成功";
        }
    }

    @Override
    public String logon(String openid) {
        userMapper.logon(openid);
        return "";
    }

    @Override
    public int setNickName(User user) {
        return userMapper.setNickname(user);
    }
}
