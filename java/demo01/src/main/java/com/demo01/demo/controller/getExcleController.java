//package com.demo01.demo.controller;
//
//import com.alibaba.excel.annotation.ExcelProperty;
//import com.alibaba.excel.metadata.BaseRowModel;
//import com.demo01.demo.entity.*;
//import com.demo01.demo.service.AdminService;
//import com.demo01.demo.service.DeliveryService;
//import com.demo01.demo.service.MilkteaService;
//import com.demo01.demo.service.OrderService;
//import com.demo01.demo.utils.ExcelUtil;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletResponse;
//import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Controller
//@Api(tags="Excle导出")
//public class getExcleController {
//    @Resource
//    AdminService adminService;
//    @Resource
//    MilkteaService milkteaService;
//    @Resource
//    OrderService orderService;
////    @Resource
////    OrderInfoChart orderInfoChart;
////    @GetMapping("/getAdminInfo")
////    @ApiOperation(value = "下载管理员账户信息表")
////    public void getAdminInfo(HttpServletResponse response){
////
////        List<Admin> admins= adminService.getAllAdmin();
////        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
////        String time=sdf.format(new Date());
////        time=time.replaceAll("-","").replaceAll(":","").replaceAll(" ","");
////        String fileName="管理员账号信息";
////        ExcelUtil.writeExcel(response,admins,fileName+time,fileName,new Admin());
////    }
//    @GetMapping("/getMilkTeaExcle")
//    @ApiOperation(value = "下载全部奶茶信息")
//    public void getAllMilkTea(HttpServletResponse response){
//
//        List<Milktea> milkteas= milkteaService.selectAllMilktea();
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
//        String time=sdf.format(new Date());
//        time=time.replaceAll("-","").replaceAll(":","").replaceAll(" ","");
//        String fileName="全部奶茶信息";
//        ExcelUtil.writeExcel(response,milkteas,fileName+time,fileName,new Milktea());
//    }
//    @GetMapping("/getAllordersExcle")
//    @ApiOperation(value = "下载全部订单信息")
//    public void getAllorders(HttpServletResponse response){
//        class myResponse extends BaseRowModel{
//            @ExcelProperty(value = "用户openID",index = 0)
//            private String openid;
//            @ExcelProperty(value = "下单时间",index = 1)
//            private String time;
//            @ExcelProperty(value = "订单编号",index = 2)
//            private int orderId;
//            @ExcelProperty(value = "总价",index = 3)
//            private double total;
//            @ExcelProperty(value = "购买列表",index = 4)
//            //获取订单详细时使用
//            private String drinkList;
//            public List<myResponse> parse(List<Order> orders){
//                int size=orders.size();
//                List<myResponse> myResponses=new ArrayList<myResponse>();
//                int j=0;
//                while (j<size){
//
//                    myResponse myResponse=new myResponse();
//                    myResponse.setOrderId(orders.get(j).getOrderId());
//                    myResponse.setOpenid(orders.get(j).getOpenid());
//                    myResponse.setTime(orders.get(j).getTime().toLocalDateTime().toString());
//                    myResponse.setTotal(orders.get(j).getTotal());
//                    String DrinkList=new String();
//                    int i=0;
//                    int sizeofDL=orders.get(j).getDrinkList().size();
//                    while (i<sizeofDL){
//                        DrinkList=DrinkList+"id:"+orders.get(j).getDrinkList().get(i).getDrinkId()+","+
//                                "name:"+ orders.get(j).getDrinkList().get(i).getDrinkName()+","+
//                                "单价:"+orders.get(j).getDrinkList().get(i).getDrinkPrice()+"\n";
//
//                        i+=1;
//                    }
//                    myResponse.setDrinkList(DrinkList);
//                    myResponses.add(myResponse);
//                    j+=1;
//                }
//                return myResponses;
//            }
//            public String getOpenid() {
//                return openid;
//            }
//
//            public void setOpenid(String openid) {
//                this.openid = openid;
//            }
//
//            public String getTime() {
//                return time;
//            }
//
//            public void setTime(String time) {
//                this.time = time;
//            }
//
//            public int getOrderId() {
//                return orderId;
//            }
//
//            public void setOrderId(int orderId) {
//                this.orderId = orderId;
//            }
//
//            public double getTotal() {
//                return total;
//            }
//
//            public void setTotal(double total) {
//                this.total = total;
//            }
//
//            public String getDrinkList() {
//                return drinkList;
//            }
//
//            public void setDrinkList(String drinkList) {
//                this.drinkList = drinkList;
//            }
//        }
//
//        List<Order> orders= orderService.findAllOrder();
//
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
//        String time=sdf.format(new Date());
//        time=time.replaceAll("-","").replaceAll(":","").replaceAll(" ","");
//        String fileName="全部订单信息";
//        ExcelUtil.writeExcel(response,new myResponse().parse(orders),fileName+time,fileName,new myResponse());
//    }
//    @GetMapping("/getOrderInfoChart")
//    @ApiOperation(value = "下载订单数目统计")
//    public void getAllMilkTea(HttpServletResponse response,int days){
//
//        List<OrderInfoChart> OrderInfo= orderService.getOrderInfo_anyTime(days);
//        System.out.println(OrderInfo.get(0).getTime());
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
//        String time=sdf.format(new Date());
//        time=time.replaceAll("-","").replaceAll(":","").replaceAll(" ","");
//        String fileName="订单数目统计";
//        ExcelUtil.writeExcel(response,OrderInfo,fileName+time,fileName,new OrderInfoChart());
//    }
//
//}
