<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>设置我的资料</title>
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
                <div class="layui-card-header">设置我的资料</div>
                <div class="layui-card-body" pad15>

                    <div class="layui-form" lay-filter="">
                        <form>
                            <div class="layui-form-item">
                                <label class="layui-form-label">我的角色</label>
                                <div class="layui-form-mid layui-word-aux">管理员</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">用户名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="username" value="${userName}" readonly class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">不可修改。一般用于后台登入名</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">邮箱</label>
                                <div class="layui-input-inline">
                                    <input type="email" name="email" value="" lay-verify="email" autocomplete="off"
                                           class="layui-input" id="email">
                                </div>
                            </div>
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">备注</label>
                                <div class="layui-input-block">
                                <textarea name="remarks" placeholder="请输入内容" class="layui-textarea"
                                          id="remarks"></textarea>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button type="button" class="layui-btn" lay-submit lay-filter="formDemo" >确认修改</button>
                                    <button type="reset" class="layui-btn layui-btn-primary">重新填写</button>
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

        form.on('submit(formDemo)', function(data){
            $.ajax({
                type: 'POST',
                url: "${ctx}/user/setUser",
                data: {
                    email: $("#email").val(),
                    remarks: $("#remarks").val()
                },
                success: function (msg) {
                    if (msg === 1) {
                        layer.msg("修改成功");
                        $('form')[0].reset();
                    }
                }
            });
            return false;
        });

    });
</script>
</body>
</html>