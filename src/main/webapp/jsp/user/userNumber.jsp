<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>管理员后台</title>
    <link rel="stylesheet" href="${ctx}/resource/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/resource/css/admin.css">
    <script src="${ctx}/resource/js/jquery.js"></script>
    <script src="${ctx}/resource/js/pintuer.js"></script>

</head>
<body>
    <div>
        <h1>用户详情：</h1>
        <br>
        <c:choose>

            <c:when test="${user!=null}">    <!--如果 -->
        <div class="panel admin-panel">
            <table class="table table-hover text-center">
                <tr>
                    <th>用户ID</th>
                    <th>用户编号</th>
                    <th>用户姓名</th>
                    <th>性别</th>
                    <th>电子邮件</th>
                    <th>联系方式</th>
                    <th>地址</th>
                    <th>操作</th>
                </tr>
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.userNumber}</td>
                    <td>${user.userName}</td>
                    <td>${user.userGender}</td>
                    <td>${user.userEmail}</td>
                    <td>${user.userTel}</td>
                    <td>${user.userAddress}</td>
                    <td>
                        <a href="#" class="button border-main">解禁&nbsp;|&nbsp;封禁</a>
                    </td>
                </tr>
            </table>
        </div>
            </c:when>
            <c:otherwise>  <!--否则 -->
                <div>
                    <h2 style="width:1200px; text-align: center;color: orangered;margin-top: 100px">该用户不存在！</h2>
                </div>
            </c:otherwise>

        </c:choose>
    </div>
</body>

</html>