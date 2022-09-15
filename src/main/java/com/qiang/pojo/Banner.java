package com.qiang.pojo;

public class Banner {
    private Integer bannerId;

    private String bannerImage;

    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage == null ? null : bannerImage.trim();
    }
}