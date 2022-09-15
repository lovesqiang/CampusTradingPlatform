package com.qiang.controller;

import com.qiang.pojo.*;
import com.qiang.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserService userService;

    @Autowired
    private BannerService bannerService;

    //管理员登录
    @RequestMapping("/aLogin")
    public String login() {
        return "login/aLogin";
    }

    /**
     * 登录验证
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(String adminAccount, String adminPassword, HttpServletRequest request) {

        Admin admin = adminService.aLogin(adminAccount, adminPassword);    //登录判断，调用业务逻辑层验证用户

        if (admin != null) {

            request.setAttribute("admin", adminAccount);    //对象携带数据传到jsp页面

            return "login/aIndex";

        } else {

            request.setAttribute("errmsg", "用户名或密码错误");

            return "login/aLogin";
        }

    }

    /*
     * 退出登录
     * */
    @RequestMapping("/aExit")
    public String aExit() {

        return "login/aLogin";
    }

    /*
     * 平台用户首页
     * */
    @RequestMapping("uIndex")
    public String uIndex(Model model) {
        List<Type> types = typeService.getAllType();
        model.addAttribute("types", types);
        List<Goods> goods = goodsService.getGoodsByStatus(1);
        model.addAttribute("goods", goods);
        List<Goods> goodsNew = goodsService.getGoodsNewByStatus();
        model.addAttribute("goodsNew",goodsNew);
        List<Banner> bannerList = bannerService.listAllBanner();
        model.addAttribute("bannerList", bannerList);
        return "login/uIndex";
    }


    //用户登录
    @RequestMapping("/uLogin")
    public String uLogin() {
        return "login/uLogin";
    }

    /**
     * 登录验证
     *
     * @return
     */
    @RequestMapping("/toUserLogin")
    public String toUserLogin(String userNumber, String userPassword, HttpSession session, Model model) {

        User user = userService.uLogin(userNumber, userPassword);    //登录判断，调用业务逻辑层验证用户

        if (user != null) {

            session.setAttribute("user", user);    //将user添加到session作用域中

            List<Type> types = typeService.getAllType();
            model.addAttribute("types", types);
            List<Goods> goods = goodsService.getGoodsByStatus(1);   //已审核的商品
            model.addAttribute("goods", goods);
            List<Goods> goodsNew = goodsService.getGoodsNewByStatus();
            model.addAttribute("goodsNew",goodsNew);
            List<Banner> bannerList = bannerService.listAllBanner();
            model.addAttribute("bannerList", bannerList);


            return "login/uIndex";

        } else {

            session.setAttribute("errmsg", "用户名或密码错误");

            return "login/uLogin";
        }

    }

    /*
     * 用户退出
     * */
    @RequestMapping("/userExit")
    public String userExit(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");    //清楚用户在网站的信息
        return "login/uLogin";
    }

}
