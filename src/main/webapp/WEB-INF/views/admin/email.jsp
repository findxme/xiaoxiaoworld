<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>邮件服务</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="https://www.layuicdn.com/layui-v2.5.5/css/layui.css" media="all">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <style>
        .layui-form-label {
            width: 100px;
        }
    </style>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">邮件服务</div>
                <div class="layui-card-body">

                    <div class="layui-form" wid100 lay-filter="">
                        <form>
                            <div class="layui-form-item">
                                <label class="layui-form-label">SMTP服务器</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="smtp" value="${smtp}"  lay-verify="required" class="layui-input" id="smtp">
                                </div>
                                <div class="layui-form-mid layui-word-aux">如：smtp.163.com</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">SMTP端口号</label>
                                <div class="layui-input-inline" style="width: 80px;">
                                    <input type="text" name="prot" lay-verify="number" lay-verify="required" value="${prot}"
                                           class="layui-input" id="prot">
                                </div>
                                <div class="layui-form-mid layui-word-aux">一般为 25 或 465</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">发件人邮箱</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="email" value="${email}" lay-verify="required" lay-verify="email"
                                           autocomplete="off" class="layui-input" id="email">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">发件人昵称</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="name" value="${name}" lay-verify="required" autocomplete="off"
                                           class="layui-input" id="name">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">邮箱登入密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="password" value="${password}" autocomplete="off"
                                           class="layui-input" id="password">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button class="layui-btn" lay-submit lay-filter="set_system_email">确认保存</button>
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
    layui.use('form', function () {
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
        form.render();

        form.on('submit(set_system_email)', function (data) {
            $.ajax({
                type: 'POST',
                url: "${ctx}/user/setEmail",
                data: {
                    smtp: $("#smtp").val(),
                    prot: $("#prot").val(),
                    email: $("#email").val(),
                    name: $("#name").val(),
                    password: $("#password").val()
                },
                success: function (msg) {
                    if (msg === 0) {
                        layer.msg("修改成功");
                    }
                    if (msg === 1) {
                        layer.msg("修改失败");
                    }
                }
            });
            return false;
        });

    });
</script>
</body>
</html>