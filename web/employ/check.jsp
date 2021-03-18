<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.springframework.ui.Model" %>

<!doctype html>
<html lang="zh_CN">
<head meta http-equiv="refresh" content="5">
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
    <script>
            var a="${pass}"
            if(a=='审核成功'){
                alert('审核通过!即将跳转页面...');
                window.setTimeout(" window.location='/JiaZheng/employ/index2.jsp'",3000);
            }else if (a=='审核失败'){
                alert('审核失败!即将跳转页面...');
                window.setTimeout(" window.location='/JiaZheng/employ/index2.jsp'",3000);
            }else {
                alert('还在进行审核中,请耐心等待....');
            }
    </script>
    <title>Title</title>
</head>
<body>

</body>

<script language="JavaScript">
    function myrefresh()
    {
        window.location.reload();
    }
    setTimeout('myrefresh()',5000); //指定1秒刷新一次
</script>
</html>
