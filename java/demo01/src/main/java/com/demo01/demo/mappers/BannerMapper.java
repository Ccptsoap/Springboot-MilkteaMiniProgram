package com.demo01.demo.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Soap
 * time 2021-01-09 0:56
 */
@Mapper
@Repository
public interface BannerMapper {
    List<String> getBannerImgUrl();
}
