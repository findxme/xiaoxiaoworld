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

</head>
<body>

<div class="layui-row layui-col-space10" style="margin-top: 1.25rem;margin-left: 1.25rem;">
    <div class="layui-col-md3">
        待加密数据
        <textarea name="" required lay-verify="required" placeholder="请输入带加密数据" id="text1" class="layui-textarea" style="width: 200px; height: 400px;"></textarea>
    </div>
    <div class="layui-col-md1"style="margin-top:150px ;">
        <button class="layui-btn" id="encryption">加密</button>
    </div>
    <div class="layui-col-md3">
        加密数据
        <textarea name="" required lay-verify="required" placeholder="加密完成数据"  id="text2" class="layui-textarea" style="width: 200px; height: 400px;"></textarea>
    </div>
    <div class="layui-col-md1" style="margin-top:150px;">
        <button class="layui-btn" id="decrypt">解密</button>
    </div>
    <div class="layui-col-md3">
        解密完成数据
        <textarea name="" required lay-verify="required" placeholder="解密完成数据"  id="text3" class="layui-textarea" style="width: 200px; height: 400px;"></textarea>
    </div>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit" >下载</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="https://www.layuicdn.com/layui-v2.5.5/layui.js"></script>
</body>
</html>

<script>
    $(function(){
        $("#encryption").click(function () {
            alert($("#text1").val())
            $.ajax({
                type:"post",
                url:"${ctx}/user/encryption",
                data:{"text1":$("#text1").val()},
                success:function (data) {

                    // $("#text2").load(data);
                    document.getElementById('text2').value = data;
                }
            })
        })
      $("#decrypt").click(function () {
            $.ajax({
                type:"post",
                url:"${ctx}/user/decrypt",
                data:{"text2":$("#text2").val()},
                success:function (data) {
                    document.getElementById('text3').value = data;
                }
            })
        })

    });
</script>
