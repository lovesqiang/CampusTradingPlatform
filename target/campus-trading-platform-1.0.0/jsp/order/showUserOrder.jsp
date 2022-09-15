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
    ><a href="#" class="c_66">我的订单</a>
</div>
<div class="width100 hidden_yh" style="background: #f0f0f0;padding-top: 34px;padding-bottom: 34px;">
    <div class="width1200 hidden_yh center_yh">
        <div id="vipNav">
            <a href="${ctx}/user/userShow">我的信息</a>
            <a href="${ctx}/goods/showGoodsByUser">我的上传</a>
            <a href="${ctx}/order/showUserOrder" class="on">我的订单</a>
            <a href="${ctx}/collect/showCollect">我的收藏</a>
            <a href="#">隐私保护</a>
        </div>
        <div id="vipRight">
            <div class="hidden_yh bj_fff" style="width: 938px;border: 1px solid #ddd;">
                <div class="width100 fon24"
                     style="height: 60px;line-height: 60px;text-indent: 22px;background: #f5f8fa;border-bottom: 1px solid #ddd;">
                    我的订单
                </div>
                <table class="table table-hover text-center" id="table">
                    <tr>
                        <th style="text-align: center;">订单编号</th>
                        <th style="text-align: center;">下单时间</th>
                        <th style="text-align: center;">总金额</th>
                        <th style="text-align: center;">下单人</th>
                        <th style="text-align: center;">订单状态</th>
                        <th style="text-align: center;">操作</th>
                    </tr>
                    <c:forEach items="${orderList}" var="data" varStatus="l">
                        <tr>
                            <td>${data.orderNumber}</td>
                            <td><fmt:formatDate value="${data.orderTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>${data.orderTotal}</td>
                            <td>${user.userName}</td>
                            <td style="color: red">
                                <c:if test="${data.orderStatus == 0}">待发货</c:if>
                                <c:if test="${data.orderStatus == 1}">已取消</c:if>
                                <c:if test="${data.orderStatus == 2}">待收货</c:if>
                                <c:if test="${data.orderStatus == 3}">已收货</c:if>
                            </td>
                            <td>
                                <a class="button border-main" href="${ctx}/orderDetail/showAll?orderId=${data.orderId}"><span
                                        class="icon-edit">查看购买商品</span> </a>
                                <a class="button border-main" href="#"><span
                                        class="icon-edit">取消订单</span> </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file="/common/ufooter.jsp" %>
</body>
</html>



















