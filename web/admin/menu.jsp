<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
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
<c:if test="${sessionScope.role eq '超级管理员' }">
    <div class="sidebar-nav">
        <ul>

            <li><a data-target=".legal-menu1" class="nav-header collapsed" data-toggle="collapse">管理用户信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu1 nav nav-list collapse">
                <li><a href="admin/createAdmin.action" target="destination"><span class="fa fa-caret-right"></span>新增管理用户信息</a></li>
<%--                <li><a href="admin/getAllAdmin.action" target="destination"><span class="fa fa-caret-right"></span>管理用户信息列表</a></li>--%>
                <li><a href="admin/queryAdminByCond.action" target="destination"><span class="fa fa-caret-right"></span>管理用户信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu2" class="nav-header collapsed" data-toggle="collapse">网站用户信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu2 nav nav-list collapse">
                <li><a href="users/createUsers.action" target="destination"><span class="fa fa-caret-right"></span>新增网站用户信息</a></li>
              <%--  <li><a href="users/getAllUsers.action" target="destination"><span class="fa fa-caret-right"></span>网站用户信息列表</a></li>--%>
                <li><a href="users/queryUsersByCond.action" target="destination"><span class="fa fa-caret-right"></span>网站用户信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu3" class="nav-header collapsed" data-toggle="collapse">新闻公告信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu3 nav nav-list collapse">
                <li><a href="article/createArticle.action" target="destination"><span class="fa fa-caret-right"></span>新增新闻公告信息</a></li>
             <%--   <li><a href="article/getAllArticle.action" target="destination"><span class="fa fa-caret-right"></span>新闻公告信息列表</a></li>--%>
                <li><a href="article/queryArticleByCond.action" target="destination"><span class="fa fa-caret-right"></span>新闻公告信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu4" class="nav-header collapsed" data-toggle="collapse">服务类型信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu4 nav nav-list collapse">
                <li><a href="cate/createCate.action" target="destination"><span class="fa fa-caret-right"></span>新增服务类型信息</a></li>
              <%--  <li><a href="cate/getAllCate.action" target="destination"><span class="fa fa-caret-right"></span>服务类型信息列表</a></li>--%>
                <li><a href="cate/queryCateByCond.action" target="destination"><span class="fa fa-caret-right"></span>服务类型信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu5" class="nav-header collapsed" data-toggle="collapse">服务项目信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu5 nav nav-list collapse">
                <li><a href="goods/createGoods.action" target="destination"><span class="fa fa-caret-right"></span>新增服务项目信息</a></li>
              <%--  <li><a href="goods/getAllGoods.action" target="destination"><span class="fa fa-caret-right"></span>服务项目信息列表</a></li>--%>
                <li><a href="goods/queryGoodsByCond.action" target="destination"><span class="fa fa-caret-right"></span>服务项目信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu7" class="nav-header collapsed" data-toggle="collapse">订单信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu7 nav nav-list collapse">
               <%-- <li><a href="orders/getAllOrders.action" target="destination"><span class="fa fa-caret-right"></span>订单信息列表</a></li>--%>

                <li><a href="orders/queryOrdersByCond.action" target="destination"><span class="fa fa-caret-right"></span>订单信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu8" class="nav-header collapsed" data-toggle="collapse">订单项信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu8 nav nav-list collapse">
             <%--   <li><a href="items/getAllItems.action" target="destination"><span class="fa fa-caret-right"></span>订单项信息列表</a></li>--%>
                <li><a href="items/queryItemsByCond.action" target="destination"><span class="fa fa-caret-right"></span>订单项信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu9" class="nav-header collapsed" data-toggle="collapse">订单评价信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu9 nav nav-list collapse">
              <%--  <li><a href="topic/getAllTopic.action" target="destination"><span class="fa fa-caret-right"></span>订单评价信息列表</a></li>--%>
                <li><a href="topic/queryTopicByCond.action" target="destination"><span class="fa fa-caret-right"></span>订单评价信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu10" class="nav-header collapsed" data-toggle="collapse">工作人员信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu10 nav nav-list collapse">
                <li><a href="employ/createEmploy.action" target="destination"><span class="fa fa-caret-right"></span>新增工作人员信息</a></li>
             <%--   <li><a href="employ/getAllEmploy.action" target="destination"><span class="fa fa-caret-right"></span>工作人员信息列表</a></li>--%>
                <li><a href="employ/queryEmployByCond.action" target="destination"><span class="fa fa-caret-right"></span>工作人员信息查询</a></li>
                <li><a href="employ/checkEmployByCond.action" target="destination"><span class="fa fa-caret-right"></span>工作人员信息审核</a></li>
            </ul></li>

            <li><a data-target=".legal-menu11" class="nav-header collapsed" data-toggle="collapse">订单分派信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu11 nav nav-list collapse">
                <li><a href="allot/createAllot.action" target="destination"><span class="fa fa-caret-right"></span>订单分派</a></li>
               <%-- <li><a href="allot/getAllAllot.action" target="destination"><span class="fa fa-caret-right"></span>订单分派信息列表</a></li>--%>
                <li><a href="allot/queryAllotByCond.action" target="destination"><span class="fa fa-caret-right"></span>订单分派信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu12" class="nav-header collapsed" data-toggle="collapse">数据统计<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu12 nav nav-list collapse">
                <li><a href="admin/line.jsp" target="destination"><span class="fa fa-caret-right"></span>订单收入统计</a></li>
                <li><a href="admin/bar.jsp" target="destination"><span class="fa fa-caret-right"></span>服务评价统计</a></li>
                <li><a href="admin/pie.jsp" target="destination"><span class="fa fa-caret-right"></span>服务数量统计</a></li>
            </ul></li>
        </ul>
    </div>
