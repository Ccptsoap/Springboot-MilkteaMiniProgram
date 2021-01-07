package com.demo01.demo.controller;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.demo01.demo.entity.Admin;
import com.demo01.demo.entity.BillPrintInfo;
import com.demo01.demo.entity.Milktea;
import com.demo01.demo.entity.Order;
import com.demo01.demo.service.AdminService;
import com.demo01.demo.service.DeliveryService;
import com.demo01.demo.service.MilkteaService;
import com.demo01.demo.service.OrderService;
import com.demo01.demo.utils.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Api(tags="Excle导出")
public class getExcleController {
    @Resource
    AdminService adminService;
    @Resource
    MilkteaService milkteaService;
    @Resource
    OrderService orderService;
    @GetMapping("/getAdminInfo")
    @ApiOperation(value = "下载管理员账户信息表")
    public void getAdminInfo(HttpServletResponse response){

        List<Admin> admins= adminService.getAllAdmin();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String time=sdf.format(new Date());
        time=time.replaceAll("-","").replaceAll(":","").replaceAll(" ","");
        String fileName="管理员账号信息";
        ExcelUtil.writeExcel(response,admins,fileName+time,fileName,new Admin());
    }
    @GetMapping("/getMilkTeaExcle")
    @ApiOperation(value = "下载全部奶茶信息")
    public void getAllMilkTea(HttpServletResponse response){

        List<Milktea> milkteas= milkteaService.selectAllMilktea();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String time=sdf.format(new Date());
        time=time.replaceAll("-","").replaceAll(":","").replaceAll(" ","");
        String fileName="全部奶茶信息";
        ExcelUtil.writeExcel(response,milkteas,fileName+time,fileName,new Milktea());
    }
    @GetMapping("/getAllordersExcle")
    @ApiOperation(value = "下载全部订单信息")
    public void getAllorders(HttpServletResponse response){
        List<Order> orders= orderService.findAllOrder();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String time=sdf.format(new Date());
        time=time.replaceAll("-","").replaceAll(":","").replaceAll(" ","");
        String fileName="全部订单信息";
        ExcelUtil.writeExcel(response,orders,fileName+time,fileName,new Order());
//        class myResponse extends BaseRowModel {
//            @ExcelProperty(value = "订单编号",index = 0)
//            String orderid;
//            @ExcelProperty(value = "购买列表",index = 1)
//            List<String> MKnames;
//            @ExcelProperty(value = "订单描述",index = 2)
//            List<String> Description;
//            String Total;
//
//            public String getOrderid() {
//                return orderid;
//            }
//
//            public void setOrderid(String orderid) {
//                this.orderid = orderid;
//            }
//
//            public List<String> getMKnames() {
//                return MKnames;
//            }
//
//            public void setMKnames(List<String> MKnames) {
//                this.MKnames = MKnames;
//            }
//
//            public String getTotal() {
//                return Total;
//            }
//
//            public void setTotal(String total) {
//                Total = total;
//            }
//
//            public List<String> getDescription() {
//                return Description;
//            }
//
//            public void setDescription(List<String> description) {
//                Description = description;
//            }
//        }
//        List<BillPrintInfo> bpi=deliveryService.BILL_PRINT_INFOAll();
//        int from=0;
//        int size=bpi.size();
//        int j=0;
//        String orderID=bpi.get(0).getOrderID();
//        while (j<size)
//        {
//            if (bpi.get(j).getOrderID().equals(orderID))
//            j+=1;
//        }
//        myResponse myResponse=new myResponse();




//        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
//        String time=sdf.format(new Date());
//        time=time.replaceAll("-","").replaceAll(":","").replaceAll(" ","");
//        String fileName="全部奶茶信息";
//        ExcelUtil.writeExcel(response,milkteas,fileName+time,fileName,new Milktea());
    }
}
