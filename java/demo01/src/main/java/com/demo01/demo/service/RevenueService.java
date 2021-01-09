package com.demo01.demo.service;

import com.demo01.demo.entity.Admin;
import com.demo01.demo.entity.Revenue;

import java.util.List;

/**
 * @author Soap
 * time 2021-01-09 21:14
 */
public interface RevenueService {
    List<Revenue> get7DayRevenueInfo();
}
