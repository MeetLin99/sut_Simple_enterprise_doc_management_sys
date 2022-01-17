<%@ page import="model.UserInfo" %>
<%@ page import="cn.hutool.core.util.StrUtil" %>
<%@ page import="mapper.DocumentInfoMapper" %>
<%@ page import="model.DocumentInfo" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>用户首页</title>
    <style>
        body{
            background: url("../images/bgimage.jpg");
            background-size: 100%;
            background-size: cover;
        }
    </style>
</head>
<body style="text-align:center;">
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
        background: #cc0;
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
<h1>文档管理系统-User</h1>
<div>

    <form action="<%=request.getContextPath()%>/front/index.jsp">
        <%
            UserInfo user = (UserInfo) session.getAttribute("user");
            if (user != null) {
                out.write("<span>" + user.getUsername() + "</span>\n" +
                        "<span><a href=\"" + request.getContextPath() + "/logout\">退出登录</a></span>");
            } else {
                out.write("<a href=\"" + request.getContextPath() + "/front/login.jsp\">登录</a>\n" +
                        " /\n" +
                        " <a href=\"" + request.getContextPath() + "/front/register.jsp\">注册</a>");
            }
        %>
        <%
            String name = request.getParameter("name");
            DocumentInfo book = new DocumentInfo();
            book.setName(name);
            List<DocumentInfo> search = DocumentInfoMapper.search(book);
        %>
        <span style="padding-right: 50px"></span>
        <input type="text" placeholder="请输入名称..." value="" name="name">
        <button type="submit">搜索</button>
    </form>
</div>
<hr>
<br>
<div style="text-align: center;">
    <table border="1" style="margin: auto;">
        <tr>
            <th>ID</th>
            <th>名称</th>
            <th>内容</th>
            <th>文档类别</th>
            <th>操作</th>
        </tr>
        <c:forEach items="<%=search%>" var="b">
            <tr>
                <td>${b.id}</td>
                <td>${b.name}</td>
                <td>${b.content}</td>
                <td>合同</td>
                <td>
                    <button >打印</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
