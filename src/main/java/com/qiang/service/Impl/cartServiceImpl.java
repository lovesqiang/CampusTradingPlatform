package com.qiang.service.Impl;

import com.qiang.mapper.CartMapper;
import com.qiang.pojo.Cart;
import com.qiang.service.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cartServiceImpl implements cartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public Cart cartById(Integer id) {
        return cartMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertCart(Cart cart) {
        return cartMapper.insert(cart);
    }

    @Override
    public List<Cart> listCart(Integer userId) {
        List<Cart> carts = cartMapper.cartGoods(userId);
        return carts;
    }

    @Override
    public int deleteCart(Integer id) {
        return cartMapper.deleteByPrimaryKey(id);
    }
}
