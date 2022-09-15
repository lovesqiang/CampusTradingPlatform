package com.qiang.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiang.mapper.OrderMapper;
import com.qiang.pojo.Order;
import com.qiang.pojo.OrderExample;
import com.qiang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public PageInfo<Order> pageSplitOrder(int pageNum, int pageSize) {
        //分页插件使用PageHelper工具类完成分页设置
        PageHelper.startPage(pageNum,pageSize);
        //进行PageInfo的数据封装
        OrderExample orderExample =new OrderExample();
        orderExample.setOrderByClause("order_id desc");
        //设置完排序，取集合
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        //将查询到的集合封装到PageInfo对象中
        PageInfo<Order> orderPageInfo = new PageInfo<>(orderList);

        return orderPageInfo;
    }

    //根据用户ID查询用户订单
    @Override
    public List<Order> listOrderById(Integer userId) {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andOrderUserIdEqualTo(userId);
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        return orderList;
    }


}
