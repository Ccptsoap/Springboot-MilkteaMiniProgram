package com.demo01.demo.mappers;

import com.demo01.demo.entity.BillPrintInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeliveryMapper {
     List<BillPrintInfo> billPrintInfo(String OrderID);
}
