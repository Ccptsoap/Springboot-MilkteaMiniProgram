package com.demo01.demo.service;

import com.demo01.demo.entity.OrderForMaker;
import com.demo01.demo.mappers.MakerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MakerServiceImpl implements MakerService{

    @Resource
    MakerMapper makerMapper;

    @Override
    public List<OrderForMaker> showAllOrderForMaker(){
        return makerMapper.showAllOrderForMaker();
    }

    @Override
    public void updateStatus(String orderID) {
        makerMapper.updateStatus(orderID);
    }

    ;
}
