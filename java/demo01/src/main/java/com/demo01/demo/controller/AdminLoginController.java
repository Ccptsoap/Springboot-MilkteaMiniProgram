package com.demo01.demo.controller;

import com.demo01.demo.entity.Admin;
import com.demo01.demo.service.AdminService;
import com.demo01.demo.utils.Result;
import com.demo01.demo.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author Soap
 * time 2021-01-06 3:05
 * 管理员登录控制器
 */
@RestController
@Api(tags = "管理员登录控制器")
public class AdminLoginController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/login")
    @ApiOperation(value = "管理员登录")
    public Result<?> login(@RequestParam String username,
                           @RequestParam String password_md5,
                           HttpSession session) {
        Admin admin = adminService.checkAdmin(username, password_md5);
        if (admin != null) {
//            admin.setPassword_md5("");
            session.setAttribute("admin",admin);
            return ResultUtils.success(admin);
        }else
        {
            return ResultUtils.error(-14,"用户名或密码错误");
        }
    }
}
