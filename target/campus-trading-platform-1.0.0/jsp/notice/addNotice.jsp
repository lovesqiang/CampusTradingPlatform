<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>管理员后台</title>
    <link rel="stylesheet" href="${ctx}/resource/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/resource/css/admin.css">
    <script src="${ctx}/resource/js/jquery.js"></script>
    <script src="${ctx}/resource/js/pintuer.js"></script>
    <%--  公告内容框所需要  --%>
    <script type="text/javascript" src="${ctx}/resource/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="${ctx}/resource/ueditor/ueditor.all.min.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add">
        <strong><span class="icon-pencil-square-o">新增公告</span> </strong>
    </div>
    <div class="body-content">
<%--        <form action="${ctx}/notice/saveAddNotice" method="post" class="form-x" enctype="multipart/form-data">--%>
    <form action="${ctx}/notice/saveAddNotice" method="post" class="form-x">
            <div class="form-group">
                <div class="label"><label>公告标题：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="noticeName" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label"><label>公告内容：</label></div>
                <div class="field">
                    <textarea rows="10" cols="70" id="content" style="width: 330px;border: 1px solid #ddd;outline: none;height: 159px;text-indent: 10px;"></textarea>
                    <div class="tips"></div>
                </div>
            </div>

<%--            <div class="form-group">--%>
<%--                <div class="label"><label>公告内容：</label></div>--%>
<%--                <div class="field">--%>
<%--                    <script type="text/plain" id="remark_txt_1" name="noticeContent" style="width: 100%;height: 300px;"></script>--%>
<%--                    <script type="text/javascript">--%>
<%--                        var editor = UE.getEditor('remark_txt_1');--%>
<%--                        UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;--%>
<%--                        UE.Editor.prototype.getActionUrl = function (action) {--%>
<%--                            if(action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadvideo'){--%>
<%--                                return '${ctx}/ueditor/saveFile';--%>
<%--                            }else{--%>
<%--                                return this._bkGetActionUrl.call(this,action);--%>
<%--                            }--%>
<%--                        }--%>
<%--                    </script>--%>
<%--                    <div class="tips"></div>--%>
<%--                </div>--%>
<%--            </div>--%>

            <div class="form-group">
                <div class="label"></div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>