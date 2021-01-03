package com.demo01.demo.mappers;

import com.demo01.demo.entity.MiniOrderEntry;
import com.demo01.demo.entity.Order;
import com.demo01.demo.entity.SelectInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
     int[] findAllOrderByID(String openid);
     List<MiniOrderEntry> findAllMiniOrder(String openid);
     Order findOneOrder(int orderId);
     List<MiniOrderEntry> findTodayMiniOrder(String openid);
     int addOneOrderInfo(Order order);
     int findLastOrderId();
     int addOneSelectInfo(SelectInfo selectInfo);
     List<SelectInfo> findSelectInfo(int orderId);
}
