<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/11/7
  Time: 14:22
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
    <title>Member Info</title>
</head>
<body>
<div class="cl pd-20" style=" background-color:#5bacb6">
    <img class="avatar size-XL l" src="/static/images/ucnter/avatar-default.jpg">
    <dl style="margin-left:80px; color:#fff">
        <dt>
            <span class="f-18">${member.name}</span>
            <span class="pl-10 f-12">Balance：${member.balance}</span>
        </dt>
        <dd class="pt-10 f-12" style="margin-left:0">This guy is lazy, leaving nothing left</dd>
    </dl>
</div>

<div class="pd-20">
    <table class="table">
        <tbody>
        <tr>
            <th class="text-r" width="80">Gender：</th>
            <td>${member.sex==1?'men':'women'}</td>
        </tr>
        <tr>
            <th class="text-r">Phone：</th>
            <td>${member.phone}</td>
        </tr>
        <tr>
            <th class="text-r">Email：</th>
            <td>${member.email}</td>
        </tr>

        <tr>
            <th class="text-r">LPM：</th>
            <td>${member.lpm}</td>
        </tr>


        <tr>
            <th class="text-r">Address：</th>
            <td>${member.contactAddress}</td>
        </tr>
        <tr>
            <th class="text-r">Registration time：</th>
            <td>${member.createTime}</td>
        </tr>
        </tbody>
    </table>
</div>

<jsp:include page="/commons/public-footer.jsp"/>
</body>
</html>
