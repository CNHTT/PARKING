<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/10/30
  Time: 15:06
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
    <title>Device List</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>
    HOME <span class="c-gray en">&gt;</span>
    Device Management <span class="c-gray en">&gt;</span>
    Device List<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace('${pageContext.request.contextPath}/admin_list');" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

<div class="page-container">

    <!--显示总条数-->
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="r">Total data：<strong>${page.total}</strong> SIZE</span>
    </div>

    <table class="table table-border table-bordered table-bg">

        <thead>
        <tr>
            <th scope="col" colspan="5">
                Device List
            </th>
        </tr>
        <tr class="text-c">
            <th width="25"><input type="checkbox" name="" value=""></th>
            <th>Number</th>
            <th>S/N</th>

            <th>Time</th>
            <th>Status</th>
        </tr>
        </thead>

        <tbody>
        <c:choose>
            <c:when test="${page.dataList.size()!=0}">
                <c:forEach items="${page.dataList}" var="record">
                    <tr class="text-c">
                        <td><input type="checkbox" value="1" name=""></td>
                        <td>${record.number}</td>
                        <td>${record.sn}</td>
                        <td>${record.createTime}</td>
                        <c:if test="${record.status==1}">
                            <td class="td-status"><span class="label label-success radius">Enabled </span></td>
                        </c:if>
                        <c:if test="${record.status==0}">
                            <td class="td-status"><span class="label label-success radius">Disabled</span></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </c:when>


            <c:otherwise>
                <tr>
                    <td  scope="col" colspan="10"> No Find Recharge Record List!!!  Recharge Record List</td>
                </tr>
            </c:otherwise>
        </c:choose>


        </tbody>
    </table>

    <c:if test="${page.pageNo!=0}">
        <div class="page-container text-c">

            <c:if test="${page.pageNo!=1}">
                <button class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/parking_records?pageName=1">[FIRST]</button>
                <button class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/parking_records?pageName=${page.pageNo-1}">PREV</button>
            </c:if>
            <c:forEach begin="1" end="${page.pages}" var="n">
                <c:if test="${page.pageNo!=n }">
                    <button class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/parking_records?pageName=${n}"></button>
                </c:if>
                <c:if test="${page.pageNo==n }">
                    <button class="layui-btn layui-btn-disabled layui-btn-small" >${n}</button>
                </c:if>
            </c:forEach>
            <c:if test="${page.pages!=1}">
                <c:if test="${page.pageNo!=page.pages}">
                    <button class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/parking_records?pageName=${page.pageNo+1}">NEXT</button>
                    <button class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/parking_records?pageName=${page.total}">[END]</button>
                </c:if>
            </c:if>
        </div>
    </c:if>




</div>




<jsp:include page="/commons/public-footer.jsp"/>
<script type="text/javascript" src="<%=path%>/static/layui/layui.js"></script>
<script type="text/javascript">
    function show_noInput() {
        layer.msg('Please Input License plate number', {icon: 1});
    }

    /*用户-查看*/
    function member_show(title,url,w,h){
        layer_show(title,url,w,h);
    }

</script>
</body>
</html>
