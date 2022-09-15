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
<div class="width100 hidden_yh" style="background: #f0f0f0;padding-top:34px;padding-bottom: 34px;">
    <div class="width1200 hidden_yh center_yh">
        <div id="vipRight" style="width: 1200px">
            <div class="fon24" style="height: 53px;line-height: 57px;text-indent: 5px;background: #f5f8fa;border-bottom: 1px solid #ddd;">
                <font style="color: #FF7F00;font-size:17px;font-weight: bold">公告列表</font>
            </div>
            <div class="hidden_yh" style="padding:20px;width:898px;">
                <c:forEach items="${noticeList}" var="data" varStatus="l">
                    <a href="${ctx}/notice/viewNotice?noticeId=${data.noticeId}">
                        <div class="width100 hidden_yh" style="border-bottom: 1px dashed #ddd; padding-top:10px;padding-bottom: 10px;">
                            <div class="left_yh" style="width:580px;">
                                <font color="red"> ${data.noticeName}</font>
                            </div>
                            <div class="right_yh">
                                <font color="black"><fmt:formatDate value="${data.noticeDate}" pattern="yyyy-MM-dd HH:mm:ss"/></font>
                            </div>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<%@include file="/common/ufooter.jsp"%>
</body>
</html>



















