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

}