</c:if>
<c:if test="${sessionScope.role eq '管理员' }">
    <div class="sidebar-nav">
        <ul>

            <li><a data-target=".legal-menu2" class="nav-header collapsed" data-toggle="collapse">网站用户信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu2 nav nav-list collapse">
               <%-- <li><a href="users/getAllUsers.action" target="destination"><span class="fa fa-caret-right"></span>网站用户信息列表</a></li>--%>
                <li><a href="users/queryUsersByCond.action" target="destination"><span class="fa fa-caret-right"></span>网站用户信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu3" class="nav-header collapsed" data-toggle="collapse">新闻公告信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu3 nav nav-list collapse">
                <li><a href="article/createArticle.action" target="destination"><span class="fa fa-caret-right"></span>新增新闻公告信息</a></li>
              <%--  <li><a href="article/getAllArticle.action" target="destination"><span class="fa fa-caret-right"></span>新闻公告信息列表</a></li>--%>
                <li><a href="article/queryArticleByCond.action" target="destination"><span class="fa fa-caret-right"></span>新闻公告信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu4" class="nav-header collapsed" data-toggle="collapse">服务类型信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu4 nav nav-list collapse">
                <li><a href="cate/createCate.action" target="destination"><span class="fa fa-caret-right"></span>新增服务类型信息</a></li>
               <%-- <li><a href="cate/getAllCate.action" target="destination"><span class="fa fa-caret-right"></span>服务类型信息列表</a></li>--%>
                <li><a href="cate/queryCateByCond.action" target="destination"><span class="fa fa-caret-right"></span>服务类型信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu5" class="nav-header collapsed" data-toggle="collapse">服务项目信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu5 nav nav-list collapse">
                <li><a href="goods/createGoods.action" target="destination"><span class="fa fa-caret-right"></span>新增服务项目信息</a></li>
                <%--<li><a href="goods/getAllGoods.action" target="destination"><span class="fa fa-caret-right"></span>服务项目信息列表</a></li>--%>
                <li><a href="goods/queryGoodsByCond.action" target="destination"><span class="fa fa-caret-right"></span>服务项目信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu7" class="nav-header collapsed" data-toggle="collapse">订单信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu7 nav nav-list collapse">
              <%--  <li><a href="orders/getAllOrders.action" target="destination"><span class="fa fa-caret-right"></span>订单信息列表</a></li>--%>

                <li><a href="orders/queryOrdersByCond.action" target="destination"><span class="fa fa-caret-right"></span>订单信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu8" class="nav-header collapsed" data-toggle="collapse">订单项信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu8 nav nav-list collapse">
                <%--<li><a href="items/getAllItems.action" target="destination"><span class="fa fa-caret-right"></span>订单项信息列表</a></li>--%>
                <li><a href="items/queryItemsByCond.action" target="destination"><span class="fa fa-caret-right"></span>订单项信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu9" class="nav-header collapsed" data-toggle="collapse">订单评价信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu9 nav nav-list collapse">
              <%--  <li><a href="topic/getAllTopic.action" target="destination"><span class="fa fa-caret-right"></span>订单评价信息列表</a></li>--%>
                <li><a href="topic/queryTopicByCond.action" target="destination"><span class="fa fa-caret-right"></span>订单评价信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu10" class="nav-header collapsed" data-toggle="collapse">工作人员信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu10 nav nav-list collapse">
                <li><a href="employ/createEmploy.action" target="destination"><span class="fa fa-caret-right"></span>新增工作人员信息</a></li>
                    <%--   <li><a href="employ/getAllEmploy.action" target="destination"><span class="fa fa-caret-right"></span>工作人员信息列表</a></li>--%>
                <li><a href="employ/queryEmployByCond.action" target="destination"><span class="fa fa-caret-right"></span>工作人员信息查询</a></li>
                <li><a href="employ/checkEmployByCond.action" target="destination"><span class="fa fa-caret-right"></span>工作人员信息审核</a></li>
            </ul></li>


            <li><a data-target=".legal-menu11" class="nav-header collapsed" data-toggle="collapse">订单分派信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu11 nav nav-list collapse">
                <li><a href="allot/createAllot.action" target="destination"><span class="fa fa-caret-right"></span>订单分派</a></li>
               <%-- <li><a href="allot/getAllAllot.action" target="destination"><span class="fa fa-caret-right"></span>订单分派信息列表</a></li>--%>
                <li><a href="allot/queryAllotByCond.action" target="destination"><span class="fa fa-caret-right"></span>订单分派信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu12" class="nav-header collapsed" data-toggle="collapse">数据统计<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu12 nav nav-list collapse">
                <li><a href="admin/line.jsp" target="destination"><span class="fa fa-caret-right"></span>订单收入统计</a></li>
                <li><a href="admin/bar.jsp" target="destination"><span class="fa fa-caret-right"></span>服务评价统计</a></li>
                <li><a href="admin/pie.jsp" target="destination"><span class="fa fa-caret-right"></span>服务数量统计</a></li>
            </ul></li>
        </ul>
    </div>
