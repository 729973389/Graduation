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
<c:if test="${sessionScope.role eq '家政人员' }">
    <div class="sidebar-nav">
        <ul>
            <li><a data-target=".legal-menu11" class="nav-header collapsed" data-toggle="collapse">订单分派信息管理<i
                    class="fa fa-collapse"></i></a></li>
            <li><ul class="legal-menu11 nav nav-list collapse">
                <li><a href="allot/createAllot2.action" target="destination"><span class="fa fa-caret-right"></span>订单分派</a></li>
                    <%--    <li><a href="allot/getAllAllot.action" target="destination"><span class="fa fa-caret-right"></span>订单分派信息列表</a></li>--%>
                <li><a href="allot/queryAllotByCond2.action" target="destination"><span class="fa fa-caret-right"></span>订单分派信息查询</a></li>
            </ul></li>

        </ul>
    </div>
</c:if>


<div>
    <iframe name="destination" width="100%" height="1000px" frameborder="0" border="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
</div>
