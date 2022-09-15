package com.qiang.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.qiang.pojo.Message;
import com.qiang.pojo.User;
import com.qiang.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    public static final int PAGE_SIZE = 5;

    /**
    * @Description: 留言分页（第一页显示PAGE_SIZE = 5 条数据）
    * @param: model
    * @return: java.lang.String
    * @Author: yueqiang
    * @Date: 2022/3/15
    */
    @RequestMapping("/pageOneMessage")
    public String pageOneMessage(Model model){
        PageInfo<Message> messagePageInfo = messageService.pageSplitMessage(1, PAGE_SIZE);

        model.addAttribute("messagePageInfo",messagePageInfo);

        return "message/message";
    }

    //Ajax分页翻页处理
    @RequestMapping("/ajaxSplit")
    @ResponseBody   //ajax请求来的，一定要使用@ResponseBody注解
    public void ajaxSplit(int page, HttpSession session){

        //取得当前page的页面数据
        PageInfo<Message> messagePageInfo = messageService.pageSplitMessage(page, PAGE_SIZE);

        //把数据传递到jsp页面上
        session.setAttribute("messagePageInfo",messagePageInfo);
    }

    //删除留言
   @RequestMapping("/deleteMessage")
   public String  deleteMessage(Integer messageId){
        messageService.delete(messageId);
        return "forward:/message/pageOneMessage";
   }

   //用户进入发表留言页面
    @RequestMapping("/addMessage")
    public String addMessage(){
        return "message/addMessage";
    }

    //用户保存留言
    @RequestMapping("saveAddMessage")
    @ResponseBody
    public String saveAddMessage(Message message,  HttpServletRequest request){
        JSONObject js = new JSONObject();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Integer userMessageId = null;
        if(user==null){
            js.put("error","登录过后，才能给我们留言额!");
        }else {
            userMessageId = user.getUserId();     //获取用户ID
        }
        System.out.println("userMessageId:"+userMessageId);
        message.setMessageUserId(userMessageId);    //将用户Id添加到Message对象中
        messageService.insertMessage(message);
        return js.toString();
    }
}
