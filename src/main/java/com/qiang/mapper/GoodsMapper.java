package com.qiang.mapper;

import com.qiang.pojo.Goods;
import com.qiang.pojo.GoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer goodsId);

    //联合查询
    List<Goods> selectByExampleWithType(GoodsExample example);

    Goods selectByPrimaryKeyWithType(Integer goodsId);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    //根据商品状态查询商品信息
    List<Goods> selectByStatus(Integer status);

    //查询类别且审核过的商品
    List<Goods> selectByTypeWithStatus(Integer typeId);

    //查询最新的商品（审核通过）
    List<Goods> selectByNewWithStatus();

    //根据商品Id修改商品审核状态
    int updateGoodsStatus(@Param("goodsStatus") Integer goodsStatus,@Param("goodsId") Integer goodsId);



}