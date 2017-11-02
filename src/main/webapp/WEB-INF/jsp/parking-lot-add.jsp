<%--
  Created by IntelliJ IDEA.
  User: Extra
  Date: 2017/10/31
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
     String path =request.getContextPath();
%>
<html>
<head>

    <jsp:include page="/commons/public-head.jsp"/>
    <link rel="stylesheet" href="<%=path%>/static/layui/css/layui.css"  media="all">
    <title>PARKING LOT ADD</title>
</head>
<body>

<article class="page-container">
    <form class="form form-horizontal" id="form-admin-add" action="addParkingLot" method="post">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Parking Lot Name：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" required oninvalid="setCustomValidity('Please enter the field')"  oninput="setCustomValidity('')"  placeholder="" id="name" name="name">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Parking Lot Company：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  value="" required oninvalid="setCustomValidity('Please enter the field')"  oninput="setCustomValidity('')" placeholder="company" id="company" name="company">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Parking lot Address：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" required oninvalid="setCustomValidity('Please enter the field')"  oninput="setCustomValidity('')"   placeholder="address" id="address" name="address">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Parking lot EntryAddress：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  required oninvalid="setCustomValidity('Please enter the field')"  oninput="setCustomValidity('')"  placeholder="entryAddress" id="entryAddress" name="entryAddress">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>principal：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" required oninvalid="setCustomValidity('Please enter the field')"  oninput="setCustomValidity('')" placeholder="" id="principal" name="principal">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Contact Number：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" required oninvalid="setCustomValidity('Please enter the field')"  oninput="setCustomValidity('')"  placeholder="+75 6666666" name="contactNumber" id="contactNumber">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Area：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" required oninvalid="setCustomValidity('Please enter the field')"  oninput="setCustomValidity('')" placeholder="100㎡" name="area" id="area">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Quantity：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" required oninvalid="setCustomValidity('Please enter the field')"  oninput="setCustomValidity('')" name="quantity" id="quantity">
            </div>
        </div>

        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius"  type="submit"  value="&nbsp;&nbsp;Submit&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>
<jsp:include page="/commons/public-footer.jsp"/>
<script type="text/javascript" src="<%=path%>/static/layui/layui.js"></script>

</body>

</html>
