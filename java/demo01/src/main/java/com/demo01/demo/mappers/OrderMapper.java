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
    public int[] findAllOrderByID(String openid);
    public List<MiniOrderEntry> findAllMiniOrder(String openid);
    public List<MiniOrderEntry> showAllOrderForMaker();//给制作人员看的订单信息
    public Order findOneOrder(int orderId);
    public List<MiniOrderEntry> findTodayMiniOrder(String openid);
    public int addOneOrderInfo(Order order);
    public int findLastOrderId();
    public int addOneSelectInfo(SelectInfo selectInfo);
    public List<SelectInfo> findSelectInfo(int orderId);
}
