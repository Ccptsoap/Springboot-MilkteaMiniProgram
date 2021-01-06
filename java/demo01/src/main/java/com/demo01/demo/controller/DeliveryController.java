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

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags="配送控制器")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;
    @GetMapping("/Delivery/BillPrintInfo")
    @ApiOperation(value = "根据ID获取订单信息，用于打印到账单上")
    public Result<?> billPrintInfo(String OrderID)
    {
        class Response{
            String orderid;
            List<String> MKnames;
            String name;//收货人姓名
            String Address;
            List<String> Description;
            String PhoneNum;
            String Total;
            public String toString(){
                String result="订单编号"+orderid;

                if (!MKnames.isEmpty()){
                    result=result+"\n购买清单:"+MKnames.toString();
                }
                if(!name.isEmpty()){
                    result=result+"\n收货人:"+name;
                }
                if (!PhoneNum.isEmpty()){
                    result=result+"\n手机号"+PhoneNum;
                }
                if(!Address.isEmpty()){
                    result=result+"\n收货地址"+Address;
                }
                if(!Description.isEmpty())
                {
                    result=result+"\n备注" +Description;
                }
                result=result+"\n总价"+Total;

                return result;
            }
            public String getOrderid() {
                return orderid;
            }

            public void setOrderid(String orderid) {
                this.orderid = orderid;
            }

            public List<String> getMKnames() {
                return MKnames;
            }

            public void setMKnames(List<String> MKnames) {
                this.MKnames = MKnames;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }


            public String getTotal() {
                return Total;
            }

            public void setTotal(String total) {
                Total = total;
            }

            public String getPhoneNum() {
                return PhoneNum;
            }

            public void setPhoneNum(String phoneNum) {
                PhoneNum = phoneNum;
            }

            public String getAddress() {
                return Address;
            }

            public void setAddress(String address) {
                Address = address;
            }

            public List<String> getDescription() {
                return Description;
            }

            public void setDescription(List<String> description) {
                Description = description;
            }
        }
        List<BillPrintInfo> BPI=deliveryService.BILL_PRINT_INFO(OrderID);
        Response response=new Response();
        response.setOrderid(BPI.get(0).getOrderID());
        System.out.println(BPI.get(0).getOrderID());
        response.setAddress(BPI.get(0).getAddress());
        System.out.println(BPI.get(0).getAddress());
        List<String> Mknames = new ArrayList<>();
        List<String> Description=new ArrayList<>();
        float price=0;
        int i=BPI.size()-1;
        while (i>=0){
            System.out.println(BPI.get(i).getMilkTeaName());
            Mknames.add(BPI.get(i).getMilkTeaName());
            Description.add(BPI.get(i).getMilkTeaName()+":"+BPI.get(i).getDescription());
            System.out.println(BPI.get(i).getDescription());
            price=price+Float.valueOf(BPI.get(i).getPrice());
            i-=1;
        }
        response.setMKnames(Mknames);
        response.setDescription(Description);
        response.setTotal(String.valueOf(price));
        response.setName(BPI.get(0).getName());
        response.setPhoneNum(BPI.get(0).getPhoneNum());

        return  ResultUtils.success(response);
    }
    @GetMapping("/Delivery/updateStatus")
    @ApiOperation(value = "更新订单状态")
    void  updateStatus(String orderID){
        deliveryService.UpdateStatus(orderID);
    }
}
