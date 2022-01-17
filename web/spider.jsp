<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        font{
            color: black;
        }
    </style>
</head>
<body>
<li><a href="<%=request.getContextPath()%>/UserInfo.jsp"><font>用户信息管理</font></a></li>
<li><a href="<%=request.getContextPath()%>/UserPermissions.jsp"><font>用户权限管理</font></a></li>
<li><a href="<%=request.getContextPath()%>/DocumentCategory.jsp"><font>文档类别管理</font></a></li>
<li><a href="<%=request.getContextPath()%>/DocumentInfo.jsp"><font>文档信息管理</font></a></li>
<li><a href="<%=request.getContextPath()%>/DocumentAttachment.jsp"><font>文档附件管理</font></a></li>
</body>
</html>

