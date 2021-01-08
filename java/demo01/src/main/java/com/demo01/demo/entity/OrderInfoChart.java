package com.demo01.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

//用于展示每日订单量
public class OrderInfoChart extends BaseRowModel {
    @ExcelProperty(value = "时间",index = 0)
    String time;
    @ExcelProperty(value = "订单数",index = 1)
    int orderNum;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
}
