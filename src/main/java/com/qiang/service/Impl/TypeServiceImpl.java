package com.qiang.service.Impl;

import com.qiang.mapper.TypeMapper;
import com.qiang.pojo.Type;
import com.qiang.pojo.TypeExample;
import com.qiang.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> getAllType() {

        //进行有条件的数据查询，必须要创建TypeExample对象
        TypeExample example = new TypeExample();

        //设置排序，按主键升序排序
        //select * from type order by type_id asc
        example.setOrderByClause("type_id asc");

        List<Type> list = typeMapper.selectByExample(example);

        return list;
    }

    @Override
    public int insert(Type type) {
        return typeMapper.insert(type);
    }

    //删除商品类目
    @Override
    public int delete(Integer typeId) {
        return typeMapper.deleteByPrimaryKey(typeId);
    }

    @Override
    public Type getById(Integer typeId) {
        return typeMapper.selectByPrimaryKey(typeId);
    }

    @Override
    public int update(Type type) {
        return typeMapper.updateByPrimaryKey(type);
    }

    //根据类目Id获取类目名称
    @Override
    public Type getTypeById(Integer typeId) {
        Type type = typeMapper.selectByPrimaryKey(typeId);
        return type;
    }
}
