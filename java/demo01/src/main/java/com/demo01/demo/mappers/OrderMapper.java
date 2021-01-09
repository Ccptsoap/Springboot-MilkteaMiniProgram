package com.demo01.demo.mappers;

import com.demo01.demo.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
     List<Integer> findAllOrderByID(String openid);
     List<Integer> findAllOrderId();
     List<MiniOrderEntry> findAllMiniOrder(String openid);
     Order findOneOrder(int orderId);
     List<MiniOrderEntry> findMakingMiniOrder(String openid);
     List<MiniOrderEntry> findCompletedMiniOrder(String openid);
     int addOneOrderInfo(Order order);
     int findLastOrderId();
     int addOneSelectInfo(SelectInfo selectInfo);
     List<SelectInfo> findSelectInfo(int orderId);
     Integer getTodayOrderNum();


     List<OrderInfoChart> getOrderInfoAnyTime(int days);
}
