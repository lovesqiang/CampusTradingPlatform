package com.qiang.pojo;

public class OrderDetail {
    private Integer orderDetailId;

    private Integer goodsId;

    private Integer goodsAmount;

    //小计（单个商品）
    private String orderSubtotal;

    //订单商品状态码（0：未退货，1：已退货）
    private Integer orderGoodsStatus;

    private Integer orderId;

    //商品（联合查询）
    private Goods goods;

    public String getOrderSubtotal() {
        return orderSubtotal;
    }

    public void setOrderSubtotal(String orderSubtotal) {
        this.orderSubtotal = orderSubtotal;
    }

    public Integer getOrderGoodsStatus() {
        return orderGoodsStatus;
    }

    public void setOrderGoodsStatus(Integer orderGoodsStatus) {
        this.orderGoodsStatus = orderGoodsStatus;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}