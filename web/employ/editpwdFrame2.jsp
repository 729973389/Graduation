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
    <script type="text/javascript">
        $(function() {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
    </script>
    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function() {
                return false;
            });
        });
    </script>
</head>
<body class="theme-blue">

<jsp:include page="top2.jsp"></jsp:include>
<%--<jsp:include page="menu.jsp"></jsp:include>--%>
<div class="sidebar-nav">
    <ul>



        <li><a data-target=".legal-menu11" class="nav-header collapsed" data-toggle="collapse">订单分派信息管理<i
                class="fa fa-collapse"></i></a></li>
        <li><ul class="legal-menu11 nav nav-list collapse">
            <li><a href="allot/createAllot.action" target="destination"><span class="fa fa-caret-right"></span>订单分派</a></li>
            <%--    <li><a href="allot/getAllAllot.action" target="destination"><span class="fa fa-caret-right"></span>订单分派信息列表</a></li>--%>
            <li><a href="allot/queryAllotByCond.action" target="destination"><span class="fa fa-caret-right"></span>订单分派信息查询</a></li>
        </ul></li>



    </ul>
</div>
<%--</c:if>--%>
<div>
<%--    <iframe name="destination" src="employ/editpwd2.jsp" width="100%" height="900px" frameborder="0" border="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>--%>
    <iframe name="destination" src="employ/editemploy2.jsp" width="100%" height="900px" frameborder="0" border="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>

</div>

</body>
</html>
