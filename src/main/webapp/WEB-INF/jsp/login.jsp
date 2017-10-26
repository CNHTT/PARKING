<%--
  Created by IntelliJ IDEA.
  User: Extra
  Date: 2017/10/26
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String result= ":";
%>
<html>
<head>
    <link href="<%=path%>/static/css/ui.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/static/css/ui.login.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/static/css/style.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/static/fonts/icon/iconfont.css" rel="stylesheet" type="text/css" />
    <title>Background landing</title>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
    <div id="loginform" class="loginBox">

        <div class="loginHint" id="loginHint"><%=result%></div>
        <form class="form form-horizontal" action="index.html" method="post">
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
                <div class="formControls col-xs-8">
                    <input id="username" name="username" type="text" placeholder="Your email or username" class="input-text size-L">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
                <div class="formControls col-xs-8">
                    <input id="password" name="password" type="password" placeholder=" Your password " class="input-text size-L">
                </div>
            </div>
            <div class="row cl">
                <div class="formControls col-xs-8 col-xs-offset-3">
                    <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;SIGN IN&nbsp;">
                    <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;CANCEL&nbsp;">
                </div>
            </div>
        </form>
    </div>
</div>
<div class="footer">Copyright SZFP Technology Limited by admin v1</div>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/ui.min.js"></script>
</body>
</html>
