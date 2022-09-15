package com.qiang.service.Impl;

import com.qiang.mapper.OrderDetailMapper;
import com.qiang.pojo.OrderDetail;
import com.qiang.pojo.OrderDetailExample;
import com.qiang.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrderDetail> listAll(Integer orderId) {
        List<OrderDetail> orderDetailList = orderDetailMapper.selectByOrderId(orderId);
        return orderDetailList;
    }
}
