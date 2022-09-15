package com.qiang.service;

import com.qiang.pojo.Type;

import java.util.List;


public interface TypeService {

    //获得商品类目
    List<Type>  getAllType();

    //添加商品类目
    int insert(Type type);

    //删除商品类目
    int delete(Integer typeId);

    //商品类目回显
    Type getById(Integer typeId);

    //更新商品类目
    int update(Type type);

    //根据类目Id获取类目
    Type getTypeById(Integer typeId);

}
