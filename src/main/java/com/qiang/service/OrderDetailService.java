package com.qiang.service;

import com.qiang.pojo.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    //展示一个订单的全部商品
    List<OrderDetail> listAll(Integer orderId);
}
