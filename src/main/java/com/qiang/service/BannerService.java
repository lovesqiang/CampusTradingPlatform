package com.qiang.service;

import com.qiang.pojo.Banner;

import java.util.List;

public interface BannerService {

    //展示所有轮播图
    List<Banner> listAllBanner();

    //添加轮播图
    int insertBanner(Banner banner);

    //根据Id删除轮播图
    int deleteBanner(Integer id);

    //修改轮播图
    int updateBanner(Banner banner);

    //根据轮播图Id查询轮播信息
    Banner getBannerById(Integer id);

}
