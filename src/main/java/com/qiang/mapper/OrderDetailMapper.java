package com.qiang.mapper;

import com.qiang.pojo.OrderDetail;
import com.qiang.pojo.OrderDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDetailMapper {
    long countByExample(OrderDetailExample example);

    int deleteByExample(OrderDetailExample example);

    int deleteByPrimaryKey(Integer orderDetailId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExample(OrderDetailExample example);

    //联合查询（订单详情表和订单表）
    List<OrderDetail> selectByExampleWithGoods(OrderDetailExample example);

    OrderDetail selectByPrimaryKey(Integer orderDetailId);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    //联合查询（订单详情表和订单表）,根据订单编号查询订单详情
    List<OrderDetail> selectByOrderId(Integer orderId);
}