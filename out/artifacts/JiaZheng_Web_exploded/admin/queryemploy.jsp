<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@ taglib prefix="c"
                                                                               uri="http://java.sun.com/jsp/jstl/core"%><jsp:include page="check_logstate.jsp"></jsp:include>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%><!doctype html>
<html lang="zh_CN">
<head>
    <base href="<%=basePath%>" />
    <title>欢迎使用后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
</head>
<body class=" theme-blue">
<div class="content">
    <div class="header">
        <h1 class="page-title">工作人员信息列表</h1>
    </div>
    <div class="main-content">
        <table class="table">
            <thead>
            <tr>
                <th class="text-center">用户名</th>
                <th class="text-center">密码</th>
                <th class="text-center">姓名</th>
                <th class="text-center">性别</th>
                <th class="text-center">出生日期</th>
                <th class="text-center">身份证</th>
                <th class="text-center">籍贯</th>
                <th class="text-center">民族</th>
                <th class="text-center">入职日期</th>
                <th class="text-center">联系方式</th>
                <th class="text-center">备注</th>
                <th class="text-center">审核状态</th>
                <th class="text-center">操作</th>
            </tr>
            </thead>
            <c:forEach items="${employList}" var="employ">
                <tr align="center">
                    <td class="center">${employ.username}</td>
                    <td class="center">${employ.password}</td>
                    <td class="center">${employ.realname}</td>
                    <td class="center">${employ.sex}</td>
                    <td class="center">${employ.birthday}</td>
                    <td class="center">${employ.idcard}</td>
                    <td class="center">${employ.jiguan}</td>
                    <td class="center">${employ.minzu}</td>
                    <td class="center">${employ.workdate}</td>
                    <td class="center">${employ.contact}</td>
                    <td class="center">${employ.memo}</td>
                    <td class="center">${employ.checkone}</td>
                    <td>
                        <a href="employ/getEmployById.action?id=${employ.employid}">
                            <i class="fa fa-pencil"></i>
                        </a>&nbsp;&nbsp;
                        <a href="employ/deleteCheckEmploy.action?id=${employ.employid}" onclick="{if(confirm('确定删除吗？')){return true;}return false;}">
                            <i class="fa fa-trash-o"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <ul class="pagination">
            <li>
                <form action="employ/queryEmployByCond.action" name="myform" method="post">
                    <label>查询条件: <select name="cond" style="width: 100px">
                        <option value="realname">按姓名查询</option>
                        <option value="sex">按性别查询</option>
                        <option value="birthday">按出生日期查询</option>
                        <option value="idcard">按身份证查询</option>
                        <option value="jiguan">按籍贯查询</option>
                        <option value="minzu">按民族查询</option>
                        <option value="workdate">按入职日期查询</option>
                        <option value="contact">按联系方式查询</option>
                        <option value="memo">按备注查询</option>
                    </select>
                    </label>&nbsp;&nbsp;&nbsp; <label>关键字: <input type="text" name="name" required style="width: 100px" /></label>&nbsp;&nbsp;&nbsp;
                    <label><input type="submit" value="查询" class="mws-button green" /> </label>${html }
                </form>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
