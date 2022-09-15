package com.qiang.service;

import com.github.pagehelper.PageInfo;
import com.qiang.pojo.Order;

import java.util.List;

public interface OrderService {

    //展示全部订单（分页的形式）
    PageInfo<Order> pageSplitOrder(int pageNum, int pageSize);

    //根据用户ID查询用户订单
    List<Order> listOrderById(Integer userId);
}
