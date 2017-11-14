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
    int sn = 1;
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
    Member List <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace('${pageContext.request.contextPath}/member_list');" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>


    <div class="page-container">
        <div class="text-c">
            <form action="member_LPM" class="form form-horizontal" method="post">
                <input type="text" class="input-text" style="width:250px" placeholder="License plate number"  required oninvalid="show_noInput()"  oninput="setCustomValidity('')"  id="lpm" name="lpm">
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
                <th width="66">SN</th>
                <th width="100">Name</th>
                <th width="90">Phone</th>
                <th width="150">Email</th>
                <th lay-data="{width:80}">License plate number</th>
                <th width="130">AddTime</th>
                <th width="100">Status</th>
                <th width="100">operate</th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${page.dataList!= null}">
                    <c:forEach items="${page.dataList}" var="member">
                        <tr class="text-c">
                            <td><input type="checkbox" value="1" name=""></td>
                            <td><%=sn++%></td>
                            <td><u style="cursor:pointer" class="text-primary" onclick="member_show('${member.name}','member/uuid?uuid=${member.uuid}','400','450')">${member.name}</u></td>
                            <td>${member.phone}</td>
                            <td>${member.email}</td>
                            <td>${member.lpm}</td>
                            <td>${member.createTime}</td>
                            <c:choose>
                                <c:when test="${member.status==1}">
                                    <td class="td-status"><span class="label label-success radius">Enabled </span></td>
                                </c:when>
                                <c:otherwise>
                                    <td class="td-status"><span class="label label-success radius">Disabled</span></td>
                                </c:otherwise>
                            </c:choose>
                            <td class="td-manage">
                                <c:choose>
                                    <c:when test="${member.status==1}">
                                        <a style="text-decoration:none" onClick="member_stop(this,${member.uuid})" href="javascript:;" title="stop"><i class="Hui-iconfont">&#xe631;</i></a>
                                    </c:when>
                                    <c:otherwise>
                                        <a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="start"><i class="Hui-iconfont">&#xe6e1;</i></a>
                                    </c:otherwise>
                                </c:choose>

                                <a title="edit" href="javascript:;" onclick="member_edit('EDIT','member-add.html',${member.uuid},'','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
                                <a title="del" href="javascript:;" onclick="member_del(this,${member.uuid})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
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
            </tbody>
        </table>

        <c:if test="${page.pageNo!=0}">
            <div class="page-container text-c">

                    <c:if test="${page.pageNo!=1}">
                        <a class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/member_list?pageName=1">[FIRST]</a>
                        <a class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/member_ist?pageName=${page.pageNo-1}">PREV</a>
                    </c:if>
                    <c:forEach begin="1" end="${page.pages}" var="n">
                        <c:if test="${page.pageNo!=n }">
                            <a class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/member_list?pageName=${n}">${n}</a>'
                        </c:if>
                        <c:if test="${page.pageNo==n }">
                            <button class="layui-btn layui-btn-disabled layui-btn-small" >${n}</button>
                        </c:if>
                    </c:forEach>
                <c:if test="${page.pages!=1}">
                    <c:if test="${page.pageNo!=page.pages}">
                        <a class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/member_list?pageName=${page.pageNo+1}">NEXT</a>
                        <a class="layui-btn layui-btn-warm layui-btn-small" href="${pageContext.request.contextPath}/member_list?pageName=${page.total}">[END]</a>
                    </c:if>
                </c:if>
            </div>
        </c:if>



</div>

<jsp:include page="/commons/public-footer.jsp"/>
<script type="text/javascript" src="<%=path%>/static/layui/layui.js"></script>
<script type="text/javascript">

    /*用户-查看*/
    function member_show(title,url,w,h){
        layer_show(title,url,w,h);
    }


    function show_noInput() {
        layer.msg('Please Input License plate number', {icon: 1});
    }

    /*用户-停用*/
    function member_stop(obj,id){
        layer.confirm('Do you want to disable it?',
            {btn:['Ok','Cancel']},function(index){
            $.ajax({
                type: 'POST',
                url: '',
                dataType: 'json',
                success: function(data){
                    $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
                    $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
                    $(obj).remove();
                    layer.msg('Disabled!',{icon: 5,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }

    /*用户-启用*/
    function member_start(obj,id){
        layer.confirm('Do you want to enable it?',
            {btn:['Ok','Cancel']},function(index){
            $.ajax({
                type: 'POST',
                url: '',
                dataType: 'json',
                success: function(data){
                    $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
                    $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
                    $(obj).remove();
                    layer.msg('activated!',{icon: 6,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }
    /*用户-编辑*/
    function member_edit(title,url,id,w,h){
        layer_show(title,url,w,h);
    }

    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('Do you want to delete it?',
            {btn:['Ok','Cancel']},function(index){
            $.ajax({
                type: 'POST',
                url: '',
                dataType: 'json',
                success: function(data){
                    $(obj).parents("tr").remove();
                    layer.msg('deleted!',{icon:1,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }
</script>
</body>
</html>
