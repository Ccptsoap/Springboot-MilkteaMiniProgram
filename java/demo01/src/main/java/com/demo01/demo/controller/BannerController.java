package com.demo01.demo.controller;

import com.demo01.demo.service.BannerService;
import com.demo01.demo.utils.Result;
import com.demo01.demo.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Soap
 * time 2021-01-09 1:07
 */
@RestController
@Api(tags = "页面装饰控制器")
public class BannerController {

    @Autowired
    BannerService bannerService;

    @GetMapping("getBannerImgUrl")
    @ApiOperation(value = "获取banner图片的url")
    public Result<?> getBannerImgUrl() {
        return ResultUtils.success(bannerService.getBannerImgUrl());
    }
}
