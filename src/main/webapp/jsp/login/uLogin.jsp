<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户登录</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/user/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/user/css/iconfont.css"/>
    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>
</head>
<body>
<div id="login-box">
    <h1>Login</h1>
    <form action="${ctx}/login/toUserLogin" method="post">
        <div class="input-box">
            <i class="iconfont">&#xe609;</i>
            <input type="text" placeholder="请输入账号" name="userNumber"/>
        </div>
        <div class="input-box">
            <i class="iconfont">&#xe605;</i>
            <input type="password" placeholder="请输入密码" name="userPassword"/>
        </div>
        <button>Sign in</button>
    </form>
</div>


</body>
</html>



















