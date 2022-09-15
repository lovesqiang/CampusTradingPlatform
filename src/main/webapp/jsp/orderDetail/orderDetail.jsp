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
    <table class="table table-hover text-center">
        <tr>
            <th>商品名称</th>
            <th>商品图片</th>
            <th>商品单价</th>
            <th>购买数量</th>
            <th>小计</th>
            <th>状态</th>
        </tr>
    <c:forEach items="${orderDetailList}" var="data" varStatus="l">
        <tr>
            <td>${data.goods.goodsName }</td>
            <td>
                <img src="${ctx}/image/${data.goods.goodsImage}" alt="" width="100px" height="60px">
            </td>
            <td>${data.goods.goodsPrice}</td>
            <td>${data.goodsAmount}</td>
            <td>${data.orderSubtotal}</td>
<%--            <td>${data.orderGoodsStatus}--%>
            <td>
                <c:choose>
                    <c:when test="${data.orderGoodsStatus == 0}">
                        <font style="color: #00CC33">未退货</font>
                    </c:when>
                    <c:otherwise>
                        <font style="color: #e51010">已退货</font>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>

</div>

</body>
</html>