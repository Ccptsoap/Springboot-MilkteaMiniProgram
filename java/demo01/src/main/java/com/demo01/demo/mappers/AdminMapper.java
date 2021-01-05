package com.demo01.demo.mappers;

import com.demo01.demo.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Soap
 * time 2021-01-06 2:49
 * 管理员登录数据映射
 */
@Mapper
@Repository
public interface AdminMapper {
    Admin findByUsernameAndPassword(String username, String password_md5);
}
