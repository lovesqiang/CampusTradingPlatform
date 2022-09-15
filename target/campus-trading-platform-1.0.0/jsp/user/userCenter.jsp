<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>首页</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
    <!--  引入Jquery  -->
    <script type="text/javascript" src="${ctx}/static/js/jquery-3.4.1.min.js"></script>
    <%--    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>--%>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>
    <!--  bootstrap  -->
    <link href="${ctx}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${ctx}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="/common/utop.jsp" %>
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
    <span>当前位置：</span><a href="${ctx}/login/uIndex" class="c_66">首页</a>
    ><a href="${ctx}/user/userShow" class="c_66">个人中心</a>
    ><a href="#" class="c_66">我的信息</a>
</div>
<div class="width100 hidden_yh" style="background: #f0f0f0;padding-top: 34px;padding-bottom: 34px;">
    <div class="width1200 hidden_yh center_yh">
        <div id="vipNav">
            <a href="${ctx}/user/userShow" class="on">我的信息</a>
            <a href="${ctx}/goods/showGoodsByUser">我的上传</a>
            <a href="${ctx}/order/showUserOrder">我的订单</a>
            <a href="${ctx}/collect/showCollect">我的收藏</a>
            <a href="#">隐私保护</a>
        </div>
        <div id="vipRight">
            <div class="hidden_yh bj_fff" style="width: 938px;border: 1px solid #ddd;">
                <div class="width100 fon24"
                     style="height: 60px;line-height: 60px;text-indent: 22px;background: #f5f8fa;border-bottom: 1px solid #ddd;">
                    我的信息
                </div>
                <form class="form-horizontal" action="${ctx}/user/updateUser" method="post">
                    <div class="form-group">
                        <label for="inputUserNumber" class="col-sm-1 control-label">编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputUserNumber" name="userNumber"
                                   value="${user.userNumber}" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputUserName" class="col-sm-1 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputUserName" name="userName"
                                   value="${user.userName}" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputUserGender" class="col-sm-1 control-label">性别</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputUserGender" name="userGender"
                                   value="${user.userGender}" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputUserEmail" class="col-sm-1 control-label">邮箱</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="inputUserEmail" name="userEmail"
                                   value="${user.userEmail}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputUserTel" class="col-sm-1 control-label">电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputUserTel" name="userTel"
                                   value="${user.userTel}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputUserAddress" class="col-sm-1 control-label">地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputUserAddress" name="userAddress"
                                   value="${user.userAddress}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-1 col-sm-10">
                            <button type="submit" class="btn btn-default">修改</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $(".btn").click(function () {
            alert("修改成功");
        });
    });
</script>
<%@include file="/common/ufooter.jsp" %>
</body>
</html>



















