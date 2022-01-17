<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>企业文档管理登录</title>
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
        border-radius: 9px 9px 9px 9px;
        color: #FFFFFF;
        font-family:"微软雅黑", "宋体", "黑体", Arial;
        font-size: 22px;
        height: 25px;
        line-height: 25px;
        margin: 18px 18px !important;
        padding: 20px 0 15px 15px;
    }
    button{
        background:-webkit-linear-gradient(top ,rgb(169,169,169),rgb(86,84,162) 50%,rgb(86,84,162) 50%,rgb(128,128,128) 100%);
        display:inline-block;
        outline:none;
        width:60px;
        height:25px;
        cursor:pointer;
        color:#ffffff;
        font-size:12px;
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
        background-color: purple;
        color:gray;
    }
    a:hover{
        background-color: orange;
    }  /*鼠标悬停时背景颜色变橙*/

    .div0{
        position:absolute;
        top:50%;
        left:50%;
        transform:translate(-50%,-50%);
        width:450px;
        padding:50px;
        box-sizing:border-box;
    }
    .div2{
        margin-left: 500px;
    }
</style>
<h1>企业文档管理系统登录</h1>
<br>
<div class="div0">
    <form action="<%=request.getContextPath()%>/login" method="post">
        <div class="div1">
            用户名：
            <input type="text" placeholder="用户名" name="username" value="">
        </div>
        <div class="div1">
            <br>
            密&emsp;码：
            <input type="password" placeholder="密码" name="password" value="">
        </div>
        <br>
        <button type="submit">登录</button>
        <button type="reset">重置</button>
        <br><br>
        没有账户？<a href="<%=request.getContextPath()%>/front/register.jsp">点击注册</a>
        <span style="color: red">${sessionScope.error}</span></td>
    </form>
</div>
</body>
</html>
<%
    session.removeAttribute("error");
%>