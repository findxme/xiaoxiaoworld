<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setAttribute("ctx", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>404 页面不存在</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="${ctx}/static/layuiAdmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="${ctx}/static/layuiAdmin/style/admin.css" media="all">
</head>
<body>


<div class="layui-fluid">
  <div class="layadmin-tips">
    <i class="layui-icon" face>&#xe664;</i>
    <div class="layui-text">
      <h1>
        <span class="layui-anim layui-anim-loop layui-anim-">4</span> 
        <span class="layui-anim layui-anim-loop layui-anim-rotate">0</span> 
        <span class="layui-anim layui-anim-loop layui-anim-">4</span>
      </h1>
      <h3>
        <span class="layui-anim layui-anim-loop layui-anim-">此页面404的原因是数据库没数据，在做这套页面的时候没有考虑到很具体的异常处理</span>
      </h3>
    </div>
  </div>
</div>

<script src="https://www.layuicdn.com/layui-v2.5.5/layui.js"></script>
  <script>

  layui.config({
    base: '../static/layuiAdmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index']);
  </script>
</body>
</html>