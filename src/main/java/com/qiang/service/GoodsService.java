package com.qiang.service;

import com.github.pagehelper.PageInfo;
import com.qiang.pojo.Goods;

import java.util.List;


public interface GoodsService {

    //商品分页
    PageInfo<Goods> pageSplit(int pageNum, int pageSize);

    //根据商品Id查询商品信息
    Goods getGoodsById(Integer goodsId);

    //根据商品状态获取商品
    List<Goods> getGoodsByStatus(Integer status);

    //审核通过的最新的商品
    List<Goods> getGoodsNewByStatus();

    //根据商品类别获得商品信息
    List<Goods> listGoodsByType(Integer id);

    //根据商品名称模糊查询
    List<Goods> listLikeGoodsName(String likeName);

    //用户上传商品（新增商品）
    int insetGoods(Goods goods);

    //用户（显示上传的商品）
    List<Goods> listGoodsByUser(Integer userId);

    //商品审核（根据商品Id修改商品状态）
    int updateGoodsStatus(Integer goodsStatus,Integer goodsId);

}
