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
    <link rel="stylesheet" href="<%=path%>/static/layui/css/layui.css"  media="all">
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
        <table id="parking_lot_list"  class="table table-border table-bordered table-bg table-hover table-sort">
            <thead>
              <tr class="text-c">
                  <th lay-data="{field:'id', width:80, sort: true, fixed: true}">ID</th>
                  <th>Parking lot number</th>
                  <th>Parking lot name</th>
                  <th>Parking address</th>
                  <th>Parking lot telephone</th>
                  <th>Parking lot leader</th>
                  <th>Parking spaces</th>
                  <th>Parking lot status</th>
                  <th lay-data="{fixed: 'right', width:160, align:'center', toolbar: '#barDemo'}"></th>
              </tr>
            </thead>
            <tbody  id="tableBody">

            </tbody>
        </table>
        <div class="page-container text-c" id="lot_page">
        </div>
    </div>
</div>



<jsp:include page="/commons/public-footer.jsp"/>
<script type="text/javascript" src="<%=path%>/static/layui/layui.js"></script>
<script>

    var  selectpage;
    var  selectNumber;




    function loadParkingLotList(pageName,limitName,timeMin,timeMax,parkingLotName) {
        var url = "parkingLot/list";
        var  reqPara={"pageName":pageName,"limitName":limitName,"timeMin":timeMin,"timeMax":timeMax,"parkingLotName":parkingLotName};
        $(function () {
            $.ajax({
                type:"post",
                url:url,
                data:reqPara,
                async:true,
                dataType:"json",
                success:function (data) {
                    if (data.code == 1){
                        var  dataList = data.data.dataList;
                        layui.use('laypage',function () {
                            var laypage =layui.laypage;
                            //执行实例
                            laypage.render({
                                elem:'lot_page',
                                count:data.data.total,
                                layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
                                jump:function (obj, first) {

                                    console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                                    console.log(obj.limit); //得到每页显示的条数

                                }
                            });
                            $("#tableBody").empty();
                            if (dataList.length>0){

                                var  id=1;
                                $(dataList).each(function () {
                                    var stastsHtml = this.status==1?'<td class="td-status"><span class="label label-success radius">Normal </span></td>':'<span class="label label-danger radius">abnormal</span>';
                                    var html =
                                        '<tr  class="text-c">'+
                                            '<td>' +  (id++) + '</td>'+
                                            '<td>' +  this.number + '</td>'+
                                            '<td>' +  this.name + '</td>'+
                                            '<td>' +  this.address + '</td>'+
                                            '<td>' +  this.contactNumber + '</td>'+
                                            '<td>' +  this.area +"㎡"+ '</td>'+
                                            '<td>' +  this.quantity + '</td>'+
                                            stastsHtml+
                                           '<td class="td-manage">' +
                                        '<a style="text-decoration:none"   title="stop"><i class="Hui-iconfont">&#xe6de;</i></a> <a style="text-decoration:none" class="ml-5" title="edit"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" title="del"><i class="Hui-iconfont">&#xe6e2;</i></a></td>';
                                        $("#tableBody").append(html);
                                });
                            }else {

                            }
                        });
                    }
                }
            });
        })

    }


    $(function () {
       loadParkingLotList(1,10,"","","");
    });

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
       layer.open({
            type:2,
           area: ['700', '450'],
            title:obj,
           fixed: false, //不固定
            content:url,
           maxmin: true,
            lang:'en'
        });
    }
</script>
</body>
</html>
