package com.demo01.demo.service;

import com.demo01.demo.mappers.BannerMapper;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.COSObjectSummary;
import com.qcloud.cos.model.ListObjectsRequest;
import com.qcloud.cos.model.ObjectListing;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public int uploadBannerImgUrl(String id, String imgUrl) {
        System.out.println("SERVICE:uploadBannerImgUrl：获取到id：" + id + "获取到URL：" + imgUrl);
        return bannerMapper.uploadBannerImgUrl(id, imgUrl);
    }

    @Override
    public List<String> getCosBannerImg() {
        String urlPrefix = "https://springboot-exp-1255644734.cos.ap-guangzhou.myqcloud.com/";
        List<String> imgUrl =  new ArrayList<>();

        // 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = "AKIDXquEYdXEj6C2b0SnpeGchX5nIYXFlg07";
        String secretKey = "zh8JBBv4xu55nEoIT9IpQnYoQ7XTs1mD";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-guangzhou");
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

        // Bucket的命名格式为 BucketName-APPID ，此处填写的存储桶名称必须为此格式
        String bucketName = "springboot-exp-1255644734";
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
        // 设置bucket名称
        listObjectsRequest.setBucketName(bucketName);
        // prefix表示列出的object的key以prefix开始
        listObjectsRequest.setPrefix("banner/");
        // deliter表示分隔符, 设置为/表示列出当前目录下的object, 设置为空表示列出所有的object
        listObjectsRequest.setDelimiter("/");
        // 设置最大遍历出多少个对象, 一次listobject最大支持1000
        listObjectsRequest.setMaxKeys(1000);
        ObjectListing objectListing = null;
        do {
            try {
                objectListing = cosClient.listObjects(listObjectsRequest);
            } catch (CosServiceException e) {
                e.printStackTrace();
                return null;
            } catch (CosClientException e) {
                e.printStackTrace();
                return null;
            }
            // common prefix表示表示被delimiter截断的路径, 如delimter设置为/, common prefix则表示所有子目录的路径
            List<String> commonPrefixs = objectListing.getCommonPrefixes();
            // object summary表示所有列出的object列表
            List<COSObjectSummary> cosObjectSummaries = objectListing.getObjectSummaries();
            int i = 0;
            for (COSObjectSummary cosObjectSummary : cosObjectSummaries) {
                // 文件的路径key
                String key = cosObjectSummary.getKey();
                if (i != 0) {
                    imgUrl.add(urlPrefix + key);
                    System.out.println("腾讯云获取的文件的路径url:" + urlPrefix + key);
                }
                i++;
                // 文件的etag
                String etag = cosObjectSummary.getETag();
                // 文件的长度
                long fileSize = cosObjectSummary.getSize();
                // 文件的存储类型
                String storageClasses = cosObjectSummary.getStorageClass();
            }
            String nextMarker = objectListing.getNextMarker();
            listObjectsRequest.setMarker(nextMarker);
        } while (objectListing.isTruncated());

        return imgUrl;
    }
}
