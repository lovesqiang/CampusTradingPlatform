package com.qiang.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiang.mapper.GoodsMapper;
import com.qiang.pojo.Goods;
import com.qiang.pojo.GoodsExample;
import com.qiang.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageInfo<Goods> pageSplit(int pageNum, int pageSize) {
        //分页插件使用PageHelper工具类完成分页设置
        PageHelper.startPage(pageNum,pageSize);

        /*
         * 进行PageInfo的数据封装
         * */
        //进行有条件的数据查询，必须要创建GoodsExample对象
        GoodsExample example = new GoodsExample();

        //设置排序，按主键降序排序
        //select * from user order by goods_id asc
        example.setOrderByClause("goods_id asc");

        //设置完排序后，取集合,切记切记：一定在取集合之前，设置PageHelper.startPage(pageNum,pageSize);
        List<Goods> list = goodsMapper.selectByExampleWithType(example);

        //将查询到的集合封装到PageInfo对象中，PageInfo中的所有成员变量统统被赋值
        PageInfo<Goods> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }


    /*
     *根据商品状态获得商品信息
     **/
    @Override
    public List<Goods> getGoodsByStatus(Integer status) {
        return goodsMapper.selectByStatus(status);
    }

    //审核通过最新的商品
    @Override
    public List<Goods> getGoodsNewByStatus() {
        List<Goods> goodsNewList = goodsMapper.selectByNewWithStatus();
        return goodsNewList;
    }

    /*
     *根据商品类别获得商品信息
     **/
    @Override
    public List<Goods> listGoodsByType(Integer id) {
//        GoodsExample goodsExample = new GoodsExample();   //展示同类型的所有商品
//        goodsExample.createCriteria().andGoodsTypeEqualTo(id);
//        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        List<Goods> goodsList = goodsMapper.selectByTypeWithStatus(id); //只展示审核过的商品
        return goodsList;
    }

    /*
     *根据商品名称模糊查询
     **/
    @Override
    public List<Goods> listLikeGoodsName(String likeName) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andGoodsNameLike('%'+likeName+'%');   //Criteria : 标准
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        return goodsList;
    }

    //商品上传
    @Override
    public int insetGoods(Goods goods) {
        return goodsMapper.insert(goods);
    }


    /*
     *根据商品Id获得商品信息
     **/
    @Override
    public Goods getGoodsById(Integer goodsId) {
        return goodsMapper.selectByPrimaryKey(goodsId);
    }

    //用户（显示上传的商品）
    @Override
    public List<Goods> listGoodsByUser(Integer userId) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andGoodsUserIdEqualTo(userId);
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        return goodsList;
    }

    //商品审核（修改商品状态）
    @Override
    public int updateGoodsStatus(Integer goodsStatus,Integer goodsId) {
        return goodsMapper.updateGoodsStatus(goodsStatus,goodsId);
    }
}
