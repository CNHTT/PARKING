<%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/10/30
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
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
        <button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> SEARCH</button>
    </div>

    <div class="cl pd-5 bg-1 bk-gray mt-20">
		<span class="l">
            <a class="btn btn-primary radius" onclick="parkingLot_add('ADD PARKING LOT','parking_lot_add')" href="javascript:;">
                <i class="Hui-iconfont">&#xe600;</i> ADD PARKING LOT</a>
		</span> <span class="r">total data：<strong>54</strong> item</span>
    </div>

    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort">
            <thead>
              <tr class="text-c">
                  <th>ID</th>
                  <th>Parking lot number</th>
                  <th>Parking lot name</th>
                  <th>Parking address</th>
                  <th>Parking lot telephone</th>
                  <th>Parking lot leader</th>
                  <th>parking spaces</th>
                  <th>Parking lot status</th>
                  <th>operate</th>
              </tr>
            </thead>
            <tbody>
              <tr>

              </tr>
            </tbody>
        </table>
    </div>
</div>



<!--public footer-->
<jsp:include page="/commons/public-footer.jsp"/>
<script type="text/javascript" src="<%=path%>/static/layui/layui.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    //https://cdn.datatables.net/
    //https://datatables.net/release-datatables/examples/api/select_single_row.html
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


    function parkingLot_add (obj,url) {
        var index = layer.open({
            type:2,
            title:obj,
            content:url
        });
        layer.full(index)
    }
</script>
</body>
</html>
