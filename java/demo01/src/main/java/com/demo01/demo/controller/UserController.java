package com.demo01.demo.controller;

import com.demo01.demo.dto.LoginInfoDTO;
import com.demo01.demo.entity.Admin;
import com.demo01.demo.entity.User;
import com.demo01.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(tags = "用户控制器")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("login")
    @ApiOperation(value = "登录")
    public User login(@RequestBody LoginInfoDTO loginInfoDTO) {
        String openid = loginInfoDTO.getOpenid();
        String nickname = loginInfoDTO.getNickname();
        System.out.println("openid:" + openid + "name:" + nickname);
        User res = userService.login(openid);
        if (res.getOpenid() != null) {
            res.setNickname(nickname);
            userService.setNickName(res);
        }
        return res;
    }

    @GetMapping("findByID")
    @ApiOperation(value = "通过ID查询")
    public User findByID(String openid) {
        return userService.findByID(openid);
    }

    @PostMapping("changeUser")
    @ApiOperation(value = "修改用户信息")
    public String changeUser(@RequestBody User user) {
        System.out.println("修改信息的用户姓名" + user.getName());
        return userService.changeUser(user);
    }

//    @PostMapping("changeUser")
//    @ApiOperation(value = "修改用户信息")
//    public String changeUser(String openid, String name, String phonenum, String address) {
//        System.out.println("修改信息的用户openid：" + openid);
//        User user = new User(openid, name, phonenum, address);
//        return userService.changeUser(user);
//    }



}