</c:if>
<c:if test="${sessionScope.role eq '市场部人员' }">
    <div class="sidebar-nav">
        <ul>

            <li><a data-target=".legal-menu7" class="nav-header collapsed" data-toggle="collapse">订单信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu7 nav nav-list collapse">
                <%--<li><a href="orders/getAllOrders.action" target="destination"><span class="fa fa-caret-right"></span>订单信息列表</a></li>--%>

                <li><a href="orders/queryOrdersByCond.action" target="destination"><span class="fa fa-caret-right"></span>订单信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu8" class="nav-header collapsed" data-toggle="collapse">订单项信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu8 nav nav-list collapse">
               <%-- <li><a href="items/getAllItems.action" target="destination"><span class="fa fa-caret-right"></span>订单项信息列表</a></li>--%>
                <li><a href="items/queryItemsByCond.action" target="destination"><span class="fa fa-caret-right"></span>订单项信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu9" class="nav-header collapsed" data-toggle="collapse">订单评价信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu9 nav nav-list collapse">
               <%-- <li><a href="topic/getAllTopic.action" target="destination"><span class="fa fa-caret-right"></span>订单评价信息列表</a></li>--%>
                <li><a href="topic/queryTopicByCond.action" target="destination"><span class="fa fa-caret-right"></span>订单评价信息查询</a></li>
            </ul></li>

            <li><a data-target=".legal-menu11" class="nav-header collapsed" data-toggle="collapse">订单分派信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu11 nav nav-list collapse">
                <li><a href="allot/createAllot.action" target="destination"><span class="fa fa-caret-right"></span>订单分派</a></li>
            <%--    <li><a href="allot/getAllAllot.action" target="destination"><span class="fa fa-caret-right"></span>订单分派信息列表</a></li>--%>
                <li><a href="allot/queryAllotByCond.action" target="destination"><span class="fa fa-caret-right"></span>订单分派信息查询</a></li>
            </ul></li>

        </ul>
    </div>
</c:if>



<div>
    <iframe name="destination" width="100%" height="1000px" frameborder="0" border="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
</div>
