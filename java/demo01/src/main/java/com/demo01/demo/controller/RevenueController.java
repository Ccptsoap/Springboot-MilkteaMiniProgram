package com.demo01.demo.controller;

import com.demo01.demo.service.RevenueService;
import com.demo01.demo.utils.Result;
import com.demo01.demo.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Soap
 * time 2021-01-09 21:18
 */
@RestController
@Api(tags = "营收情况控制器")
public class RevenueController {

    @Autowired
    RevenueService revenueService;

    @GetMapping("/get7DayRevenueInfo")
    @ApiOperation(value = "获取奶茶列表")
    public Result<?> get7DayRevenueInfo() {
        return ResultUtils.success(revenueService.get7DayRevenueInfo());
    }
}
