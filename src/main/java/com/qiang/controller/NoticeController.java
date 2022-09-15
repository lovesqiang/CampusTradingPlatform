package com.qiang.controller;

import com.qiang.pojo.Notice;
import com.qiang.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /*
    * 展示全部公告信息
    * */
    @RequestMapping("/showNotices")
    public String showNotices(HttpServletRequest request){
        List<Notice> noticeList = noticeService.showAllNotice();
        request.setAttribute("noticeList",noticeList);
        return "notice/notice";
    }

    /*
     * 添加公告：跳转到添加公告页面
     * */
    @RequestMapping("/addNotice")
    public String addNotice(){
        return "notice/addNotice";
    }

    /*
     * 保存公告信息
     * */
    @RequestMapping("saveAddNotice")
    public String saveAddNotice(Notice notice){
        //公告时间
        notice.setNoticeDate(new Date());

        noticeService.addNotice(notice);

        return "forward:/notice/showNotices";
    }


    /*
    * 通知回显
    * */
    @RequestMapping("/findNoticeById")
    public String findNoticeById(Integer noticeId, HttpSession session){
        Notice notice = noticeService.getNoticeById(noticeId);
        session.setAttribute("notice",notice);
        return "notice/updateNotice";
    }

    /*
     * 修改公告
     * */
    @RequestMapping("/updateNotice")
    public String updateNotice(Notice notice){
        notice.setNoticeDate(new Date());
        noticeService.updateNotice(notice);
        return "forward:/notice/showNotices";
    }

    /*
     * 删除公告
     * */
    @RequestMapping("/deleteNotice")
    public String deleteNotice(Integer noticeId){
        noticeService.deleteNotice(noticeId);
        return "forward:/notice/showNotices";
    }

    //前端，展示公告名称及公告日期(给用户看)
    @RequestMapping("/showUserNotice")
    public String showUserNotice(Model model){
        List<Notice> noticeList= noticeService.showAllNotice();
        model.addAttribute("noticeList",noticeList);
        return "notice/userListNotice";
    }

    //前端，展示公告详情
    @RequestMapping("/viewNotice")
    public String viewNotice(Model model,Integer noticeId){
        Notice viewNotice = noticeService.getNoticeById(noticeId);
        model.addAttribute("viewNotice",viewNotice);
        return "notice/viewNotice";
    }

}
