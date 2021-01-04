package com.demo01.demo.controller;

import com.demo01.demo.entity.BillPrintInfo;
import com.demo01.demo.service.DeliveryService;
import com.demo01.demo.utils.Result;
import com.demo01.demo.utils.ResultUtils;
import com.mysql.jdbc.util.ResultSetUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags="配送控制器")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;
    @GetMapping("/Delivery/BillPrintInfo")
    @ApiOperation(value = "根据ID获取订单信息，用于打印到账单上")
    public Result<?> billPrintInfo(String OrderID)
    {

        return  ResultUtils.success(deliveryService.BILL_PRINT_INFO(OrderID));
    }
    @GetMapping("/Delivery/updateStatus")
    @ApiOperation(value = "更新订单状态")
    void  updateStatus(String orderID){
        deliveryService.UpdateStatus(orderID);
    }
}
