package com.qiang.service;

import com.qiang.pojo.Notice;

import java.util.List;

public interface NoticeService {

    //展示全部公告
    List<Notice> showAllNotice();

    //添加公告
    int addNotice(Notice notice);

    //根据公告Id得到公告信息(通知回显)
    Notice getNoticeById(Integer id);

    //修改公告
    int updateNotice(Notice notice);

    //删除公告
    int deleteNotice(Integer id);

}
