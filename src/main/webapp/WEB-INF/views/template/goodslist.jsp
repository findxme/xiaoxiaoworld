<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("ctx",request.getContextPath());
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>商品列表</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${ctx}/static/layuiAdmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${ctx}/static/layuiAdmin/style/admin.css" media="all">
  <link rel="stylesheet" href="${ctx}/static/layuiAdmin/style/template.css" media="all">
</head>
<body>


<div class="layui-fluid layadmin-cmdlist-fluid">
  <div class="layui-row layui-col-space30">
      <c:forEach var="listBook" items="${listBooks}">
    <div class="layui-col-md2 layui-col-sm4">

        <div class="cmdlist-container">
            <a href="javascript:;">
                <img src="${ctx}/static/img/xiaokeai.png">
                <img src="${ctx}/static/img/b4.jpg">
            </a>
            <a href="javascript:;">
              <div class="cmdlist-text">
                <p class="info">小小世界图书馆示例图书</p>
                  <div class="price">
                      <b class="info">${listBook.b_book_name}</b>
                  </div>
              </div>
            </a>
        </div>

    </div>
          </c:forEach>
    <div class="layui-col-md12 layui-col-sm12">
        <div id="demo0"></div>
    </div>
  </div>
</div>


  <script src="${ctx}/static/layuiAdmin/layui/layui.js"></script>
  <script>
  layui.config({
    base: '${ctx}/static/layuiAdmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index']);
  layui.use(['laypage', 'layer'], function(){
  var laypage = layui.laypage
  ,layer = layui.layer;
  
  //总页数低于页码总数
  laypage.render({
    elem: 'demo0'
    ,count: ${booksByExample}
      ,limit: 3    //数据总数
  });
});
  </script>
</body>
</html>