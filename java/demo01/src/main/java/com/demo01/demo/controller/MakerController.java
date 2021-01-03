package com.demo01.demo.controller;

import com.demo01.demo.service.MakerService;
import com.demo01.demo.service.MilkteaService;
import com.demo01.demo.utils.Result;
import com.demo01.demo.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(tags="制作员控制器")
public class MakerController {
    @Resource
    MakerService makerService;

    @GetMapping("/maker/orders")
    @ApiOperation(value = "查看订单信息")
    public Result<?> showAllOrderForMaker(){
        return ResultUtils.success(makerService.showAllOrderForMaker());
    }

}
