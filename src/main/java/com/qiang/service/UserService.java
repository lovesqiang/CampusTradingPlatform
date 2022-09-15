package com.qiang.service;

import com.github.pagehelper.PageInfo;
import com.qiang.pojo.Admin;
import com.qiang.pojo.User;

import java.util.List;

public interface UserService {

    //显示全部用户，不分页
    List<User> getAllUser();

    //用户分页
    PageInfo<User> pageSplit(int pageNum, int pageSize);

    //根据用户编号查询用户信息
    User getByNumber(String userNumber);

    //登录验证
    User uLogin(String number, String pwd);	 //传入用户名和密码

    //修改用户个人基本信息（用户）
    int updateUser(User user);
}
