<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
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
    tr.td{
        width: 20%;
        text-align: right;
        font-family:"微软雅黑", "宋体", "黑体", Arial;
        padding-right: 10px;
        margin-top: 10px;
        color: #888
    }
    a:visited{
        text-decoration:none;   //去除下划线
    background-color: purple;
        color:gray;
    }
    a:hover{
        background-color: orange;
    }  /*鼠标悬停时背景颜色变橙*/

</style>
<h1>文档管理系统注册账号</h1>

<br>
<div>
    <form action="<%=request.getContextPath()%>/register" method="post">
        <table style="margin: auto">
            <tr>
                <td>用户名：</td>
                <td><input type="text" placeholder="用户名" name="username" value=""></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" placeholder="密码" name="password" value=""></td>
            </tr>
            <tr>
                <td>确认：</td>
                <td><input type="password" placeholder="密码" value=""></td>
            </tr>
            <tr>
                <td>
                    <button type="submit">注册</button>
                </td>
                <td>
                    <button type="reset">重置</button>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>已有账号？<a href="<%=request.getContextPath()%>/front/login.jsp">点击登录</a></td>
            </tr>
            <tr>
                <td><span style="color: red">${sessionScope.error}</span></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
<%
session.removeAttribute("error");
%>
