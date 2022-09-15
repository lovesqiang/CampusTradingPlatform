package com.qiang.controller;

import com.github.pagehelper.PageInfo;
import com.qiang.pojo.User;
import com.qiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public static final int PAGE_SIZE = 5;

    //显示全部用户不分页(分页后不使用)
    @RequestMapping("/findUser")
    public String findAllUser(HttpServletRequest request) {
        List<User> userList = userService.getAllUser();
        request.setAttribute("userList", userList);
        return "user/user";
    }

    //用户分页(显示第一页的五条数据)
    @RequestMapping("/onePage")
    public String onePage(HttpSession session) {

        PageInfo<User> info = userService.pageSplit(1, PAGE_SIZE);

        session.setAttribute("info", info);


        return "user/user";
    }

    //Ajax分页翻页处理
    @RequestMapping("/ajaxSplit")
    @ResponseBody   //ajax请求来的，一定要使用@ResponseBody注解
    public void ajaxSplit(int page, HttpSession session) {

        //取得当前page的页面数据
        PageInfo<User> info = userService.pageSplit(page, PAGE_SIZE);

        //把数据传递到jsp页面上
        session.setAttribute("info", info);
    }

    //根据用户编号查询用户信息
    @RequestMapping("/userNumber")
    public String findUserNumber(String userNumber, HttpServletRequest request) {
        User user = userService.getByNumber(userNumber);

        request.setAttribute("user", user);

        return "/user/userNumber";
    }

    //获取登录用户基本信息
    @RequestMapping("/userShow")
    public String userShow(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user==null){
            return "login/uLogin";
        }
        model.addAttribute("user", user);

        return "/user/userCenter";
    }

    //修改用户信息（前台用户自行修改）
    @RequestMapping("/updateUser")
    public String updateUser(User user,HttpServletRequest request) {
        HttpSession session = request.getSession();
        User userSession = (User)session.getAttribute("user");
        user.setUserId(userSession.getUserId());    //用户Id不展示给用户
        user.setUserPassword(userSession.getUserPassword());    //用户密码不展示给用户
        userService.updateUser(user);
        return "user/userCenter";
    }
}
