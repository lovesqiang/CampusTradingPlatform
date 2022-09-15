package com.qiang.service;

import com.qiang.pojo.Collect;
import java.util.List;

public interface CollectService {

    //根据主键获得一个实体
    Collect collectById(Integer id);

    //插入
    int insertCollect(Collect collect);

    //收藏列表(某一个用户)
    List<Collect> listCollect(Integer userId);

    //删除收藏
    int deleteCollect(Integer id);
}
