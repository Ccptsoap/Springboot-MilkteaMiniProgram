package com.demo01.demo.service;

import com.demo01.demo.entity.Banner;

import java.util.List;

/**
 * @author Soap
 * time 2021-01-09 0:54
 */
public interface BannerService {
    List<Banner> getBannerImgUrl();
    int uploadBannerImgUrl(String id,String imgUrl);
    List<String> getCosBannerImg();
}
