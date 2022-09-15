package com.qiang.controller;

import com.qiang.pojo.Collect;
import com.qiang.pojo.User;
import com.qiang.service.CollectService;
import com.qiang.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @Autowired
    private GoodsService goodsService;

    //添加收藏
    @RequestMapping("/addCollect")
    public String addCollect(Collect collect, HttpServletRequest request){

        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");

        System.out.println("user--->"+user);

        if (user==null || user.getUserNumber()==null || user.getUserNumber()=="" ) {
            // 用户未登录，重定向到登录页面
            return "redirect:/login/uLogin";
        } else {
            //保存到收藏表
            Integer userId = user.getUserId();

            System.out.println("userId----->"+userId);

            //用户Id
            collect.setCollectUserId(userId);

            //商品Id,获取参数中的商品Id
            collect.setCollectGoodsId(Integer.valueOf(request.getParameter("goodsId")));


            collectService.insertCollect(collect);

            return "redirect:/collect/showCollect";
        }

    }

    //收藏列表
    @RequestMapping("showCollect")
    public String showCollect(Model model,HttpServletRequest request,Integer collectUserId){

        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");

        if (user==null || user.getUserNumber()==null || user.getUserNumber()=="" ) {
            // 用户未登录，重定向到登录页面
            return "redirect:/login/uLogin";
        } else {
            collectUserId = user.getUserId();
            //收藏列表
            List<Collect> collects = collectService.listCollect(collectUserId);

            for(Collect attribute : collects) {
                System.out.println("attribute"+attribute);
            }

            model.addAttribute("collects",collects);

            model.addAttribute("collectUserId",collectUserId);

            return "collect/myCollect";
        }

    }

    //取消收藏
    @RequestMapping("/delCollect")
    public String delCollect(Integer collectId,HttpServletRequest request){

        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");

        System.out.println("user--->"+user);

        if (user==null || user.getUserNumber()==null || user.getUserNumber()=="" ) {
            // 用户未登录，重定向到登录页面
            return "redirect:/login/uLogin";
        } else {
            //取消收藏
            collectService.deleteCollect(collectId);
            return "redirect:/collect/showCollect";
        }

    }

}
