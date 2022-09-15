<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>管理员后台</title>
    <link rel="stylesheet" href="${ctx}/resource/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/resource/css/admin.css">
    <!--  引入Jquery  -->
<%--    <script type="text/javascript" src="${ctx}/static/js/jquery-3.4.1.min.js"></script>--%>
    <script src="${ctx}/resource/js/jquery.js"></script>
    <script src="${ctx}/resource/js/pintuer.js"></script>
    <!--  bootstrap  -->
<%--    <link href="${ctx}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <script src="${ctx}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>--%>

</head>
<body>
<div class="panel admin-panel">
        <form action=""  method="post" >
            <div class="padding border-bottom">
                <ul class="search" style="padding-left: 10px;">
                    <li>
                        <input type="text" placeholder="请输入商品编号" name="goodsId" class="input" value=""
                            style="width: 250px;line-height: 17px;display: inline-block" />
                        <input type="submit" class="button border-main icon-search" value="搜索" />
                    </li>
                </ul>
            </div>
        </form>
    <table class="table table-hover text-center" id="table">
        <tr>
            <th>商品ID</th>
            <th>商品姓名</th>
            <th>商品价格</th>
            <th>商品图片</th>
<%--            <th>商品描述</th>--%>
            <th>新旧程度</th>
            <th>商品类型</th>
            <th>上传时间</th>
            <th>上传用户ID</th>
            <th>审核状态</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${goodsInfo.list}" var="data" varStatus="l">
            <tr>
                <td>${data.goodsId}</td>
                <td>${data.goodsName}</td>
                <td>${data.goodsPrice}</td>
                    <%--            <td>${data.goodsImage}</td>--%>
                <td><img width="60px" height="40px" src="${ctx}/image/${data.goodsImage}" alt=""></td>
<%--                <td>${data.goodsDescription}</td>--%>
                <td>${data.goodsDegree}</td>
                <td>${data.type.typeName}</td>
                    <%--            <td>${data.goodsUploadDate}</td>--%>
                    <%--     日期格式       --%>
                <td><fmt:formatDate value="${data.goodsUploadDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${data.goodsUserId}</td>
                <td>
                    <c:choose>
                        <c:when test="${data.goodsStatus == 0}">
                            <font style="color: #de11ec">未审核</font>
                        </c:when>
                        <c:when test="${data.goodsStatus == 1}">
                            <font style="color: #00CC33">审核通过</font>
                        </c:when>
                        <c:otherwise>
                            <font style="color: #e51010">审核否决</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a href="#" class="button border-main">审核</a>
                    <a href="#" class="button border-main">下架</a>
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
                                    <a href="javascript:ajaxsplit(${goodsInfo.prePage})" aria-label="Previous">

                                        <span aria-hidden="true">«</span></a>
                                </li>
                                <c:forEach begin="1" end="${goodsInfo.pages}" var="i">
                                    <c:if test="${goodsInfo.pageNum==i}">
                                        <li>
                                                <%--                                                <a href="${pageContext.request.contextPath}/prod/split.action?page=${i}" style="background-color: grey">${i}</a>--%>
                                            <a href="javascript:ajaxsplit(${i})"
                                               style="background-color: grey">${i}</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${goodsInfo.pageNum!=i}">
                                        <li>
                                                <%--                                                <a href="${pageContext.request.contextPath}/prod/split.action?page=${i}">${i}</a>--%>
                                            <a href="javascript:ajaxsplit(${i})">${i}</a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                                <li>

                                    <%--  <a href="${pageContext.request.contextPath}/prod/split.action?page=1" aria-label="Next">--%>
                                    <a href="javascript:ajaxsplit(${goodsInfo.nextPage})" aria-label="Next">
                                        <span aria-hidden="true">»</span></a>
                                </li>
                                <li style=" margin-left:150px;color: #0e90d2;height: 35px; line-height: 35px;">总共&nbsp;&nbsp;&nbsp;<font
                                        style="color:orange;">${goodsInfo.pages}</font>&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <c:if test="${goodsInfo.pageNum!=0}">
                                        当前第&nbsp;&nbsp;&nbsp;<font
                                        style="color:orange;">${goodsInfo.pageNum}</font>&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </c:if>
                                    <c:if test="${goodsInfo.pageNum==0}">
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
            url: "${pageContext.request.contextPath}/goods/ajaxSplit", //url:远程服务器端的地址
            data: {"page": page}, //要提交的数据，提交的数据的名称叫做page,之后在控制器接的参数为page
            type: "post",
            success: function () {   //当请求处理完之后，会回到success
                //重新加载分页显示的组件table
                $("#table").load("http://localhost:8080/ctp/jsp/goods/goods.jsp #table");
            }
        })
    }
</script>

<%--更改商品状态--%>
<script type="text/javascript">

    var goodsStatus = document.getElementById("Status").value;

    function updateStatus(goodsId){
        $.ajax({
                url: "${ctx}/goods/checkGoods",
                data:  {"goodsId":goodsId,"goodsStatus":goodsStatus},
                type: "get",
                success:function () {
                    alert("操作成功")
            }
        }
        )
    }
</script>

</body>

</html>