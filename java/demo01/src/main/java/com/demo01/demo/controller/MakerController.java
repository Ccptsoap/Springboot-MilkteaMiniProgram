package com.demo01.demo.controller;

import com.demo01.demo.entity.OrderForMaker;
import com.demo01.demo.service.MakerService;
import com.demo01.demo.service.MilkteaService;
import com.demo01.demo.utils.Result;
import com.demo01.demo.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@RestController
@Api(tags="制作员控制器")
public class MakerController {
    @Resource
    MakerService makerService;
    class Response{
        private String orderid;
        private List<String> names;
        private List<String> Description;
        private String Time;
        public Response prase(List<OrderForMaker> ofms){
            this.orderid=ofms.get(0).getOrderID();
            this.Time=ofms.get(0).getTime();

            int i=ofms.size()-1;
            this.names=new LinkedList<>();
            this.Description=new LinkedList<>();
            while (i>=0){

                this.names.add(ofms.get(i).getName());
                this.Description.add(ofms.get(i).getName()+":"+ofms.get(i).getDescription());
                i-=1;
            }
            return this;
        }



        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public List<String> getNames() {
            return names;
        }

        public void setNames(List<String> names) {
            this.names = names;
        }

        public List<String> getDescription() {
            return Description;
        }

        public void setDescription(List<String> description) {
            Description = description;
        }

        public String getTime() {
            return Time;
        }

        public void setTime(String time) {
            Time = time;
        }
    }
    @GetMapping("/maker/orders")
    @ApiOperation(value = "查看订单信息")
    public Result<?> showAllOrderForMaker(){

        List<Response> rspss=new LinkedList<>();
        List<OrderForMaker> ofmss=new LinkedList<>();
        try {


            ofmss = makerService.showAllOrderForMaker();
            ofmss.get(0);
        }
        catch (Exception e){
            return ResultUtils.success("今日已无订单");
        }
        int i=ofmss.size();
        int j=0;
        int from=0;
        String orderid=ofmss.get(0).getOrderID();

        while (j<i)
        {

            if(orderid.equals(ofmss.get(j).getOrderID())){
                j+=1;
                continue;
            }
            else
            {
                rspss.add(new Response().prase(ofmss.subList(from,j)));
                from=j;
                orderid=ofmss.get(j).getOrderID();
                j+=1;
            }
        }
        System.out.println(rspss.get(0).getNames());
        return ResultUtils.success(rspss);
    }

    @GetMapping("/maker/updatestatus")
    @ApiOperation(value = "更新订单状态")
    public void updateStatus(String orderID){
        makerService.updateStatus(orderID);
    }

}
