<%@ page import="com.extra.model.HomeBean" %><%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/10/30
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HomeBean home = (HomeBean) request.getAttribute("data");
%>
<html>
<head>
    <jsp:include page="/commons/public-head.jsp"/>
    <title>Home</title>
</head>
<body>

<div class="page-container">
    <p class="f-20 text-success">Welcome to SZFP Technology Limited parking management system</p>
    <p>Number of login：<%=home.getLoginNum()%></p>
    <p>Last login IP：<%=home.getIp()%>       Last Login Time：<%=home.getTime()%></p>
</div>

<!--public footer-->
<jsp:include page="/commons/public-footer.jsp"/>
</body>
</html>
