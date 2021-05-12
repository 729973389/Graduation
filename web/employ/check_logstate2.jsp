<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String employid = (String) session.getAttribute("employid");
    if (employid == null) {
        response.getWriter().println("<script>top.location.href='" + basePath + "employ/index2.jsp';</script>");
    }
%>