package com.qiang.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiang.mapper.UserMapper;
import com.qiang.pojo.*;
import com.qiang.service.UserService;
import com.qiang.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //获取全部用户，不分页
    @Override
    public List<User> getAllUser() {
        List<User> userList = userMapper.selectByExample(new UserExample());
        return userList;
    }

    @Override
    public PageInfo<User> pageSplit(int pageNum, int pageSize) {
        //分页插件使用PageHelper工具类完成分页设置
        PageHelper.startPage(pageNum,pageSize);

        /*
         * 进行PageInfo的数据封装
         * */
        //进行有条件的数据查询，必须要创建UserExample对象
        UserExample example = new UserExample();

        //设置排序，按主键降序排序
        //select * from user order by user_id asc
        example.setOrderByClause("user_id asc");

        //设置完排序后，取集合,切记切记：一定在取集合之前，设置PageHelper.startPage(pageNum,pageSize);
        List<User> list = userMapper.selectByExample(example);

        //将查询到的集合封装到PageInfo对象中，PageInfo中的所有成员变量统统被赋值
        PageInfo<User> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    //根据编号查询用户信息
    @Override
    public User getByNumber(String userNumber) {
        return userMapper.selectByPrimaryKeyNumber(userNumber);
    }

    @Override
    public User uLogin(String number, String pwd) {
        //如果有条件，则一定要创建UserExample的对象用来封装条件
        UserExample example = new UserExample();
        example.createCriteria().andUserNumberEqualTo(number);     //追加条件user_number=number

        //select * from user where user_number=number;
        List<User> list = userMapper.selectByExample(example);	//调用数据持久层的方法

        if(list.size()>0){

            User user = list.get(0);  //获取User对象

            String mipwd = MD5Util.getMD5(pwd);   //将界面层传过来的密码使用MD5工具变成密文

            if(mipwd.equals(user.getUserPassword())){    //判断用户密码和数据库存储的密码是否一致
                return user;
            }
        }

        return null;
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}
