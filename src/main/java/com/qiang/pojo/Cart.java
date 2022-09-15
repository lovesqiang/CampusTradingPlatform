package com.qiang.pojo;

import java.math.BigDecimal;

public class Cart {
    private Integer cartId;

    private Integer cartGoodsId;

    private Integer cartUserId;

    private Integer cartGoodsNum;

    private BigDecimal cartGoodsPrice;

    private String cartTotal;

    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCartGoodsId() {
        return cartGoodsId;
    }

    public void setCartGoodsId(Integer cartGoodsId) {
        this.cartGoodsId = cartGoodsId;
    }

    public Integer getCartUserId() {
        return cartUserId;
    }

    public void setCartUserId(Integer cartUserId) {
        this.cartUserId = cartUserId;
    }

    public Integer getCartGoodsNum() {
        return cartGoodsNum;
    }

    public void setCartGoodsNum(Integer cartGoodsNum) {
        this.cartGoodsNum = cartGoodsNum;
    }

    public BigDecimal getCartGoodsPrice() {
        return cartGoodsPrice;
    }

    public void setCartGoodsPrice(BigDecimal cartGoodsPrice) {
        this.cartGoodsPrice = cartGoodsPrice;
    }

    public String getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(String cartTotal) {
        this.cartTotal = cartTotal == null ? null : cartTotal.trim();
    }
}