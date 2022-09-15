package com.qiang.pojo;

public class Collect {
    private Integer collectId;

    private Integer collectGoodsId;

    private Integer collectUserId;

    //商品对象
    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getCollectGoodsId() {
        return collectGoodsId;
    }

    public void setCollectGoodsId(Integer collectGoodsId) {
        this.collectGoodsId = collectGoodsId;
    }

    public Integer getCollectUserId() {
        return collectUserId;
    }

    public void setCollectUserId(Integer collectUserId) {
        this.collectUserId = collectUserId;
    }
}