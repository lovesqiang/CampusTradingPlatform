<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>首页</title>

    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script><link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
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
    <span>当前位置：</span><a href="${ctx}/login/uIndex" class="c_66">首页</a>
    ><a href="#" class="c_66">${type.typeName}</a>
    ><a href="#" class="c_66">商品列表</a>
</div>
<div class="width1198 center_yh" style="height: 35px;background: #f0f0f0; border: 1px solid #ddd;margin-top:12px;">
    <a href="#" class="mR">默认</a>
    <a href="#" class="mR">
        价格升序
    </a>
    <a href="#" class="mR">
        最近上传
    </a>

</div>
<!--商品列表-->
<div class="width1200 center_yh hidden_yh" style="margin-top: 25px;">
    <ul class="listSs">
        <c:forEach items="${goodsList}" var="data" varStatus="l">
            <li>
                <a href="${ctx}/goods/viewGood?goodsId=${data.goodsId}" class="bjK">
                    <img src="${ctx}/image/${data.goodsImage}" alt="">
                </a>
                <h3 class="spName">${data.goodsName}</h3>
                <p class="center_yh block_yh hidden_yh" style="width: 202px;">
                    <font class="left_yh red font16">￥${data.goodsPrice}</font>
                </p>
                <div class="wCa">
                    <a href="${ctx}/collect/addCollect?goodsId=${data.goodsId}" class="fav">
                        <div class="wCa1">
                            <b><img src="${ctx}/resource/user/images/star.png" alt=""></b>
                            <font>收藏</font>
                        </div>
                    </a>
                    <a href="${ctx}/cart/addCart?goodsId=${data.goodsId}" class="fav">
                        <div class="wCa2">
                            <b><img src="${ctx}/resource/user/images/sar.png" alt=""></b>
                            <font>加入购物车</font>
                        </div>
                        </a>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
<%@include file="/common/ufooter.jsp"%>
</body>
</html>



















