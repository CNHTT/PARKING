<%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/12/12
  Time: 10:59
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
    <form class="form form-horizontal" id="form-device-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>SN：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" required oninvalid="setCustomValidity('Please enter the field')"  oninput="setCustomValidity('')"  placeholder="" id="sn" name="sn">
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
        $("#form-device-add").validate({
            rules:{
                sn:{
                    required:true,
                    minlength:4,
                    maxlength:16
                }
            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                $(form).ajaxSubmit({
                    type: 'post',
                    url: "${pageContext.request.contextPath}/addDevice" ,
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