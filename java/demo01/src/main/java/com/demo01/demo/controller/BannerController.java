package com.demo01.demo.controller;

import com.demo01.demo.service.BannerService;
import com.demo01.demo.utils.Result;
import com.demo01.demo.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Soap
 * time 2021-01-09 1:07
 */
@RestController
@Api(tags = "页面装饰控制器")
public class BannerController {

    @Autowired
    BannerService bannerService;

    @GetMapping("/getBannerImgUrl")
    @ApiOperation(value = "获取banner图片的url")
    public Result<?> getBannerImgUrl() {
        return ResultUtils.success(bannerService.getBannerImgUrl());
    }

    @PostMapping("/admin/uploadBannerImgUrl")
    @ApiOperation(value = "更新banner图片的url")
    public Result<?> uploadBannerImgUrl(String id, String image) {
        System.out.println("uploadBannerImgUrl：获取到id：" + id + "获取到URL：" + image);
        Integer res = bannerService.uploadBannerImgUrl(id, image);
        if (res == 1) {
            return ResultUtils.success();
        } else {
            return ResultUtils.error(-15, "找不到ID指定的Banner");
        }
    }
    @PostMapping("/getCosBannerImg")
    @ApiOperation(value = "获取腾讯云COS中全部Banner图片")
    public Result<?> getCosMilkteaImg() {
        List<String> imgUrl = bannerService.getCosBannerImg();
        return ResultUtils.success(imgUrl);
    }
}
