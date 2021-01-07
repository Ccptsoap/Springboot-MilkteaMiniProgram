package com.demo01.demo.service;

import com.demo01.demo.entity.Admin;

import java.util.List;

/**
 * @author Soap
 * time 2021-01-06 2:40
 * 管理员登录
 */
public interface AdminService {

    Admin checkAdmin(String username, String password_md5);
    List<Admin> getAllAdmin();
    Admin getAdminInfoByUsername(String username);
}
