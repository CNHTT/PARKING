<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/10/30
  Time: 15:28
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
    <title>Member List</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>
    HOME <span class="c-gray en">&gt;</span>
    Member Management <span class="c-gray en">&gt;</span>
    Member List <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>


    <div class="page-container">
        <div class="text-c">
            <form action="member/LPM" class="form form-horizontal" method="post">
                <input type="text" class="input-text" style="width:250px" placeholder="License plate number" id="name" name="name">
                <button type="submit" class="btn btn-success" id="submit"   name="submit"><i class="Hui-iconfont">&#xe665;</i> SEARCH</button>
            </form>
        </div>

        <div class="cl pd-5 bg-1 bk-gray mt-20">
            <span class="r">Total data：<strong>${page.total}</strong> SIZE</span> </div>



        <table class="table table-border table-bordered table-bg">

            <thead>
            <tr>
                <th scope="col" colspan="9">Administrator List</th>
            </tr>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="" value=""></th>
                <th width="66">Number</th>
                <th width="100">Name</th>
                <th width="90">Phone</th>
                <th width="150">Email</th>
                <th lay-data="{width:80}">Contact Address</th>
                <th width="130">AddTime</th>
                <th width="100">Status</th>
                <th width="100">Balance</th>
                <th width="100">operate</th>
            </tr>
            </thead>
            <c:choose>
                <c:when test="${page.dataList!= null}">
                    <c:forEach items="${page.dataList}" var="member">
                        <tr class="text-c">
                            <td>${member.number}</td>
                            <td>${member.name}</td>
                            <td>${member.phone}</td>
                            <td>${member.email}</td>
                            <td>${member.contactAddress}</td>
                            <td>${member.createTime}</td>
                            <c:choose>
                                <c:when test="${member.status==1}">
                                    <td class="td-status"><span class="label label-success radius">Enabled </span></td>
                                </c:when>
                                <c:otherwise>
                                    <td class="td-status"><span class="label label-success radius">Disabled</span></td>
                                </c:otherwise>
                            </c:choose>
                            <td>
                                <fmt:formatNumber value="${member.balance}" pattern="#,#00.0#"/>
                            </td>
                            <td class="td-manage">
                                <a style="text-decoration:none" onClick="member_stop(this,'10001')" href="javascript:;" title="disa"><i class="Hui-iconfont">&#xe631;</i></a>
                                <a title="edit" href="javascript:;" onclick="member_edit('EDIT','member-add.html','4','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
                                <a title="删除" href="javascript:;" onclick="member_del(this,${member.uuid})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td  scope="col" colspan="10"> No Find Member!!!  Please Add  Member</td>
                    </tr>
                </c:otherwise>
            </c:choose>

        </table>
</div>
<script type="text/javascript" src="<%=path%>/static/layui/layui.js"></script>

</body>
</html>
