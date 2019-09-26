<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/25 0025
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1>学生登录</h1>
        </div>

        <c:if test="${errorMess!=null}">
            <font color="red"></font>
        </c:if>
        <div class="design-w3l">
            <div class="mail-form-agile">
                <form id="login_form" name="login_form" action="" method="post" >
                    <input id="userName" type="text" name="userName" placeholder="用户名" required/>
                    <input id="password" type="password"  name="password" class="padding" placeholder="密码" required=""/>
                    <button id="login_button" class="login_button">登录</button>
                </form>
            </div>
            <div class="clear"> </div>
        </div>

        <div class="footer">
            <p>还没账户，<a href="toRegister" >快来注册</a></p>
        </div>
    </div>
</div>

</body>
</html>

