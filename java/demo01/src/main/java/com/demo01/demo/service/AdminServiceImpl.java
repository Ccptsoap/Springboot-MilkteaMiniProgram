package com.demo01.demo.service;

import com.demo01.demo.entity.Admin;
import com.demo01.demo.mappers.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Soap
 * time 2021-01-06 2:44
 * 管理员登录实现
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin CheckAdmin(String username, String password_md5) {
        System.out.println("查询数据库，用户名：" + username + " 密码：" + password_md5);
        Admin admin = adminMapper.findByUsernameAndPassword(username, password_md5);
        return admin;
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminMapper.getAllAdmin();
    }
}
