<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登入 - layuiAdmin</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="https://www.layuicdn.com/layui-v2.5.5/css/layui.css" media="all">
    <%--  <link rel="stylesheet" href="../../layuiadmin/style/admin.css" media="all">--%>
    <link rel="stylesheet" href="${ctx}/static/layuiAdmin/style/admin.css" media="all">
    <%--  <link rel="stylesheet" href="../../layuiadmin/style/login.css" media="all">--%>
    <link rel="stylesheet" href="${ctx}/static/layuiAdmin/style/login.css" media="all">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
</head>
<body>

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2 id="title">管理员登录</h2>
            <p>小小世界图书管理系统登陆</p>
        </div>
        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-username"
                       for="LAY-user-login-username"></label>
                <input type="text" name="userName" id="LAY-user-login-username" lay-verify="required" placeholder="用户名"
                       class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password"
                       for="LAY-user-login-password"></label>
                <input type="password" name="password" id="LAY-user-login-password" lay-verify="required"
                       placeholder="密码" class="layui-input">
            </div>

            <div class="layui-form-item">
                <div class="layui-row">
                    <div class="layui-col-xs7">
                        <label class="layadmin-user-login-icon layui-icon layui-icon-vercode"
                               for="LAY-user-login-vercode"></label>
                        <input type="text" id="LAY-user-login-vercode" lay-verify="required|isVerifyCode"
                               placeholder="图形验证码"
                               class="layui-input" name="verifyCode">
                    </div>
                    <div class="layui-col-xs5">
                        <div style="margin-left: 10px;">
                            <img src="${ctx}/user/verifyCode" class="layadmin-user-login-codeimg" id="img"
                                 onclick="img()">
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-form-item" id="userType">
                <input type="radio" id="userType1" name="userType" value="admin" title="图书管理员" checked/>
                <input type="radio" id="userType2" name="userType" value="reader" title="普通读者"/>
            </div>
            <div class="layui-form-item" style="margin-bottom: 20px;">
                <input type="checkbox" name="remember" lay-skin="primary" title="记住密码">
                <a href="user/forget.html" class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;">忘记密码？</a>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit">登 入</button>
            </div>
            <div class="layui-trans layui-form-item layadmin-user-login-other">
                <a href="toRegister" class="layadmin-user-jump-change layadmin-link">注册帐号</a>
            </div>
        </div>
    </div>

    <div class="layui-trans layadmin-user-login-footer">

        <p>© 2019 <a href="#" target="_blank">小小世界图书馆</a></p>
    </div>

    <!--<div class="ladmin-user-login-theme">
      <script type="text/html" template>
        <ul>
          <li data-theme=""><img src="{{ layui.setter.base }}style/res/bg-none.jpg"></li>
          <li data-theme="#03152A" style="background-color: #03152A;"></li>
          <li data-theme="#2E241B" style="background-color: #2E241B;"></li>
          <li data-theme="#50314F" style="background-color: #50314F;"></li>
          <li data-theme="#344058" style="background-color: #344058;"></li>
          <li data-theme="#20222A" style="background-color: #20222A;"></li>
        </ul>
      </script>
    </div>-->

</div>

<script src="${ctx}/static/layuiAdmin/layui/layui.js"></script>
<script>
    function img() {
        document.getElementById("img").src = "${ctx}/user/verifyCode?a=" + Math.random();
    };
    layui.config({
        base: '${ctx}/static/layuiAdmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'user'], function () {
        var $ = layui.$
            , setter = layui.setter
            , admin = layui.admin
            , form = layui.form
            , router = layui.router()
            , search = router.search;

        form.render();

        form.verify({
            isVerifyCode: function (value) {
                var data;
                $.ajax({
                    async: false,
                    type: 'POST',
                    url: "${ctx}/user/isVerifyCode",
                    data: {verifyCode: value},
                    success: function (msg) {
                        data = msg;
                    }
                });
                if (data === 1) {
                    return '验证码错误';
                }
            },
        });

        //提交
        form.on('submit(LAY-user-login-submit)', function (obj) {

            //请求登入接口
            admin.req({
                url: '${ctx}/user/login2' //实际使用请改成服务端真实接口
                , data: obj.field
                , done: function (res) {

                    if (res.count === 0) {
                        layer.msg('登入成功', {
                            offset: '15px'
                            , icon: 1
                            , time: 1000
                        }, function () {
                            location.href = '${ctx}/user/home'; //后台主页
                        });

                    }else {
                        layer.msg(res.msg);
                    }



                }
            });


        });


        $("#userType").on("click", function () {
            if ($("#userType1").prop("checked")) {
                $("#title").html("管理员登录");
            } else {
                $("#title").html("读者登录");
            }
        });
    });

</script>
</body>
</html>