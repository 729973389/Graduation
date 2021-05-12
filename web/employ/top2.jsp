<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="check_logstate2.jsp" />
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<style type="text/css">
    .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover {
        color: #fff;
    }
</style>
<div class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <a class=""><span class="navbar-brand"><span class="fa fa-paper-plane"></span>欢迎使用家政后台管理系统</span></a>
    </div>
    <div class="navbar-collapse collapse" style="height: 1px;">
        <ul id="main-menu" class="nav navbar-nav navbar-right">
            <li class="dropdown hidden-xs"><a class="dropdown-toggle" data-toggle="dropdown"> <span
                    class="glyphicon glyphicon-user padding-right-small" style="position: relative; top: 3px;"></span>
                ${sessionScope.adminname }&nbsp;&nbsp;您的角色&nbsp;&nbsp;&nbsp;${sessionScope.role }&nbsp;&nbsp;&nbsp;
            </a></li>
            <li class="dropdown hidden-xs"><a class="dropdown-toggle" data-toggle="dropdown"> <span id="time"></span> <script>
                document.getElementById('time').innerHTML = new Date()
                        .toLocaleString()
                    + ' 星期' + '日一二三四五六'.charAt(new Date().getDay());
                setInterval(
                    "document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",
                    1000);
            </script></a></li>
            <li class="dropdown hidden-xs">
<%--                <a href="<%=basePath%>employ/editpwdFrame2.jsp" title="">--%>
                    <a href= "employ/getEmployById2.action?id=${employ.employid}" title="">

                    <span>修改个人信息</span>
                </a>
            </li>
            <li class="dropdown hidden-xs">
                <a href="<%=basePath%>employ/exit2.action" onclick="{if(confirm('确定要退出吗?')){return true;}return false;}" title=""><%--return表示是否执行action，如果是true则退出，如果是false则取消退出--%>
                    <span>退出系统</span>
                </a>
            </li>
        </ul>
    </div>
</div>