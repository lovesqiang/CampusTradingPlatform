package com.qiang.service;

import com.github.pagehelper.PageInfo;
import com.qiang.pojo.Message;

public interface MessageService {

    //展示全部留言（分页的形式）
    PageInfo<Message> pageSplitMessage(int pageNum,int pageSize);

    //删除留言（单个删除）
    int delete(Integer messageId);

    //添加留言
    int insertMessage(Message message);
}
