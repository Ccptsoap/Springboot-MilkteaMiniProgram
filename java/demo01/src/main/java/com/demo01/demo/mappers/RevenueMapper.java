package com.demo01.demo.mappers;

import com.demo01.demo.entity.Admin;
import com.demo01.demo.entity.Revenue;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Soap
 * time 2021-01-09 21:15
 */
@Mapper
@Repository
public interface RevenueMapper {
    List<Revenue> get7DayRevenueInfo();
}
