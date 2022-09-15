package com.qiang.service.Impl;

import com.qiang.mapper.NoticeMapper;
import com.qiang.pojo.Notice;
import com.qiang.pojo.NoticeExample;
import com.qiang.pojo.TypeExample;
import com.qiang.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> showAllNotice() {
        //进行有条件的数据查询，必须要创建NoticeExampl对象
        NoticeExample noticeExample = new NoticeExample();

        //设置排序，按主键升降序排序
        //select * from notice order by notice_id desc
        noticeExample.setOrderByClause("notice_id desc");

        List<Notice> noticeList = noticeMapper.selectByExample(noticeExample);

        return noticeList;
    }

    //添加公告
    @Override
    public int addNotice(Notice notice) {
        return noticeMapper.insert(notice);
    }

    @Override
    public Notice getNoticeById(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    //修改公告
    @Override
    public int updateNotice(Notice notice) {
        return noticeMapper.updateByPrimaryKey(notice);
    }

    //删除公告
    @Override
    public int deleteNotice(Integer id) {
        return noticeMapper.deleteByPrimaryKey(id);
    }
}
