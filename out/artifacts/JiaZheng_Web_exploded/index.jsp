<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>>">
    <title>Title</title>
</head>
<body>
      <%
          response.sendRedirect(basePath+"index/index.action");
      %>
首页
</body>
</html>
