package com.demo01.demo.service;

import com.demo01.demo.entity.OrderForMaker;


import java.util.List;

public interface MakerService {

    List<OrderForMaker> showAllOrderForMaker();
    void updateStatus(String orderID);
}
