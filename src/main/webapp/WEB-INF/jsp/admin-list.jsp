<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/10/30
  Time: 15:51
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
    <title>Administrator List</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> HOME <span class="c-gray en">&gt;</span> Administrator Management <span class="c-gray en">&gt;</span> Administrator List <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace('${pageContext.request.contextPath}/admin_list');" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c">
        <form action="${pageContext.request.contextPath}/admin/name" class="form form-horizontal" method="post">
            <input type="text" class="input-text" style="width:250px" placeholder="Enter the administrator name" id="name" name="name">
            <button type="submit" class="btn btn-success" id="submit"   name="submit"><i class="Hui-iconfont">&#xe665;</i> SEARCH</button>
        </form>

    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l"><a href="javascript:;" onclick="admin_add('Add Admin','add/admin','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> Add  Administrator</a></span>
        <span class="r">Total data：<strong>${adminList.total}</strong> SIZE</span> </div>
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
            <th>ParkingLot</th>
            <th width="130">AddTime</th>
            <th width="100">Status</th>
            <th width="100">operate</th>
        </tr>
        </thead>
        <tbody>

        <c:if test="${adminList!=null}">
            <c:forEach items="${adminList.dataList}" var="a">
                <tr class="text-c">
                    <td><input type="checkbox" value="1" name=""></td>
                    <td>${a.number}</td>
                    <td>${a.userName}</td>
                    <td>${a.userPhone}</td>
                    <td>${a.userEmail}</td>
                    <td>${a.type==1?'Super Administrator':a.parkingLotName}</td>
                    <td>${a.createTime}</td>
                    <c:if test="${a.status==1}">
                        <td class="td-status"><span class="label label-success radius">Enabled </span></td>
                    </c:if>
                    <c:if test="${a.status==0}">
                        <td class="td-status"><span class="label label-success radius">Disabled</span></td>
                    </c:if>

                    <td class="td-manage">
                        <a style="text-decoration:none" onClick="admin_stop(this,'10001')" href="javascript:;" title="停用">
                            <i class="Hui-iconfont">&#xe631;</i>
                        </a>
                        <a title="编辑" href="javascript:;" onclick="admin_edit('管理员编辑','admin-add.html','1','800','500')" class="ml-5" style="text-decoration:none">
                            <i class="Hui-iconfont">&#xe6df;</i></a>
                        <a title="删除" href="javascript:;" onclick="admin_del(this,'1')" class="ml-5" style="text-decoration:none">
                            <i class="Hui-iconfont">&#xe6e2;</i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </c:if >
        <c:if test="${adminList==null}">
            <tr>
                <th scope="col" colspan="9">No Find Administrator </th>
            </tr>
        </c:if>
        </tbody>
    </table>

    <c:if test="${adminList!=null}">
        <div class="page-container text-c">
            <c:if test="${adminList.pageNo!=1}">
                <button class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/admin_list?pageName=1">[FIRST]</button>
                <button class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/admin_list?pageName=${adminList.pageNo-1}">PREV</button>
            </c:if>
            <c:forEach begin="1" end="${adminList.pages}" var="n">
                <c:if test="${adminList.pageNo!=n }">
                    <button class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/admin_list?pageName=${n}"></button>
                </c:if>
                <c:if test="${adminList.pageNo==n }">
                    <button class="layui-btn layui-btn-disabled layui-btn-small" >${n}</button>
                </c:if>
            </c:forEach>
            <c:if test="${adminList.pages!=1}">
                <button class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/admin_list?pageName=${adminList.pageNo+1}">NEXT</button>
                <button class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/admin_list?pageName=${adminList.total}">[END]</button>
            </c:if>
        </div>
    </c:if>

</div>
<jsp:include page="/commons/public-footer.jsp"/>
<script type="text/javascript" src="<%=path%>/static/layui/layui.js"></script>

<script type="text/javascript">
    function admin_add (title,url,w,h) {
        layer_show(title,url,w,h);
    }
</script>
</body>
</html>
