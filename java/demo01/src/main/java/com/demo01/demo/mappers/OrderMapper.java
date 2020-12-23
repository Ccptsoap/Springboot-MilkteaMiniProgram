package com.demo01.demo.mappers;

import com.demo01.demo.entity.MiniOrderEntry;
import com.demo01.demo.entity.OrderInfo;
import com.demo01.demo.entity.SelectInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    public List<SelectInfo> findAllOrderByName(String userName);
    public List<MiniOrderEntry> findAllMiniOrder(String userName);
    public List<SelectInfo> findOneOrder(String userName, int orderId);
    public List<MiniOrderEntry> findTodayMiniOrder(String userName);
    public int addOneOrderInfo(OrderInfo orderInfo);
    public int findLastOrderId();
    public int addOneSelectInfo(SelectInfo selectInfo);
}
