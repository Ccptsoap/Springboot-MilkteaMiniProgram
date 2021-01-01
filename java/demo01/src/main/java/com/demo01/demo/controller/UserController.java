package com.demo01.demo.controller;

import com.demo01.demo.entity.User;
import com.demo01.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

//  自动装配
    @Autowired
    UserService userService;

//
//    @RequestMapping("change")
//    public boolean test01(User user){
//        boolean res= userService.changeOne(user);
//        return res;
//    }
//


    @RequestMapping("login")
    public User login(String openid,String nickname){
        System.out.println("openid:"+openid+"name:"+nickname);
        User res= userService.login(openid);
        if(res.getOpenid()!=null){
            res.setNickname(nickname);
            userService.setNickName(res);
        }
        return res;
    }



    @RequestMapping("findByID")
    public User findByID(String openid){
        User res= userService.findByID(openid);
        return res;
    }

    @RequestMapping("changeUser")
    public String changeUser(String openid, String name, String phonenum, String address){
        User user = new User(openid,name,phonenum,address);
        String res= userService.changeUser(user);
        return res;
    }




}
