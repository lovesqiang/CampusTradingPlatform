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
    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/ajaxfileupload.js"></script>

</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add">
        <strong><span class="icon-pencil-square-o">修改轮播图</span> </strong>
    </div>
    <div class="body-content">
        <form action="${ctx}/banner/updateBanner" method="post" class="form-x">
            <div class="form-group">
                <div class="label"><label>轮播图Id：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="bannerId" value="${banner.bannerId}"
                           readonly="readonly"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>轮播图：</label></div>
                <div class="field">
                    <img id="updateImg" src="${ctx}/image/banner/${banner.bannerImage}" alt="" height="200px"
                         width="300px">
                    <div class="tips"></div>
                    <hr style="color: #CDCDCD ">
                    <font style="color: #CC3299;font-size: 15px">替换为以下图片：</font><br>
                    <hr style="color: #CDCDCD ">
                    <div id="imgDiv"></div><br>
                    <input type="file" id="bannerImage" name="bannerImage" onchange="uploadBanner()">
                </div>
            </div>
            <div class="form-group">
                <div class="label"></div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript">
    function uploadBanner() {  //注意：此处不能使用jQuery中的change事件，因此仅触发一次，因此使用标签的：onchange属性
        alert("函数执行")
        $.ajaxFileUpload({
            url: '${ctx}/banner/ajaxImg',  //用于文件上传的服务器端请求地址
            secureuri: false,//是否遵循安全协议，一般设置为false
            fileElementId: 'bannerImage',//文件上传控件的id属性
            dataType: 'json',//服务端返回的数据格式，一般设置为json
            success: function (obj) //服务器成功响应处理函数，【本项目中】obj为服务器端完成图片上传后，返回客户端的图片对象
            {
                alert("obj:" + obj);
                // $("updateImg").removeChild();
                $("#imgDiv").empty();  //清空原有数据
                //创建img 标签对象
                var imgObj = $("<img>");
                //给img标签对象追加属性
                imgObj.attr("src", "${ctx}/image/banner/" + obj.imgURL);
                imgObj.attr("width", "300px");
                imgObj.attr("height", "200px");
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