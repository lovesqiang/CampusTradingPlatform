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
    ><a href="#" class="c_66">商品列表</a>
    ><a href="#" class="c_66">详情</a>
</div>
<div class="width1198 center_yh" style="height: 319px;">
    <div class="left_yh" style="width: 520px;height: 350px;">
        <div id="preview">
            <div>
                <img src="${ctx}/image/${good.goodsImage}" alt="" height="320" width="517">
            </div>
        </div>
    </div>
    <div class="left_yh" style="width: 486px;height: 350px;margin-left: 20px;">
        <h3 class="font20 font100">${good.goodsName}</h3>
        <p class="font16 c_66" style="margin-top:25px;">
            <font style="margin-right: 20px;">价格：</font>
            <font class="red font20">
                ￥${good.goodsPrice}
            </font>
        </p>
        <p class="font16 c_66" style="margin-top:25px;">
            <font style="margin-right: 20px;">商品程度：</font>
            <font class="red font20">
                ${good.goodsDegree}
            </font>
        </p>
        <p class="font16 c_66" style="margin-top:25px;">
            <font style="margin-right: 20px;">上传时间：</font>
            <font class="red font20">
                <fmt:formatDate value="${good.goodsUploadDate}" pattern="yyyy-MM-dd" />
            </font>
        </p>

        <div class="buyFor">
            <a href="${ctx}/collect/addCollect?goodsId=${good.goodsId}" class="mstBuy">收藏</a>
            <a href="${ctx}/cart/addCart?goodsId=${good.goodsId}" class="addCar">加入购物车</a>
        </div>
    </div>
</div>
<div class="width1200 hidden_yh center_yh" style="margin-top: 40px;">
    <div class="right_yh" style="width: 1200px;">
        <div class="hidden_yh" id="spXqpj">
            <%--默认显示--%>
            <a href="javascript:void(0)" class="on">商品详情</a>
            <a href="javascript:void(0)">商品留言</a>
        </div>
        <div class="width100 hidden_yh">
            <div id="spDetail">
                <div>
                    <br><br>
                    ${good.goodsDescription}
                </div>

            </div>
            <div id="spPj">
                <div>
                    <br><br>
                    <h3>此功能还未开放额</h3>
                </div>
            </div>
        </div>
    </div>

<%--  商品详情和商品留言之间的切换  --%>
    <script type="text/javascript">
        $("#spXqpj a").click(function () {
            $(this).addClass("on").siblings().removeClass("on");
        });
        $("#spXqpj a").eq(0).click(function () {
            $("#spDetail").css({display:"block"}).siblings().css({display:"none"});
        });
        $("#spXqpj a").eq(1).click(function () {
            $("#spPj").css({display:"block"}).siblings().css({display:"none"});
        });
    </script>

</div>
<%@include file="/common/ufooter.jsp"%>
</body>
</html>



















