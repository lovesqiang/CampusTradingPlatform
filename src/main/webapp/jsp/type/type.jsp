<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
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
<%--新增模态框（商品类目）--%>
<!-- Modal -->
<div class="modal fade" id="addTypeModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true"></span></button>
                <h4 class="modal-title" id="myModalLabel">新增类目</h4>
            </div>
            <div class="modal-body">
                <form action="${ctx}/type/saveAdd" method="post" class="form-x">
                    <div class="form-group">
                        <label for="inputTypeId" class="col-sm-3 control-label">类目Id：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="typeId" id="inputTypeId" placeholder="请输入Id"
                                   data-validate="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputTypeName" class="col-sm-3 control-label">类目名称：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="typeName" id="inputTypeName"
                                   placeholder="请输入名称" data-validate="required">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">提交</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>

<div class="panel admin-panel">
    <div class="padding border-bottom">
        <ul class="search" style="padding-left: 10px;">
            <li>
                <%--                <a class="button border-main icon-plus-square-o" href="${ctx}/type/add">新增类目</a>--%>
                <a class="button border-main icon-plus-square-o" data-toggle="modal"
                        data-target="#addTypeModel">新增类目
                </a>
            </li>
        </ul>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th>ID</th>
            <th>类别名称</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${typeList}" var="data" varStatus="l">
            <tr>
                <td>${data.typeId}</td>
                <td>${data.typeName}</td>
                <td>
                    <div class="button-group">
                        <a class="button border-main" href="${ctx}/type/findId?typeId=${data.typeId}"><span
                                class="icon-edit">修改</span> </a>
                        <a class="button border-red" onclick="del(${data.typeId})"><span class="icon-trash-o">删除</span>
                        </a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
<script type="text/javascript">
    function del(typeId) {
        if (confirm("确定删除吗")) {
            //向服务器提交请求完成删除
            window.location = "${ctx}/type/delete?typeId=" + typeId;
        } else {
            alert("已取消删除")
        }
    }
</script>

</body>
</html>