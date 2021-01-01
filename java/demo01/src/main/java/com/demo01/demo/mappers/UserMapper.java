package com.demo01.demo.mappers;

import com.demo01.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    public User login(String openid);
    public User findByID(String openid);
    public int changeUser(User user);
    public int logon(String openid);
    public int setNickname(User user);
}
