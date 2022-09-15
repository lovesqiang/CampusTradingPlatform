package com.qiang.service.Impl;

import com.qiang.mapper.BannerMapper;
import com.qiang.pojo.Banner;
import com.qiang.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> listAllBanner() {
        List<Banner> bannerList = bannerMapper.selectByExample(null);
        return bannerList;
    }

    @Override
    public int insertBanner(Banner banner) {
        return bannerMapper.insertSelective(banner);
    }

    @Override
    public int deleteBanner(Integer id) {
        return bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateBanner(Banner banner) {
        return bannerMapper.updateByPrimaryKey(banner);
    }

    @Override
    public Banner getBannerById(Integer id) {
        return bannerMapper.selectByPrimaryKey(id);
    }
}
