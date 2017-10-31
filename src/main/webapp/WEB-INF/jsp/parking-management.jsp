<%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/10/30
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/commons/public-head.jsp"/>
    <link rel="stylesheet" href="../../static/layui/css/layui.css"  media="all">
    <title>PARKING LOT</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i>Home <span class="c-gray en">&gt;</span> Parking Lot management <span class="c-gray en">&gt;</span> PARKING LOT
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="Refresh" ><i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<!--http://www.layui.com/demo/laydate.html-->
<div class="page-container">
    <div class="text-c" >Date range:
        <input type="text" id="logmin" class="input-text" style="width: 120px;" placeholder="yyyy-MM-dd">
        -
        <input type="text" id="logmax" class="input-text" style="width: 120px;" placeholder="yyyy-MM-dd">
        <input type="text" name="" id="parkingLotNumber"  style="width:250px" class="input-text">
        <button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜图片</button>
    </div>

</div>




<script src="../../static/layui/layui.js" charset="utf-8"></script>
<!--public footer-->
<jsp:include page="/commons/public-footer.jsp"/>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        //国际版
        laydate.render({
            elem: '#logmin'
            ,lang: 'en'
        });
        laydate.render({
            elem: '#logmax'
            ,lang: 'en'
        });
    });
</script>
</body>
</html>
