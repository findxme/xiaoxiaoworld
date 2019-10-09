<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/25 0025
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("ctx",request.getContextPath());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>登录</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">


    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/style.css">

</head>

<body>
<div class="padding-all">
    <div class="panel-form">
        <div class="header">
            <h1 id="title">读者登录</h1>
        </div>

        <div class="errorMsg" id="errorMsg" style="width: 200px;background-color: #3c3c3c;margin:0px 100px;font-size: 20px;color: red;"></div>
        <div class="design-w3l">
            <div class="mail-form-agile">
                <form id="login_form" name="login_form" action="" >
                    <input id="userName" type="text" name="userName" placeholder="用户名" required/>
                    <input id="password" type="password"  name="password" class="padding" placeholder="密码" required=""/>
                    <div id="userType">
                        <div style="margin: 0px -70px;float: left; color: #b9def0;"><input id="userType1" name="userType" type="radio" value="admin"/>管理员</div>
                        <div style="margin: 0px -20px;float: right; color: #b9def0;"><input id="userType2" name="userType" type="radio" value="reader" checked/>读者</div>
                    </div>
                    <button id="login_button" type="button" class="login_button">登录</button>
                </form>
            </div>
            <div class="clear"> </div>
        </div>

        <div class="footer">
            <p>还没账户，<a href="toRegister" >快来注册</a></p>
        </div>
    </div>
    <script type="text/javascript" src="${ctx}/static/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${ctx}/static/layer/layer.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/cookieDao.js"></script>
    <script type="text/javascript">
        var loginPage;
        $(function(){
            $("#userType").on("click",function(){
                if($("#userType1").prop("checked")){
                    $("#title").html("管理员登录");
                }else{
                    $("#title").html("读者登录");
                }
            });

            $("#login_button").on("click",function(){
                $.ajax({
                    url:"${ctx}/user/login",
                    type:"post",
                    dataType:"json",
                    data:$("#login_form").serialize(),
                    beforeSend:function(){
                        loginPage =  layer.msg('登录中...', {icon: 16,shade: [0.5, '#f5f5f5'],scrollbar: false,offset: '0px',time: 0});
                    },
                    success:function(data){
                        var userType = $("input[name='userType']:checked").val();
                        if(data.status===200){
                            if(userType==="reader"){
                                addCookie("readerNo",data.message,1)
                                addCookie("readerName",$("#userName").val(),1)
                            }else{
                                addCookie("adminNo",data.message,1)
                                addCookie("adminName",$("#userName").val(),1)
                            }
                            window.location="home"
                        }else{
                            $("#errorMsg").html(data.message)
                        }

                    },
                    complete:function(){
                        layer.close(loginPage);
                    }
                })
            });
        });


    </script>
</div>

</body>
</html>

