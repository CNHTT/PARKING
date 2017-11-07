<%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/10/30
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <jsp:include page="/commons/public-head.jsp"/>
    <link rel="stylesheet" href="<%=path%>/static/layui/css/layui.css"  media="all">
    <title>Recharge Record</title>
</head>
<body>
    <nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>
        HOME <span class="c-gray en">&gt;</span>
        Transaction Record <span class="c-gray en">&gt;</span>
        Recharge Record<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace('/recharge_page');" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>




充值记录
</body>
</html>
