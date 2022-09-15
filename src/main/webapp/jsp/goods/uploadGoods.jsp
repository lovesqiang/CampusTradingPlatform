<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>首页</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
    <!--  引入Jquery  -->
    <script type="text/javascript" src="${ctx}/static/js/jquery-3.4.1.min.js"></script>
    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/ajaxfileupload.js"></script>

    <!--  bootstrap  -->
    <link href="${ctx}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${ctx}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>


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
<div class="width100 hidden_yh" style="background: #f0f0f0;padding-top:34px;padding-bottom: 34px;">
    <div class="width1200 hidden_yh center_yh">
        <div id="vipRight" style="width: 1200px">
            <div class="fon24" style="height: 53px;line-height: 57px;text-indent: 5px;background: #f5f8fa;border-bottom: 1px solid #ddd;">
                <font style="color:#7093DB;font-size:17px;font-weight: bold">上传商品</font>
            </div>
            <div style="padding-top: 18px">
                <form action="${ctx}/goods/saveGoods" method="post" class="form-x">
                    <div class="form-group">
                        <label for="goodsName">商品名称</label>
                        <input type="text" class="form-control" name="goodsName" id="goodsName" placeholder="商品名称">
                    </div>
                    <div class="form-group">
                        <label for="goodsPrice">商品价格</label>
                        <input type="text" class="form-control" name="goodsPrice" id="goodsPrice" placeholder="商品价格">
                    </div>
                    <div class="form-group">
                        <label for="goodsImage">商品图片</label>
                        <div id="imgDiv"></div><br>
                        <input type="file" id="goodsImage" name="goodsImage" onchange="fileChange()">
                    </div>
                    <div class="form-group">
                        <label for="goodsType">商品类型</label>
                        <select class="form-control" name="goodsType" id="goodsType">
                            <c:forEach items="${typeList}" var="type">
                                  <option value="${type.typeId}">${type.typeName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="goodsDegree">商品成新率</label>
                        <select class="form-control" name="goodsDegree" id="goodsDegree">
                            <option>全新</option>
                            <option>九成新</option>
                            <option>八成新</option>
                            <option>七成新</option>
                            <option>六成新</option>
                            <option>五成新</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="goodsDescription">商品详情描述</label>
                        <textarea class="form-control" rows="3" name="goodsDescription" id="goodsDescription"></textarea>
                    </div>
                    <button type="submit" class="btn btn-info">上传</button>
                </form>
            </div>
      </div>
    </div>
    <script type="text/javascript">
        function fileChange(){  //注意：此处不能使用jQuery中的change事件，因此仅触发一次，因此使用标签的：onchange属性
            // alert("函数执行")
            $.ajaxFileUpload({
                url: '${ctx}/goods/ajaxImg',  //用于文件上传的服务器端请求地址
                secureuri: false,//是否遵循安全协议，一般设置为false
                fileElementId: 'goodsImage',//文件上传控件的id属性
                dataType: 'json',//服务端返回的数据格式，一般设置为json
                success: function(obj) //服务器成功响应处理函数，【本项目中】obj为服务器端完成图片上传后，返回客户端的图片对象
                {
                    // alert("obj:"+obj);
                    $("#imgDiv").empty();  //清空原有数据
                    //创建img 标签对象
                    var imgObj = $("<img>");
                    //给img标签对象追加属性
                    imgObj.attr("src","${ctx}/image/"+obj.imgURL);
                    imgObj.attr("width","195px");
                    imgObj.attr("height","120px");
                    //将图片img标签追加到imgDiv末尾
                    $("#imgDiv").append(imgObj);
                    //将图片的名称（从服务端返回的JSON中取得）赋值给文件本框
                    // $("#imgName").html(data.imgName);
                },
                error: function (e)//服务器响应失败处理函数
                {
                    alert("添加图片失败")
                }
            });
        }
    </script>
</div>

<%@include file="/common/ufooter.jsp"%>
</body>
</html>
