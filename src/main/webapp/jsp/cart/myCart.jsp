<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>首页</title>
    <!--  引入Jquery  -->
    <script type="text/javascript" src="${ctx}/static/js/jquery-3.4.1.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
<%--    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>--%>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>
    <!--  bootstrap  -->
    <link href="${ctx}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${ctx}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
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
    <span>当前位置：</span><a href="${ctx}/login/uIndex" class="c_66">首页</a>
    ><a href="#" class="c_66">我的购物车</a>
    ><a href="#" class="c_66">全部商品</a>
</div>

    <div class="width100 hidden_yh" style="background: #f0f0f0;padding-top: 34px;padding-bottom: 34px;">
        <div class="width1200 hidden_yh center_yh">
            <div class="hidden_yh bj_fff" style="width: 1200px;border: 1px solid #ddd;">
                <table class="table table-hover text-center" id="table">
                    <tr>
                        <th></th>
                        <th style="text-align: center;">商品图片</th>
                        <th style="text-align: center;">商品名称</th>
                        <th style="text-align: center;">商品单价</th>
                        <th style="text-align: center;">数量</th>
                        <th style="text-align: center;">小计</th>
                        <th style="text-align: center;">操作</th>
                    </tr>
                    <c:forEach items="${carts}" var="data" varStatus="l">
                        <tr>
                            <td valign="center" align="center"><input type="checkbox" name="ck" id="ck" value="${data.cartGoodsId}" onclick="ckClick()"></td>
                            <td align="center"> <img width="60px" height="40px" src="${ctx}/image/${data.goods.goodsImage}" alt=""></td>
                            <td align="center">
                                <font>${data.goods.goodsName}</font>
                            </td>
                            <td align="center">￥<font>${data.goods.goodsPrice}</font></td>
                            <td align="center"><font> ${data.cartGoodsNum}</font></td>
                            <td align="center">￥${data.goods.goodsPrice*data.cartGoodsNum}</td>
                            <td align="center">
                                <a href="${ctx}/cart/delCart?cartId=${data.cartId}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
<div class="width1198 center_yh" style="height: 60px;background: #f0f0f0;border:1px solid #ddd;margin-top:40px;">
    <div class="center_yh hidden_yh" style="width: 1178px;height: 60px;margin-left: 20px;">
        <div class="ifAll"><b><img src="${ctx}/resource/user/images/xzwxz.png"></b><font>全选</font></div>
        <div class="ifDel">删除</div>
        <div class="sXd">
            <div class="sXd1">已选商品（<font style="color: #cb1c20">0</font> ）</div>
            <div class="sXd2">合计（不含运费）：￥<font style="color: #cb1c20" id="zjJg">0</font> </div>
            <a href="javascript:void(0)" class="ifJs" onclick="ifJs()">结算</a>
        </div>
    </div>
</div>

<%@include file="/common/ufooter.jsp"%>
</body>
</html>



















