package com.demo01.demo.service;

import com.demo01.demo.entity.BillPrintInfo;

import java.util.List;

public interface DeliveryService {
    List<BillPrintInfo> BILL_PRINT_INFO(String OrderID);
}
