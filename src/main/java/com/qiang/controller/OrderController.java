package com.qiang.controller;

import com.github.pagehelper.PageInfo;
import com.qiang.pojo.Order;
import com.qiang.pojo.User;
import com.qiang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    public static final int PAGE_SIZE = 5;


    @RequestMapping("/pageOneOrder")
    public String pageOneMessage(Model model){
        PageInfo<Order> orderPageInfo = orderService.pageSplitOrder(1, PAGE_SIZE);

        model.addAttribute("orderPageInfo",orderPageInfo);

        return "order/order";
    }

    //Ajax分页翻页处理
    @RequestMapping("/ajaxSplit")
    @ResponseBody   //ajax请求来的，一定要使用@ResponseBody注解
    public void ajaxSplit(int page, HttpSession session){

        //取得当前page的页面数据
        PageInfo<Order> orderPageInfo = orderService.pageSplitOrder(page, PAGE_SIZE);

        //把数据传递到jsp页面上
        session.setAttribute("orderPageInfo",orderPageInfo);
    }

    //前台用户（显示用户全部订单）
    @RequestMapping("/showUserOrder")
    public String showUserOrder(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User userOrder = (User) session.getAttribute("user");
        List<Order> orderList = orderService.listOrderById(userOrder.getUserId());
        model.addAttribute("orderList",orderList);
        return "order/showUserOrder";
    }

}
