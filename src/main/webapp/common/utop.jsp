<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<div class="width100" style="height: 25px;background: #f0f0f0;">
    <div class="width1200 center_yh font14 c_66" style="height: 25px;line-height: 25px;">
        <font class="left_yh">欢迎来到闲置物品交易平台！</font>
        <div class="right_yh" id="fast_jump">
            <c:if test="${user.userId!=null}">
                <a href="#">欢迎您：${user.userName}</a>
                <b></b>
                <a href="${ctx}/login/userExit">退出</a>
                <b></b>
                <a href="${ctx}/cart/showCart">我的购物车</a>
                <b></b>
                <a href="${ctx}/user/userShow">个人中心</a>
                <b></b>
            </c:if>
            <c:if test="${user.userId==null}">
                <a href="${ctx}/login/uLogin">登录</a>
                <b></b>
            </c:if>
            <a href="#">关于我们</a>
        </div>
    </div>
</div>
<div class="width100 hidden_yh">
    <div class="width1200 center_yh hidden_yh">
        <div>
        <a href="${ctx}/resource/images/logo3.png" target="_blank" class="block_yh left_yh">
            <img src="${ctx}/resource/images/logo3.png" alt="" style="height: 79px ;width: 230px" >
        </a>
        </div>
        <div class="right_yh" style="height:28px;width:316px;border:2px solid #65d3f2;margin-top:32px;">
            <form action="${ctx}/goods/likeGoodsName?likeName=${likeName}">
                <input type="text" placeholder="关键词查询" style="width: 252px; height: 24px" class="search" name="likeName" value="${likeName}">
                <input type="submit"  class="btnSearh"  value="搜索">
            </form>
        </div>
    </div>
</div>
