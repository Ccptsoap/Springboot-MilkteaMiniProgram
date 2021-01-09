package com.demo01.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * NULL
 */
public class Milktea {
//    @ExcelProperty(value = "编号",index = 0)
    String id;
//    @ExcelProperty(value = "品名",index = 1)
    String name;
//    @ExcelProperty(value = "单价",index = 2)
    String price;
//    @ExcelProperty(value = "类型编号",index = 3)
    String type;
//    @ExcelProperty(value = "类型",index = 4)
    String typeName;
//    @ExcelProperty(value = "展示图片",index = 5)
    String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Milktea() {}

}
