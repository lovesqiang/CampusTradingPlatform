<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>首页</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>
    <%--  轮播图所需要  --%>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>
</head>
<body>
<%@include file="/common/utop.jsp"%>
<!--导航条-->
<div class="width100" style="height: 45px;background: #65d3f2;margin-top: 15px;position: relative;z-index: 100;">
    <!--中间的部分-->
    <div class="width1200 center_yh relative_yh" style="height: 45px;">
        <!--列表导航-->
        <div class="left_yh Selected" style="width: 230px;height: 45px;" id="hiddenShow">
            <!--头部的图标-->
            <img src="${ctx}/resource/user/images/cd.png" class="left_yh" style="margin-left: 24px;" alt="">
            <span class="block_yh left_yh fff" style="height: 45px;line-height: 44px;margin-left: 10px;">分类</span>
            <!--导航展开部分-->
            <div class="downSlide">
                <c:forEach items="${types}" var="data" varStatus="l">
                    <a href="${ctx}/goods/goodsType?goodsType=${data.typeId}">
                        <div class="n1Nav">
                            <font>${data.typeName}</font>
                            <img src="${ctx}/resource/user/images/jt.png" alt="">
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div>
        <!--普通导航-->
        <div class="left_yh font16" id="pageNav">
            <a href="${ctx}/login/uIndex">首页</a>
            <a href="${ctx}/goods/uploadGoods">上传商品</a>
            <a href="${ctx}/notice/showUserNotice">公告</a>
            <a href="${ctx}/message/addMessage">留言</a>
        </div>
    </div>
</div>
<!--轮播图-->
<div class="width1200 center_yh hidden_yh" style="position: relative;z-index:80;">
    <div class="example2" style="width: 1200px;height: 490px;overflow: hidden;margin-left: 230px;">
        <tr>
             <ul>
                 <c:forEach items="${bannerList}" var="data" varStatus="l">
                     <li><img src="${ctx}/image/banner/${data.bannerImage}" alt=""></li>
                 </c:forEach>
             </ul>
        </tr>
    </div>
    <script>
        $(function () {
            $(".example2").luara({width:"966",height:"490",interval:4500,selected:"seleted",deriction:"left"});
        });
    </script>
</div>
<!--为您推荐-->
<div class="width1200 center_yh hidden_yh">
    <div class="width100" style="height: 45px;line-height: 45px;border-bottom: 2px solid #43e278; margin-top: 20px;">
        <font class="left_yh font20">为您推荐</font>
    </div>
    <div class="width100 hidden_yh" style="height: 480px;">
        <div class="normalPic">
            <c:forEach items="${goods}" var="data" varStatus="l">
                <a href="${ctx}/goods/viewGood?goodsId=${data.goodsId}">
                    <h3 class="yihang c_33 font14 font100" style="padding-left: 10px;padding-right: 10px;">${data.goodsName}</h3>
                    <p class="red font14" style="padding-left: 10px;">${data.goodsPrice}</p>
                    <img src="${ctx}/image/${data.goodsImage}" width="175" height="135" alt="" style="margin:0 auto">
                </a>
            </c:forEach>
        </div>
    </div>
</div>

<!--最新商品-->
<div class="width1200 center_yh hidden_yh">
    <div class="width100" style="height: 45px;line-height: 45px;border-bottom: 2px solid #43e278; margin-top: 20px;">
        <font class="left_yh font20">最新商品</font>
    </div>
    <div class="width100 hidden_yh" style="height: 480px;">
        <div class="normalPic">
            <c:forEach items="${goodsNew}" var="data" varStatus="l">
                <a href="${ctx}/goods/viewGood?goodsId=${data.goodsId}">
                    <h3 class="yihang c_33 font14 font100" style="padding-left: 10px;padding-right: 10px;">${data.goodsName}</h3>
                    <p class="red font14" style="padding-left: 10px;">${data.goodsPrice}</p>
                    <img src="${ctx}/image/${data.goodsImage}" width="175" height="135" alt="" style="margin:0 auto">
                </a>
            </c:forEach>
        </div>
    </div>
</div>
<%@include file="/common/ufooter.jsp"%>
</body>
</html>
