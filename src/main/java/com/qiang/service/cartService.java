package com.qiang.service;

import com.qiang.pojo.Cart;

import java.util.List;

public interface cartService {
    //根据主键获得一个实体
    Cart cartById(Integer id);

    //插入
    int insertCart(Cart cart);

    //购物车列表(某一个用户)
    List<Cart> listCart(Integer userId);

    //删除购物车
    int deleteCart(Integer id);
}
