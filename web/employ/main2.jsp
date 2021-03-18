<%--
  Created by IntelliJ IDEA.
  User: 72997
  Date: 2021/1/19
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path =request.getContextPath();//获得项目名称
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";//获得全路径
%>
<!doctype html>
<html lang="zh_CN">

<head>
    <base href="<%=basePath%>"/>
    <title>欢迎使用后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
</head>
<body class="theme-blue">

<jsp:include page="top2.jsp"></jsp:include>
<jsp:include page="menu2.jsp"></jsp:include>

</body>
</html>
