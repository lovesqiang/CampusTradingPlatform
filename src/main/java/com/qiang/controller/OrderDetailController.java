package com.qiang.controller;

import com.qiang.pojo.OrderDetail;
import com.qiang.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping("/showAll")
    public String showAll( Integer orderId,Model model){
        List<OrderDetail> orderDetailList = orderDetailService.listAll(orderId);
        model.addAttribute("orderDetailList",orderDetailList);
        System.out.println("orderId:"+orderId); //能取到orderId的值
        System.out.println("orderDetailList的内容："+orderDetailList);  //orderDetailList的内容：[null]
        return "orderDetail/orderDetail";
    }
}
