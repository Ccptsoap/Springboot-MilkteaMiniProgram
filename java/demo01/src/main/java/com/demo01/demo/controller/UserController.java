package com.demo01.demo.controller;

import com.demo01.demo.dto.LoginInfoDTO;
import com.demo01.demo.entity.User;
import com.demo01.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags="用户控制器")
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


    @PostMapping("login")
    @ApiOperation(value = "登录")
    public User login(@RequestBody LoginInfoDTO loginInfoDTO){
        String openid = loginInfoDTO.getOpenid();
        String nickname = loginInfoDTO.getNickname();
        System.out.println("openid:"+openid+"name:"+nickname);
        User res= userService.login(openid);
        if(res.getOpenid()!=null){
            res.setNickname(nickname);
            userService.setNickName(res);
        }
        return res;
    }



    @GetMapping("findByID")
    @ApiOperation(value = "通过ID查询")
    public User findByID(String openid){
        User res= userService.findByID(openid);
        return res;
    }

    @PostMapping("changeUser")
    @ApiOperation(value = "修改用户信息")
    public String changeUser(String openid, String name, String phonenum, String address){
        User user = new User(openid,name,phonenum,address);
        String res= userService.changeUser(user);
        return res;
    }




}
