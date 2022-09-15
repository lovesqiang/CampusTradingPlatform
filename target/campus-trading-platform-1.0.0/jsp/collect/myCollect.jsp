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

<div class="width1200 center_yh hidden_yh font14" style="height: 40px;line-height: 40px;">
    <span>当前位置：</span><a href="${ctx}/login/uIndex" class="c_66">首页</a>
    ><a href="#" class="c_66">个人中心</a>
    ><a href="#" class="c_66">我的收藏</a>
</div>
<div class="width100 hidden_yh" style="background: #f0f0f0;padding-top: 34px;padding-bottom: 34px;">
    <div class="width1200 hidden_yh center_yh">
        <div id="vipNav">
            <a href="${ctx}/user/userShow">我的信息</a>
            <a href="${ctx}/goods/showGoodsByUser">我的上传</a>
            <a href="${ctx}/order/showUserOrder" >我的订单</a>
            <a href="${ctx}/collect/showCollect" class="on">我的收藏</a>
            <a href="#">隐私保护</a>
        </div>
        <div id="vipRight">
            <div class="hidden_yh bj_fff" style="width: 938px;border: 1px solid #ddd;">
                <div class="width100 fon24" style="height: 60px;line-height: 60px;text-indent: 22px;background: #f5f8fa;border-bottom: 1px solid #ddd;">
                    我的收藏
                </div>
                <div class="hidden_yh" style="padding: 20px;width: 898px;">
                    <c:forEach items="${collects}" var="data" varStatus="l">
                        <a href="${ctx}/goods/viewGood?goodsId=${data.goods.goodsId}">
                            <div class="width100 hidden_yh" style="border-bottom: 1px dashed #ddd;padding-top: 10px;padding-bottom: 10px;">
                                <%--图片长宽比例接近黄金分割比例0.618，图片更美观--%>
                                <img src="${ctx}/image/${data.goods.goodsImage}" width="150" height="93" class="left_yh" style="margin-right: 15px;">
                                <div class="left_yh" style="width: 580px;">
                                    <h3 class="font18 c_33 font100">${data.goods.goodsName}</h3>
                                    <p class="red" style="margin-top: 10px;">￥${data.goods.goodsPrice}</p>
                                </div>
                                <div class="right_yh">
                                    <a href="${ctx}/collect/delCollect?collectId=${data.collectId}" class="onfff block_yh tcenter font16" style="margin-top: 10px;padding: 6px;">取消收藏</a>
                                </div>
                            </div>
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<%@include file="/common/ufooter.jsp"%>
</body>
</html>



















