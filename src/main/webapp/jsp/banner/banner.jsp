<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>管理员后台</title>
    <link rel="stylesheet" href="${ctx}/resource/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/resource/css/admin.css">
<%--    <script src="${ctx}/resource/js/jquery.js"></script>--%>
<%--    <script src="${ctx}/resource/js/pintuer.js"></script>--%>
    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>
    <!--  引入Jquery  -->
    <script type="text/javascript" src="${ctx}/static/js/jquery-3.4.1.min.js"></script>

    <script type="text/javascript" src="${ctx}/resource/js/ajaxfileupload.js"></script>



    <!--  bootstrap  -->
    <link href="${ctx}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${ctx}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<!-- Modal:新增模态框 -->
<div class="modal fade" id="addBannerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"></span></button>
                <h4 class="modal-title" id="myModalLabel">新增图片</h4>
            </div>
            <div class="modal-body">
                <div id="imgDiv"></div><br>
                    <input type="file" id="bannerImage"  name="bannerImage" onchange="uploadBanner()" >
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="window.location.href='${ctx}/banner/saveBannerImage'">保存</button>
            </div>
        </div>
    </div>
</div>

<div class="panel admin-panel">
    <div class="padding border-bottom">
        <ul class="search" style="padding-left: 10px;">
            <li>
                <a class="button border-main icon-plus-square-o" data-toggle="modal" data-target="#addBannerModal">新增轮播图</a>
            </li>
        </ul>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th>ID</th>
            <th>轮播图</th>
            <th>操作</th>
        </tr>
    <c:forEach items="${bannerList}" var="data" varStatus="l">
        <tr>
            <td><br><br>${data.bannerId}</td>
            <td><img src="${ctx}/image/banner/${data.bannerImage}" alt="" style="width: 180px;height: 120px;"></td>
            <td>
                <div class="button-group">
                    <br><br>
                    <a class="button border-main" href="${ctx}/banner/getOneBanner?bannerId=${data.bannerId}"><span class="icon-edit">修改</span> </a>
                    <a class="button border-red" onclick="del(${data.bannerId})" ><span class="icon-trash-o">删除</span> </a>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>

</div>

<script type="text/javascript">
    function del(bannerId) {
        if (confirm("确定删除吗")) {
            //向服务器提交请求完成删除
            window.location="${ctx}/banner/deleteBanner?bannerId="+bannerId;
        }else {
            alert("已取消删除")
        }
    }
</script>

<script type="text/javascript">
    function uploadBanner(){  //注意：此处不能使用jQuery中的change事件，因此仅触发一次，因此使用标签的：onchange属性
        alert("函数执行")
        $.ajaxFileUpload({
            url: '${ctx}/banner/ajaxImg',  //用于文件上传的服务器端请求地址
            secureuri: false,//是否遵循安全协议，一般设置为false
            fileElementId: 'bannerImage',//文件上传控件的id属性
            dataType: 'json',//服务端返回的数据格式，一般设置为json
            success: function(obj) //服务器成功响应处理函数，【本项目中】obj为服务器端完成图片上传后，返回客户端的图片对象
            {
                alert("obj:"+obj);
                $("#imgDiv").empty();  //清空原有数据
                //创建img 标签对象
                var imgObj = $("<img>");
                //给img标签对象追加属性
                imgObj.attr("src","${ctx}/image/banner/"+obj.imgURL);
                imgObj.attr("width","300px");
                imgObj.attr("height","200px");
                //将图片img标签追加到imgDiv末尾
                $("#imgDiv").append(imgObj);
                //将图片的名称（从服务端返回的JSON中取得）赋值给文件本框
            },
            error: function (e)//服务器响应失败处理函数
            {
                alert("添加图片失败")
            }
        });
    }
</script>


</body>
</html>