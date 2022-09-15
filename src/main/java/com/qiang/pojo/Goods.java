package com.qiang.pojo;

import java.util.Date;

public class Goods {
    private Integer goodsId;

    private String goodsName;

    private String goodsPrice;

    private String goodsImage;

    private String goodsDescription;

    private String goodsDegree;

    private Date goodsUploadDate;

    private Integer goodsStatus;

    private Integer goodsType;

    private Integer goodsUserId;

    //查询商品信息时，商品的种类也被查到
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice == null ? null : goodsPrice.trim();
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage == null ? null : goodsImage.trim();
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription == null ? null : goodsDescription.trim();
    }

    public String getGoodsDegree() {
        return goodsDegree;
    }

    public void setGoodsDegree(String goodsDegree) {
        this.goodsDegree = goodsDegree == null ? null : goodsDegree.trim();
    }

    public Date getGoodsUploadDate() {
        return goodsUploadDate;
    }

    public void setGoodsUploadDate(Date goodsUploadDate) {
        this.goodsUploadDate = goodsUploadDate;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getGoodsUserId() {
        return goodsUserId;
    }

    public void setGoodsUserId(Integer goodsUserId) {
        this.goodsUserId = goodsUserId;
    }
}