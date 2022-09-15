<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>管理员后台</title>
    <link rel="stylesheet" href="${ctx}/resource/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/resource/css/admin.css">
    <script src="${ctx}/resource/js/jquery.js"></script>
    <script src="${ctx}/resource/js/pintuer.js"></script>

</head>
<body>
<div class="panel admin-panel">
<%--    <form action="${ctx}/user/userNumber"  method="post" >--%>
<%--        <div class="padding border-bottom">--%>
<%--            <ul class="search" style="padding-left: 10px;">--%>
<%--                <li>--%>
<%--                    <input type="text" placeholder="请输入用户编号" name="userNumber" class="input" value=""--%>
<%--                        style="width: 250px;line-height: 17px;display: inline-block" />--%>
<%--&lt;%&ndash;                    <a href="${ctx}/user/userNumber" class="button border-main icon-search">搜索</a>&ndash;%&gt;--%>
<%--                    <input type="submit" class="button border-main icon-search" value="搜索" />--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </form>--%>
    <table class="table table-hover text-center" id="table">
        <tr>
            <th>订单编号</th>
            <th>下单时间</th>
            <th>总金额</th>
            <th>下单人</th>
            <th>订单状态</th>
            <th>操作</th>
        </tr>
    <c:forEach items="${orderPageInfo.list}" var="data" varStatus="l">
        <tr>
            <td>${data.orderNumber}</td>
            <td><fmt:formatDate value="${data.orderTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            <td>${data.orderTotal}</td>
            <td>${data.orderUserId}</td>
            <td style="color: red">
                <c:if test="${data.orderStatus == 0}">待发货</c:if>
                <c:if test="${data.orderStatus == 1}">已取消</c:if>
                <c:if test="${data.orderStatus == 2}">待收货</c:if>
                <c:if test="${data.orderStatus == 3}">已收货</c:if>
            </td>
            <td>
                <a class="button border-main" href="${ctx}/orderDetail/showAll?orderId=${data.orderId}"><span class="icon-edit">查看购买商品</span> </a>
<%--                <a class="button border-main" href="#"><span>取消订单</span> </a>--%>
            </td>
        </tr>
    </c:forEach>
        <tr>
            <td colspan="8">
                    <!--分页开始-->
                    <div id="bottom">
                        <div>
                            <nav aria-label="..." style="text-align:center;">
                                <ul class="pagination">
                                    <li>
                                        <%--                                        <a href="${pageContext.request.contextPath}/prod/split.action?page=${info.prePage}" aria-label="Previous">--%>
                                        <a href="javascript:ajaxsplit(${orderPageInfo.prePage})" aria-label="Previous">

                                            <span aria-hidden="true">«</span></a>
                                    </li>
                                    <c:forEach begin="1" end="${orderPageInfo.pages}" var="i">
                                        <c:if test="${orderPageInfo.pageNum==i}">
                                            <li>
                                                    <%--                                                <a href="${pageContext.request.contextPath}/prod/split.action?page=${i}" style="background-color: grey">${i}</a>--%>
                                                <a href="javascript:ajaxsplit(${i})"
                                                   style="background-color: grey">${i}</a>
                                            </li>
                                        </c:if>
                                        <c:if test="${orderPageInfo.pageNum!=i}">
                                            <li>
                                                    <%--                                                <a href="${pageContext.request.contextPath}/prod/split.action?page=${i}">${i}</a>--%>
                                                <a href="javascript:ajaxsplit(${i})">${i}</a>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                    <li>

                                        <%--  <a href="${pageContext.request.contextPath}/prod/split.action?page=1" aria-label="Next">--%>
                                        <a href="javascript:ajaxsplit(${orderPageInfo.nextPage})" aria-label="Next">
                                            <span aria-hidden="true">»</span></a>
                                    </li>
                                    <li style=" margin-left:150px;color: #0e90d2;height: 35px; line-height: 35px;">总共&nbsp;&nbsp;&nbsp;<font
                                            style="color:orange;">${orderPageInfo.pages}</font>&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <c:if test="${orderPageInfo.pageNum!=0}">
                                            当前第&nbsp;&nbsp;&nbsp;<font
                                            style="color:orange;">${orderPageInfo.pageNum}</font>&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        </c:if>
                                        <c:if test="${orderPageInfo.pageNum==0}">
                                            当前&nbsp;&nbsp;&nbsp;<font
                                            style="color:orange;">1</font>&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        </c:if>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                </div>
            </td>
        </tr>
    </table>
</div>

<!--分页的AJAX实现-->
<script type="text/javascript">
    function ajaxsplit(page) {
        //异步ajax分页请求
        $.ajax({
            url:"${pageContext.request.contextPath}/order/ajaxSplit", //url:远程服务器端的地址
            data:{"page":page}, //要提交的数据，提交的数据的名称叫做page,之后在控制器接的参数为page
            type:"post",
            success:function () {   //当请求处理完之后，会回到success
                //重新加载分页显示的组件table
                $("#table").load("http://localhost:8080/ctp/jsp/order/order.jsp #table");
            }
        })
    }

</script>

</body>

</html>