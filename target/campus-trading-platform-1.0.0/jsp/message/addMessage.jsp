<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>首页</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>
</head>
<body>
    <%@include file="/common/utop.jsp"%>
<!--导航条-->
    <div class="width100" style="height: 45px;background: #65d3f2;margin-top: 15px;position: relative;z-index: 100;">
    <!--中间的部分-->
    <div class="width1200 center_yh relative_yh" style="height: 45px;">
        <!--普通导航-->
        <div class="left_yh font16" id="pageNav">
            <a href="${ctx}/login/uIndex">首页</a>
            <a href="${ctx}/goods/uploadGoods">上传商品</a>
            <a href="${ctx}/notice/showUserNotice">公告</a>
            <a href="${ctx}/message/addMessage">留言</a>
        </div>
    </div>
</div>

<div class="width1200 center_yh hidden_yh font14" style="height: 40px;line-height: 40px;">
</div>
<div class="width100 hidden_yh" style="background: #f0f0f0;padding-top:34px;padding-bottom: 34px;">
    <div class="width1200 hidden_yh center_yh">
        <div id="vipRight" style="height: 53px;line-height: 57px;text-indent: 5px; background: #f5f8fa;width: 1200px;border:1px solid #ddd;">
            <font style="color: #E9C2A6;font-size:17px;font-weight: bold">提交留言</font>
        </div>
        <div class="bj_fff hidden_yh" style="width: 1200px;border: 1px solid #ddd; margin-top: 30px;padding: 50px;">
            <div class="width100" style="height: 100px;line-height: 160px;margin-top: 25px;">
                <div class="left_yh fon16 tright" style="width:120px;"><font class="red">*</font>内容： </div>
                <%--resize:none表示禁止拉伸--%>
                <textarea rows="10" cols="70" id="content" style="resize:none;width: 330px;border: 1px solid #ddd;outline: none;height: 159px;text-indent: 10px;"></textarea>
            </div>
            <div class="width100" style="height: 32px;line-height: 32px;margin-top: 90px;">
                <div class="left_yh fon16 tright" style="width:120px;"><font class="red">*</font>联系方式： </div>
                <input type="text" id="phone" style="width: 243px;border: 1px solid #ddd; outline: none;height: 30px;text-indent: 10px;">
            </div>
            <div class="width100" style="height: 32px;line-height: 32px;margin-top: 25px;">
                <a href="javascript:void(0)" class="left_yh block_yh font16 tcenter ff5802 con" style="width: 244px;height: 33px;line-height: 33px;margin-left:120px;">
                    提交
                </a>
            </div>
        </div>
    </div>
</div>

<%@include file="/common/ufooter.jsp"%>
</body>
<script>
    $(".con").click(function(){
        var phone = $("#phone").val();
        var content = $("#content").val();
        if(content==null||content==''){
            alert("请输入留言");
            return false;
        }
        if(phone==null||phone==''){
            alert("请输入联系方式");
            return false;
        }
        $.ajax({
            type:"POST",
            url:"${ctx}/message/saveAddMessage",
            data:{
                "messageUserTel":phone,
                "messageContent":content
            },
            success:function () {
                alert("感谢您的反馈！")
                window.location.href = "${ctx}/message/addMessage";
            },
            error:function (err) {
                alert("登录过后，才能给我们留言额!")
            }
        });
    });
</script>
</html>



















