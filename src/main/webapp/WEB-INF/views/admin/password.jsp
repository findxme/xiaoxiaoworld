<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>设置我的密码</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="https://www.layuicdn.com/layui-v2.5.5/css/layui.css" media="all">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">修改密码</div>
                <div class="layui-card-body" pad15>

                    <div class="layui-form">
                        <form>
                            <div class="layui-form-item">
                                <label class="layui-form-label">当前密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="oldPassword" lay-verify="required" lay-verType="tips"
                                           class="layui-input" id="oldPassword">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">新密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" lay-verify="required|pass" lay-verType="tips"
                                           autocomplete="off" id="LAY_password" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">确认新密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="repassword" lay-verify="required|passsword"
                                           lay-verType="tips"
                                           autocomplete="off" class="layui-input" id="repassword">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-inline">
                                    <label class="layui-form-label">验证码</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="authCode" lay-verify="required" lay-verType="tips"
                                               autocomplete="off" class="layui-input layui-col-md4" id="authCode">
                                    </div>
                                </div>
                                <div class="layui-inline">
                                    <div class="layui-input-inline">
                                        <button type="button" class="layui-btn layui-btn-primary" id="getAuthCode">
                                            获取验证码
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button type="button" class="layui-btn" lay-submit lay-filter="formDemo">确认修改
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://www.layuicdn.com/layui-v2.5.5/layui.js"></script>
<script>
    $(function () {

        $('#getAuthCode').click(function () {
            $.ajax({
                type: "post",
                url: "${ctx}/user/getAuthCode",
                // data: "",//获取表单邮箱
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
<script>
    layui.use('form', function () {
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
        form.render();
        form.verify({
            passsword: function (value, item) { //value：表单的值、item：表单的DOM对象
                if ($("#LAY_password").val() != value) {
                    return '两次密码不一致';
                }
            }
            , pass: [
                /^[\S]{6,16}$/
                , '密码必须6到16位，且不能出现空格'
            ]
        });

        form.on('submit(formDemo)', function (data) {
            $.ajax({
                type: 'POST',
                url: "${ctx}/user/setPassword",
                data: {
                    oldPassword: $("#oldPassword").val(),
                    repassword: $("#repassword").val(),
                    authCode: $("#authCode").val()
                },
                success: function (msg) {
                    if (msg === 0) {
                        layer.msg("修改成功");
                        $('form')[0].reset();
                    }
                    if (msg === 1) {
                        layer.msg("旧密码错误");
                    }
                    if (msg === 2) {
                        layer.msg("验证码错误");
                    }
                    if (msg === 3) {
                        layer.msg("系统异常");
                    }
                }
            });
            return false;
        });
    });
</script>
</body>
</html>