
<%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/11/3
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path =request.getContextPath();
%>
<html>
<head>

    <jsp:include page="/commons/public-head.jsp"/>
    <link rel="stylesheet" href="<%=path%>/static/layui/css/layui.css"  media="all">
    <title>ADD Admin</title>
</head>
<body>


<article class="page-container">
    <form class="form form-horizontal" id="form-admin-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Administrator：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="userName" name="userName">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Password：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="password" class="input-text" autocomplete="off" value="" placeholder="userPwd" id="userPwd" name="userPwd">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Confirm Password：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="password" class="input-text" autocomplete="off"  placeholder="Confirm Password" id="userPwd2" name="userPwd2">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Phone：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="userPhone" name="userPhone">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>Email：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" placeholder="@" name="userEmail" id="userEmail">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">Parking Lot：</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
                <select class="select" name="parkingUuid" size="1">
                    <c:choose>
                        <c:when test="${parkingLotList != null}">
                            <option value="0">ALL Parking Lot</option>
                            <c:forEach items="${parkingLotList}" var="lot">
                                <option value="${lot.uuid}">${lot.name}</option>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <option value="0">ALL Parking Lot</option>
                        </c:otherwise>
                    </c:choose>

                </select>
			</span> </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;Submit&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>






<jsp:include page="/commons/public-footer.jsp"/>
<script type="text/javascript" src="<%=path%>/static/layui/layui.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/validation/jquery.validate.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/validation/messages_zh.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/validation/validate-methods.js"></script>
<script type="text/javascript">

    $(function () {
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });
        $("#form-admin-add").validate({
            rules:{
                userName:{
                    required:true,
                    minlength:4,
                    maxlength:16
                },
                userPwd:{
                    required:true,
                },
                userPwd2:{
                    required:true,
                    equalTo: "#userPwd"
                },
                userPhone:{
                    required:true,
                    minlength:4,
                },
                userEmail:{
                    required:true,
                    email:true,
                }
            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                $(form).ajaxSubmit({
                    type: 'post',
                    url: "${pageContext.request.contextPath}/addAdmin" ,
                    success: function(data){
                        if (data.toString()== "Yes"){
                            //询问框
                            layer.confirm('Add SUCCESS !  Whether to continue adding ? ', {
                                btn: ['OK','NO'] //按钮
                            }, function(){
                                location.reload();
                            }, function(){
                                var index = parent.layer.getFrameIndex(window.name);
                                parent.$('.btn-refresh').click();
                                parent.layer.close(index);
                            });

                        }else {
                            layer.msg('error, Please try again!',{icon:1,time:1000});
                        }

                    },
                    error: function(XmlHttpRequest, textStatus, errorThrown){
                        layer.msg('error!',{icon:1,time:1000});
                    }
                });

            }
        });

    });

</script>
</body>
</html>
