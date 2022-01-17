
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>DocumentAttachmentAdd</title>
    <style>
        body{
            background: url("images/bgimage.jpg");
            background-size: 100%;
            background-size: cover;
        }
    </style>
</head>
<body style="text-align:center;">
<h1>文档附件添加</h1>
<style type="text/css">
    h1{
        background: #5654a2;
        border-radius: 6px 6px 6px 6px;
        box-shadow: 0 0 0 1px #5F5A4B, 1px 1px 6px 1px rgba(10, 10, 0, 0.5);
        color: #FFFFFF;
        font-family:"微软雅黑", "宋体", "黑体", Arial;
        font-size: 18px;
        font-weight: bold;
        height: 25px;
        line-height: 25px;
        margin: 18px 18px !important;
        padding: 8px 0 5px 5px;

    }
    button{
        background:-webkit-linear-gradient(top ,rgb(169,169,169),rgb(34,102,149) 50%,rgb(34,102,140) 50%,rgb(128,128,128) 100%);
        display:inline-block;
        border:rgb(169,169, 187) solid 1px;
        box-shadow:inset rgba(255,255,255,1.0) 0px 0px 2px 0px;
        border-radius:8px;
        outline:none;
        width:45px;
        height:20px;
        cursor:pointer;
        color:#ffffff;
        font-size:10px;
    }
    table {
        width: 90%;
        background: #ccc;
        margin: 18px auto;
        border-collapse: collapse;/*border-collapse:collapse合并内外边距(去除表格单元格默认的2个像素内外边距*/
    }
    th,td {
        height: 25px;
        line-height: 25px;
        text-align: center;
        border: 1px solid #ccc;
    }
    th {
        background: #eee;
        font-weight: normal;
    }
    tr {
        background: #fff;
    }
    tr:hover {
        background: orange;
    }
    td a {
        color: #06f;
        text-decoration: none;
    }
    td a:hover {
        color: #06f;
        text-decoration: underline;}
    a:visited{
        text-decoration:none;   //去除下划线
    background-color: purple;
        color:gray;
    }
    a:hover{
        background-color: orange;
    }  /*鼠标悬停时背景颜色变橙*/

</style>
<div>
    <span>${sessionScope.user.username}</span>
    <span><a href="<%=request.getContextPath()%>/logout">退出登录</a></span>
    <span style="padding-right: 50px"></span>
    <a href="<%=request.getContextPath()%>/index.jsp">
        <button>返回</button>
    </a>
</div>
<hr>
<br>
<c:if test="${sessionScope.documentAttachment==null}">
<form action="<%=request.getContextPath()%>/documentAttachment?method=addBean" method="post">
    </c:if>
    <c:if test="${sessionScope.documentAttachment!=null}">
    <form action="<%=request.getContextPath()%>/documentAttachment?method=updateById" method="post">
        </c:if>    <table style="margin: auto">            <tr>
                <td>ID：</td>
                <td><input type="text" prefix="ID" name="id" value="${sessionScope.documentAttachment.id}"></td>
            </tr>
            <tr>
                <td>名称：</td>
                <td><input type="text" prefix="名称" name="name" value="${sessionScope.documentAttachment.name}"></td>
            </tr>
            <tr>
                <td>路径：</td>
                <td><input type="text" prefix="路径" name="path" value="${sessionScope.documentAttachment.path}"></td>
            </tr>
            <tr>
                <td>大小：</td>
                <td><input type="text" prefix="大小" name="size" value="${sessionScope.documentAttachment.size}"></td>
            </tr>
            <tr>
                <td>文档ID：</td>
                <td><input type="text" prefix="文档ID" name="documentId" value="${sessionScope.documentAttachment.documentId}"></td>
            </tr>
            <tr>
                <td>
                    <button type="submit">添加</button>
                </td>
                <td>
                    <button type="reset">重置</button>
                </td>
            </tr>
    </table>
</form>
</body>
</html>
<%
session.removeAttribute("documentAttachment");
%>