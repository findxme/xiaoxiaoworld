
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setAttribute("ctx",request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>注册 - 小小世界图书馆</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="https://www.layuicdn.com/layui-v2.5.5/css/layui.css" media="all">
    <link href="${ctx}/static/img/logo.png" rel="icon" type="image/x-ico">
  <%--  <link rel="stylesheet" href="../../layuiadmin/style/admin.css" media="all">--%>
  <link rel="stylesheet" href="${ctx}/static/layuiAdmin/style/admin.css" media="all">
  <%--  <link rel="stylesheet" href="../../layuiadmin/style/login.css" media="all">--%>
  <link rel="stylesheet" href="${ctx}/static/layuiAdmin/style/login.css" media="all">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
</head>
<body>

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
  <div class="layadmin-user-login-main">
    <form id="register_form" action="" method="post">
    <div class="layadmin-user-login-box layadmin-user-login-header">
      <img  style="height: 5.3125rem; width: 5.9375rem;" src="${ctx}/static/img/logo.png">
      <h2>小小世界</h2>
      <p>小小世界图书管理系统</p>
    </div>
    <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
      <div class="layui-form-item">
        <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-nickname"></label>
        <input type="text" name="username" id="LAY-user-login-nickname" lay-verify="username|isExistUser" placeholder="昵称" class="layui-input">
      </div>
      <div class="layui-form-item">
        <label class="layadmin-user-login-icon layui-icon layui-icon-website" for="LAY-user-login-email"></label>
        <input type="text" name="email" id="LAY-user-login-email" lay-verify="email" placeholder="邮箱" class="layui-input">
      </div>
      <div class="layui-form-item">
        <label class="layadmin-user-login-icon layui-icon layui-icon-cellphone" for="LAY-user-login-cellphone"></label>
        <input type="text" name="phone" id="LAY-user-login-cellphone" lay-verify="phone|isExistPhone" placeholder="手机号" class="layui-input">
      </div>
      <div class="layui-form-item">
        <div class="layui-row">
          <div class="layui-col-xs7">
            <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
            <input type="text" name="vercode" id="LAY-user-login-vercode" lay-verify="required" placeholder="验证码" class="layui-input">
          </div>
          <div class="layui-col-xs5">
            <div style="margin-left: 10px;">
              <button type="button" class="layui-btn layui-btn-primary layui-btn-fluid" id="getAuthCode">获取验证码</button>
            </div>
          </div>
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
        <input type="password" name="password" id="LAY-user-login-password" lay-verify="pass" placeholder="密码" class="layui-input">
      </div>
      <div class="layui-form-item">
        <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-repass"></label>
        <input type="password" name="repass" id="LAY-user-login-repass" lay-verify="required" placeholder="确认密码" class="layui-input">
      </div>

      <div class="layui-form-item">
        <input type="radio" name="show" value="1" title="图书管理员" checked />
        <input type="radio" name="show" value="2" title="普通读者" />
      </div>
      <div class="layui-form-item">
        <input type="checkbox" name="agreement" lay-skin="primary" title="同意用户协议" checked>
      </div>
      <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" id="register_button" lay-submit lay-filter="LAY-user-reg-submit">注 册</button>
      </div>
      <div class="layui-trans layui-form-item layadmin-user-login-other">


        <a href="${ctx}/user/toLogin" class="layadmin-user-jump-change layadmin-link layui-hide-xs">用已有帐号登入</a>
        <a href="login.html" class="layadmin-user-jump-change layadmin-link layui-hide-sm layui-show-xs-inline-block">登入</a>
      </div>
    </div>
    </form>
  </div>

  <div class="layui-trans layadmin-user-login-footer">

    <p>© 2019 <a href="http://www.layui.com/" target="_blank">小小世界图书馆</a></p>

  </div>

</div>


  <script src="${ctx}/static/layuiAdmin/layui/layui.js"></script>
  <script>
    layui.config({
      base: '${ctx}/static/layuiAdmin/' //静态资源所在路径
    }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'user'], function(){
    var $ = layui.$
    ,setter = layui.setter
    ,admin = layui.admin
    ,form = layui.form
    ,router = layui.router();

    form.render();

      form.verify({
        //用户名是否存在
        isExistUser: function (value) {
          var data;
          $.ajax({
            async: false,
            type: 'POST',
            url: "${ctx}/user/isExistUser",
            data: {username: value},
            success: function (msg) {
              data=msg;
            }
          });
          if (data===1){
            return '用户名已存在';
          }
        },
        isExistPhone: function (value) {
          var data;
          $.ajax({
            async: false,
            type: 'POST',
            url: "${ctx}/user/isExistPhone",
            data: {phone: value},
            success: function (msg) {
              data=msg;
            }
          });
          if (data===1){
            return '手机号已存在';
          }
        }
      });

      //提交
      form.on('submit(LAY-user-reg-submit)', function(obj){
        var field = obj.field;

        //确认密码
        if(field.password !== field.repass){
          return layer.msg('两次密码输入不一致');
        }

        //是否同意用户协议
        if(!field.agreement){
          return layer.msg('你必须同意用户协议才能注册');
        }

        //$("#register_button").on("click",function(){
          var a=$("#LAY-user-login-nickname").val()
        //  alert(a);
          $.ajax({
            url:"${ctx}/user/registerUser",
            type:"post",
            dataType:"json",
            data:$("#register_form").serialize(),
            success:function(data){
              // alert(data.message);
              if(data===1){
               //layer.msg("注册成功")
                window.location.href = "${ctx}/user/toLogin";

              }
              if (data === 2) {
                layer.msg("请获取验证码");
              }
              if (data === 3) {
                layer.msg("验证码错误");
              }
            },
            complete:function(data){
             //  layer.close(loginPage);
             //  alert(data);
             // alert("888")
           /*   alert(data),
              $('form')[0].reset();*/
            }
          })
      //  })

        return false;
      });



      $('#getAuthCode').click(function () {
        $.ajax({
          type: "post",
          url: "${ctx}/user/registerGetAuthCode",
          data:{
            "email":$("#LAY-user-login-email").val()
          },
          success: function (code) {

          }
        });
        var count = 60;
        var countdown = setInterval(CountDown, 1000);

        function CountDown() {
          $("#getAuthCode").attr("disabled", true);
          $("#getAuthCode").text(count + "秒后重试");
          if (count == 0) {
            $("#getAuthCode").text("重新获取").removeAttr("disabled");
            clearInterval(countdown);
          }
          count--;
        }
      })
    });

  </script>
</body>
</html>