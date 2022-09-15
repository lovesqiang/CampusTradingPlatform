package com.qiang.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiang.mapper.MessageMapper;
import com.qiang.pojo.Message;
import com.qiang.pojo.MessageExample;
import com.qiang.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public PageInfo<Message> pageSplitMessage(int pageNum, int pageSize) {
        //分页插件使用PageHelper工具类完成分页设置
        PageHelper.startPage(pageNum,pageSize);
        //进行PageInfo的数据封装
        MessageExample messageExample =new MessageExample();
        messageExample.setOrderByClause("message_id desc");
        //设置完排序，取集合
        List<Message> messageList = messageMapper.selectByExample(messageExample);
        //将查询到的集合封装到PageInfo对象中
        PageInfo<Message> messagePageInfo = new PageInfo<>(messageList);

        return messagePageInfo;
    }

    //根据主键Id删除留言
    @Override
    public int delete(Integer messageId) {
        return messageMapper.deleteByPrimaryKey(messageId);
    }

    //添加留言
    @Override
    public int insertMessage(Message message) {
        return messageMapper.insertSelective(message);
    }
}
