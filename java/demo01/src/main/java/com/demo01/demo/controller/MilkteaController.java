package com.demo01.demo.controller;


import com.demo01.demo.entity.Milktea;
import com.demo01.demo.service.MilkteaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags="奶茶控制器")
public class MilkteaController {
    @Autowired
    MilkteaService milkteaService;

    @GetMapping("recommend")
    @ApiOperation(value = " 首页“为你推荐”")
//    首页“为你推荐”
    public List<Milktea> recommend() {
        return milkteaService.recommend();
    }

    @GetMapping("selectOneMilktea")
    @ApiOperation(value = "根据id返回对应的奶茶")
//    根据id返回对应的奶茶
    public Milktea selectOneMilktea(String id) {
        Milktea milktea = milkteaService.selectOneMilktea(id);
        return milktea;
    }

    @GetMapping("selectAllMilktea")
    @ApiOperation(value = "返回全部奶茶")
//    返回全部奶茶
    public List<Milktea> selectAllMilktea() {
        List<Milktea> milkteas = milkteaService.selectAllMilktea();
        return milkteas;
    }

    @GetMapping("selectByType")
    @ApiOperation(value = "返回对应分类的奶茶")
//    返回对应分类的奶茶
    public List<Milktea> selectByType(String type) {
        List<Milktea> milkteas = milkteaService.selectByType(type);
        return milkteas;
    }

    @GetMapping("selectAllByType")
    @ApiOperation(value = "返回对应分类的奶茶")
//    返回对应分类的奶茶
    public List<List<Milktea>> selectAllByType(String type) {
        List<List<Milktea>> res= new ArrayList<List<Milktea>>();
        for (int i = 0; i < 4; i++) {
            List<Milktea> temp = selectByType(Integer.toString(i+1) );
            res.add(temp);
        }
        return res;
    }

    @GetMapping("countType")
    @ApiOperation(value = "返回奶茶的种类数")
//    返回奶茶的种类数
    public int countType() {
        return milkteaService.countType();
    }

    @GetMapping("countMilktea")
    @ApiOperation(value = "返回奶茶的种类数")
//    返回奶茶的种类数
    public int countMilktea() {
        return milkteaService.countMilktea();
    }
}
