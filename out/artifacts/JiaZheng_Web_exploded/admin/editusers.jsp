<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html lang="zh_CN">
<head>
    <base href="<%=basePath%>" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>欢迎使用后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
    <script type="text/javascript" src="js/admin.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
    <script type="text/javascript" src="laydate/laydate.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body class=" theme-blue">
<div class="content">
    <div class="header">
        <h1 class="page-title">编辑网站用户信息</h1>
    </div>
    <div class="main-content">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div id="myTabContent" class="tab-content">
                    <form action="users/updateUsers2.action" name="myform" method="post" onsubmit="return check()" class="form">

                        <div class="tab-pane active in" id="home">
                            <div class="form-group">
                                <label>用户名</label> <input type="text" name="username" class="form-control" id="username"
                                                          value="${users.username}" />
                            </div>
                        </div>
                        <div class="tab-pane active in" id="home">
                            <div class="form-group">
                                <label>密码</label> <input type="text" name="password" class="form-control" id="password"
                                                         value="${users.password}" />
                            </div>
                        </div>
                        <div class="tab-pane active in" id="home">
                            <div class="form-group">
                                <label>姓名</label> <input type="text" name="realname" class="form-control" id="realname"
                                                         value="${users.realname}" />
                            </div>
                        </div>
                        <div class="tab-pane active in" id="home">
                            <div class="form-group">
                                <label>性别</label>
                                <select class="form-control" name="sex" id="sex">
                                    <option value="男" <c:if test="${users.sex eq '男'}">selected="selected"</c:if>>男</option>
                                    <option value="女" <c:if test="${users.sex eq '女'}">selected="selected"</c:if>>女</option>
                                </select>
                            </div>
                        </div>
                        <div class="tab-pane active in" id="home">
                            <div class="form-group">
                                <label>生日</label>
                                <input name="birthday" type="text" size="25"  class="form-control" id="birthday" placeholder="请输入生日" value="${users.birthday}" onclick="laydate()" />
                            </div>
                        </div>
                        <div class="tab-pane active in" id="home">
                            <div class="form-group">
                                <label>联系方式</label> <input type="text" name="contact" class="form-control" id="contact"
                                                           value="${users.contact}" />
                            </div>
                        </div>
                        <div>
                            <input type="hidden" name="usersid" id="usersid" value="${users.usersid}" />
                            <%--    <input type="hidden" name="password" id="password" value="${admin.password}" />--%>
                            <input type="hidden" name="regdate" id="regdate" value="${users.regdate}" />

                            <button type="submit" id="sub" class="btn btn-primary">提交保存</button>
                            &nbsp;&nbsp;&nbsp;
                            <button type="reset" id="res" class="btn btn-primary">取消重置</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

