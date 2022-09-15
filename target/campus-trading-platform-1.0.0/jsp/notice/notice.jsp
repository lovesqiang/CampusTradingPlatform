<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>管理员后台</title>
    <link rel="stylesheet" href="${ctx}/resource/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/resource/css/admin.css">
    <script src="${ctx}/resource/js/jquery.js"></script>
    <script src="${ctx}/resource/js/pintuer.js"></script>
    <!--  引入Jquery  -->
    <script type="text/javascript" src="${ctx}/static/js/jquery-3.4.1.min.js"></script>

    <!--  bootstrap  -->
    <link href="${ctx}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${ctx}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="padding border-bottom">
        <ul class="search" style="padding-left: 10px;">
            <li>
                <a class="button border-main icon-plus-square-o" href="${ctx}/notice/addNotice">新增公告</a>
            </li>
        </ul>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th>公告ID</th>
            <th>公告名称</th>
            <th>公告时间</th>
            <th>操作</th>
        </tr>
    <c:forEach items="${noticeList}" var="data" varStatus="l">
        <tr>
            <td>${data.noticeId}</td>
            <td>${data.noticeName}</td>
            <td><fmt:formatDate value="${data.noticeDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>
                <div class="button-group">
                    <a class="button border-main" href="${ctx}/notice/findNoticeById?noticeId=${data.noticeId}"><span class="icon-edit">修改</span> </a>
                    <a class="button border-red" onclick="del(${data.noticeId})" ><span class="icon-trash-o">删除</span> </a>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>

</div>
<script type="text/javascript">
    function del(noticeId) {
        if (confirm("确定删除吗")) {
            //向服务器提交请求完成删除
            window.location="${ctx}/notice/deleteNotice?noticeId="+noticeId;
        }else {
            alert("已取消删除")
        }
    }
</script>

</body>
</html>