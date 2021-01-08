package com.demo01.demo.service;

import com.demo01.demo.mappers.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Soap
 * time 2021-01-09 0:55
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;

    @Override
    public List<String> getBannerImgUrl() {
        List<String> tempString = null;
        tempString = bannerMapper.getBannerImgUrl();
        return tempString;
    }
}
