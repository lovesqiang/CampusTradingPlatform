package com.qiang.controller;

import com.qiang.pojo.Cart;
import com.qiang.pojo.User;
import com.qiang.service.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class cartController {

    @Autowired
    private cartService cartService;

    //添加购物车
    @RequestMapping("/addCart")
    public String addCart(Cart cart, HttpServletRequest request){
        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");

        if (user==null || user.getUserNumber()==null || user.getUserNumber()=="" ) {
            // 用户未登录，重定向到登录页面
            return "redirect:/login/uLogin";
        } else {
            //保存到收藏表
            Integer userId = user.getUserId();

            System.out.println("userId----->"+userId);

            //用户Id
            cart.setCartUserId(userId);;

            //商品Id,获取参数中的商品Id
            cart.setCartGoodsId(Integer.valueOf(request.getParameter("goodsId")));


            cartService.insertCart(cart);

            return "redirect:/cart/showCart";
        }

    }

    //购物车列表
    @RequestMapping("/showCart")
    public String showCart(Model model,HttpServletRequest request,Integer cartUserId ){
        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");

        if (user==null || user.getUserNumber()==null || user.getUserNumber()=="" ) {
            // 用户未登录，重定向到登录页面
            return "redirect:/login/uLogin";
        } else {
            cartUserId = user.getUserId();
            List<Cart> carts = cartService.listCart(cartUserId);
            model.addAttribute("carts",carts);
            model.addAttribute("cartUserId",cartUserId);
            return "cart/myCart";
        }
    }

    @RequestMapping("/delCart")
    public String delCart(Integer cartId,HttpServletRequest request){
        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");
        if (user==null || user.getUserNumber()==null || user.getUserNumber()=="" ) {
            // 用户未登录，重定向到登录页面
            return "redirect:/login/uLogin";
        } else {
            //取消收藏
            cartService.deleteCart(cartId);
            return "redirect:/cart/showCart";
        }
    }
}
