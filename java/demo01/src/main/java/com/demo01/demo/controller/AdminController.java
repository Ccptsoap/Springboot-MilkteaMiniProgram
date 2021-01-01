package com.demo01.demo.controller;

import com.demo01.demo.entity.Milktea;
import com.demo01.demo.service.MilkteaService;
import com.demo01.demo.utils.Result;
import com.demo01.demo.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags="管理员控制器")
public class AdminController {

    @Autowired
    MilkteaService milkteaService;

    @GetMapping("/admin/milktea")
    @ApiOperation(value = "获取奶茶列表")
    public Result<?> getMilkteaList() {
        return ResultUtils.success(milkteaService.selectAllMilktea());
    }

    @GetMapping("/admin/milktea/{milkteaId}")
    @ApiOperation(value = "根据ID查询奶茶")
    public Result<?> getMilkteaById(@PathVariable("milkteaId") String milkteaId) {
        return ResultUtils.success(milkteaService.selectOneMilktea(milkteaId));
    }
    @PutMapping("/admin/milktea")
    @ApiOperation(value = "根据ID修改奶茶")
    public Result<?> updateMilkteaInfo(@RequestBody Milktea milktea) {
        return ResultUtils.success(milkteaService.updateMilktea(milktea));
    }
    @PostMapping("/admin/milktea")
    @ApiOperation(value = "新增奶茶信息")
    public Result<?> saveMilkteaInfo(@RequestBody Milktea milktea) {
        return ResultUtils.success(milkteaService.saveMilktea(milktea));
    }
    @PostMapping("/admin/milktea/{milkteaId}")
    @ApiOperation(value = "删除奶茶信息")
    public Result<?> deleteMilkteaInfo(@PathVariable("milkteaId") String milkteaId) {
        return ResultUtils.success(milkteaService.deleteMilktea(milkteaId));
    }


}
