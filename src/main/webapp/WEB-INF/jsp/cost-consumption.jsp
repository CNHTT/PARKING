<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Transaction Record</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>
    HOME <span class="c-gray en">&gt;</span>
    Transaction Record <span class="c-gray en">&gt;</span>
    Recharge Record<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace('${pageContext.request.contextPath}/parking_completed');" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

<div class="page-container">
    <div class="text-c">
        <form action="recharge.lpm" class=" form-horizontal" method="post">
            <input type="text" class="input-text" style="width:250px" placeholder="License plate number"  required oninvalid="show_noInput()"   id="lpm" name="lpm">
            <button type="submit" class="btn btn-success" id="submit"   name="submit"><i class="Hui-iconfont">&#xe665;</i> SEARCH</button>
        </form>
    </div>



    <!--显示总条数-->
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="r">Total data：<strong>${page.total}</strong> SIZE</span>
    </div>



    <!--显示所有的数据-->
    <table class="table table-border table-bordered table-bg">

        <thead>
        <tr>
            <th scope="col" colspan="10">
                Consumption  Record List
            </th>
        </tr>
        <tr class="text-c">
            <th width="25"><input type="checkbox" name="" value=""></th>
            <th>Transaction serial number</th>
            <th>License Plate</th>
            <th>Name</th>
            <th>Amount</th>
            <th>Before</th>
            <th>After</th>
            <th>OperateNumber</th>
            <th>DeviceNumber</th>
            <th>Time</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${page.dataList.size()!= 0}">
                <c:forEach items="${page.dataList}" var="record">
                    <tr class="text-c">
                        <td><input type="checkbox" value="1" name=""></td>
                        <td>${record.tsn}</td>
                        <td>${record.memberLPM}</td>
                        <td>
                            <u style="cursor:pointer" class="text-primary"
                               onclick="member_show('${record.memberName}','member/uuid?uuid=${record.memberUuid}','400','450')">
                                    ${record.memberName}
                            </u>
                        </td>
                        <td>${record.rAmount}</td>
                        <td>${record.bAmount}</td>
                        <td>${record.aAmount}</td>
                        <td>${record.operateNumber}</td>
                        <td>${record.deviceNumber}</td>
                        <td>${record.createTime}</td>
                    </tr>
                </c:forEach>
            </c:when>


            <c:otherwise>
                <tr>
                    <td  scope="col" colspan="10"> No Find Consumption  Record List!!!  Consumption  Record List</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>


    <c:if test="${page.total!=0}">
        <div class="page-container text-c">
            <c:if test="${page.pageNo!=1}">
                <button class="layui-btn layui-btn-warm layui-btn-small"
                        href="${pageContext.request.contextPath}/consumption?pageName=1">
                    [FIRST]
                </button>
                <button class="layui-btn layui-btn-warm layui-btn-small"
                        href="${pageContext.request.contextPath}/consumption?pageName=${page.pageNo-1}">
                    PREV
                </button>

                <c:forEach begin="1" end="${page.pages}" var="n">
                    <c:if test="${page.pageNo!=n }">
                        <button class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/consumption?pageName=${n}"></button>'
                    </c:if>
                    <c:if test="${page.pageNo==n }">
                        <button class="layui-btn layui-btn-disabled layui-btn-small" >${n}</button>
                    </c:if>
                </c:forEach>


                <c:if test="${page.pages!=1}">
                    <c:if test="${page.pageNo!=page.pages}">
                        <button class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/consumption?pageName=${page.pageNo+1}">NEXT</button>
                        <button class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/consumption?pageName=${page.total}">[END]</button>
                    </c:if>
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
