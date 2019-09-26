<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/25 0025
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("ctx",request.getContextPath());
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register - Input Form by Tooplate</title>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">
    <link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/static/css/materialize.min.css">
    <link rel="stylesheet" href="${ctx}/static/css/tooplate.css">
</head>

<body id="register">
<div class="container">
    <div class="row tm-register-row">
        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 tm-register-col-l">
            <form id="register_form" action="" method="post">
                <div class="mb-2">
                    <label class="mr-4">
                        <input class="with-gap" name="userType" type="radio" value="librarion" />
                        <span>图书管理员</span>
                    </label>
                    <label class="mr-4">
                        <input class="with-gap" name="userType" type="radio" value="reader" checked />
                        <span>普通读者</span>
                    </label>
                </div>

                <div class="input-field">
                    <input placeholder="用户名" id="username" name="username" type="text" class="validate">
                </div>
                <div class="input-field">
                    <input placeholder="密码" id="password" name="password" type="text" class="validate">
                </div>
                <div class="input-field">
                    <input placeholder="邮箱" id="email" name="email" type="text" class="validate">
                </div>
                <div class="input-field">
                    <input placeholder="手机号" id="mobile" name="mobile" type="text" class="validate">
                </div>
                <div class="input-field">
                    <input placeholder="地址" id="address" name="address" type="text" class="validate">
                </div>
                <div class="input-field">
                    <input placeholder="地区/省" id="district" name="district" type="text" class="validate">
                </div>
                <div class="row">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 pl-0 tm-pr-xs-0">
                        <select name="city">
                            <option value="-">你的城市</option>
                            <option value="Bangkok">武汉</option>
                            <option value="Yangon">天津</option>
                            <option value="Mumbai">北京</option>
                            <option value="Singapore">深圳</option>
                        </select>
                    </div>
                </div>
                <div class="text-right mt-4">
                    <button type="button" id="register_button" class="waves-effect btn-large btn-large-white px-4 black-text">注册</button>
                </div>
            </form>
        </div>
        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 tm-register-col-r">
            <header class="mb-5">
                <h3 class="mt-0 text-white">注册账号</h3>
                <p class="grey-text">热爱书吧---这是知识的源泉！ 只有知识才是有用的，只有它才能够使我们在精神上成为坚强、忠诚和有理智的人，成为能够真正爱人类、尊重人类劳动、衷心地欣赏人类那不间断的伟大劳动所产生的美好果实的人。 --《高尔基论青年》</p>
                <p class="grey-text">Love books - this is the source of knowledge! Only knowledge can be useful. Only knowledge can make us strong, loyal and rational in spirit, and can we truly love human beings, respect human labor, and sincerely appreciate the good fruits of the great human labor. Gorky on Youth
                </p>
            </header>

        </div>
    </div>
    <footer class="row tm-mt-big mb-3">
        <div class="col-xl-12">
            <p class="text-center grey-text text-lighten-2 tm-footer-text-small">
                Copyright &copy; 2018 Company Name

                - Design:  Tooplate / More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
        </div>
    </footer>
</div>

<script src="${ctx}/static/js/jquery-3.2.1.js"></script>
<script src="${ctx}/static/js/materialize.min.js"></script>
<script>
    $(document).ready(function () {
        $("#register_button").on("click",function(){
            $.ajax({
                url:"register",
                type:"post",
                dataType:"json",
                data:$("register_form").serialize(),
                success:function(data){
                    alert(data.message);
                }
            })
        })
    });
</script>
</body>

</html>