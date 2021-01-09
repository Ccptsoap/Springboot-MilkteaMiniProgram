package com.demo01.demo.service;

import com.demo01.demo.entity.Admin;
import com.demo01.demo.entity.Revenue;
import com.demo01.demo.mappers.AdminMapper;
import com.demo01.demo.mappers.RevenueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Soap
 * time 2021-01-09 21:14
 */

@Service
public class RevenueServiceImpl implements RevenueService {
    @Autowired
    RevenueMapper revenueMapper;

    @Override
    public List<Revenue> get7DayRevenueInfo() {
        List<Revenue> revenues = revenueMapper.get7DayRevenueInfo();
        return revenues;
    }
}
