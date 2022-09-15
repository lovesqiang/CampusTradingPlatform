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
    ><a href="#" class="c_66">我的上传</a>
</div>
<div class="width100 hidden_yh" style="background: #f0f0f0;padding-top: 34px;padding-bottom: 34px;">
    <div class="width1200 hidden_yh center_yh">
        <div id="vipNav">
            <a href="${ctx}/user/userShow">我的信息</a>
            <a href="${ctx}/goods/showGoodsByUser" class="on">我的上传</a>
            <a href="${ctx}/order/showUserOrder">我的订单</a>
            <a href="${ctx}/collect/showCollect">我的收藏</a>
            <a href="#">隐私保护</a>
        </div>
        <div id="vipRight">
            <div class="hidden_yh bj_fff" style="width: 938px;border: 1px solid #ddd;">
                <div class="width100 fon24"
                     style="height: 60px;line-height: 60px;text-indent: 22px;background: #f5f8fa;border-bottom: 1px solid #ddd;">
                    我的上传
                </div>
                <table class="table table-hover text-center" id="table">
                    <tr>
                        <th style="text-align: center;">商品名称</th>
                        <th style="text-align: center;">商品价格</th>
                        <th style="text-align: center;">商品图片</th>
                        <th style="text-align: center;">商品描述</th>
                        <th style="text-align: center;">新旧程度</th>
<%--                        <th style="text-align: center;">商品类型</th>--%>
                        <th style="text-align: center;">上传时间</th>
                        <th style="text-align: center;">审核状态</th>
                        <th style="text-align: center;">上传用户</th>
                        <th style="text-align: center;">操作</th>
                    </tr>
                    <c:forEach items="${goodsList}" var="data" varStatus="l">
                        <tr>
                            <td>${data.goodsName}</td>
                            <td>${data.goodsPrice}</td>
                            <td><img width="65px" height="40px" src="${ctx}/image/${data.goodsImage}" alt=""></td>
                            <td>${data.goodsDescription}</td>
                            <td>${data.goodsDegree}</td>
<%--                            <td>${data.type.typeName}</td>--%>
                            <td><fmt:formatDate value="${data.goodsUploadDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>
                                    <%--                                ${data.goodsStatus == 1?"已审核":"未审核"}--%>
                                <c:choose>
                                    <c:when test="${data.goodsStatus == 1}">
                                        <font style="color: #00CC33">已审核</font>
                                    </c:when>
                                    <c:otherwise>
                                        <font style="color: #e51010">未审核</font>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>${user.userName}</td>
                            <td>
                                <div class="button-group">
                                    <a class="button border-main" href="#"><span
                                            class="icon-edit">修改</span> </a>
                                    <a class="button border-red" onclick="del(${data.goodsId})"><span class="icon-trash-o">下架</span>
                                    </a>
                                </div>
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



















