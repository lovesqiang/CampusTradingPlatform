package com.qiang.service;

import com.qiang.pojo.Admin;

public interface AdminService {
    
    //登录验证
    Admin aLogin(String name, String pwd);	 //传入用户名和密码

}
