package com.demo01.demo.service;

import com.demo01.demo.entity.BillPrintInfo;
import com.demo01.demo.mappers.DeliveryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Resource
    DeliveryMapper DeliveryMapper;

    @Override
    public List<BillPrintInfo> BILL_PRINT_INFO(String OrderID) {
        return DeliveryMapper.billPrintInfo(OrderID);
    }

    @Override
    public void UpdateStatus(String orderID) {
//
//        try {
            DeliveryMapper.updateStatus(orderID);
//            return "更新成功";
//        }catch (Exception e){
//            return "更新失败，订单不存在或订单已在配送/已完成";
//        }
    }

}

