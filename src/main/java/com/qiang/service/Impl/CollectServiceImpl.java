package com.qiang.service.Impl;

import com.qiang.mapper.CollectMapper;
import com.qiang.pojo.Collect;
import com.qiang.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public Collect collectById(Integer id) {
        return collectMapper.selectByPrimaryKey(id);
    }


    @Override
    public int insertCollect(Collect collect) {
        return collectMapper.insert(collect);
    }

    /*收藏列表
    * */
    @Override
    public List<Collect> listCollect(Integer userId) {
//        CollectExample collectExample = new CollectExample();
//        collectExample.createCriteria().andCollectUserIdEqualTo(userId);
//        List<Collect> collectList = collectMapper.selectByExample(collectExample);
        List<Collect> collectList = collectMapper.collectGoods(userId);
        return collectList;
    }

    @Override
    public int deleteCollect(Integer id) {
        return collectMapper.deleteByPrimaryKey(id);
    }
}
