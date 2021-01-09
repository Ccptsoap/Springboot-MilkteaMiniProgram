package com.demo01.demo.service;

import java.util.List;

/**
 * @author Soap
 * time 2021-01-09 0:54
 */
public interface BannerService {
    List<String> getBannerImgUrl();
    int uploadBannerImgUrl(String id,String imgUrl);
}
