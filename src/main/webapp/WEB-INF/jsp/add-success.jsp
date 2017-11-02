<%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/11/2
  Time: 15:25
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
    <title>Title</title>
</head>
<body>
<div class="page-container">
 <input class="btn btn-primary radius"  type="button"  onclick="closeWindow()" value="&nbsp;&nbsp;ADD SUCCESS PLEASE CLOSE  WINDOW&nbsp;&nbsp;">
</div>
</body>
<jsp:include page="/commons/public-footer.jsp"/>
<script type="text/javascript" src="<%=path%>/static/layui/layui.js"></script>

<script type="text/javascript">
    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    function closeWindow () {
        parent.layer.close(index);
    }
</script>
</html>
