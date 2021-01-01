package com.demo01.demo.mappers;

import com.demo01.demo.entity.Milktea;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MilkteaMapper {
//    num为推荐展示的奶茶数量
    List<Milktea> selectTop(int num);

//    根据id查找奶茶信息
    Milktea selectMilkteaById(String id);

//    查找全部奶茶信息
    List<Milktea> selectAll();

    List<Milktea> selectByType(String type);

    Integer countType();

    Integer countMilktea();

    Integer insertMilktea(Milktea milktea);
}
