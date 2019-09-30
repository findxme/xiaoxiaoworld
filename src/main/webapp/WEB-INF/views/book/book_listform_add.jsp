<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	request.setAttribute("ctx",request.getContextPath());
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>layuiAdmin 文章管理 iframe 框</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
		<link rel="stylesheet" href="${ctx}/static/layuiAdmin/layui/css/layui.css" media="all">
	</head>
	<body>
		<div class="layui-form" lay-filter="layuiadmin-app-form-list" id="layuiadmin-app-form-list form" style="padding: 20px 30px 0 0;">
			<form action="" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">图书编号</label>
					<div class="layui-input-inline">
						<input type="text" name="title" lay-verify="required" placeholder="请输入图书编号" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">书名</label>
					<div class="layui-input-inline">
						<input type="text" name="author" lay-verify="required" placeholder="请输入书名" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">作者</label>
					<div class="layui-input-inline">
						<input type="text" name="author" lay-verify="required" placeholder="请输入作者" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">数量</label>
					<div class="layui-input-inline">
						<input type="text" name="author" lay-verify="required" placeholder="请输入数量" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">类型</label>
					<div class="layui-input-inline">
						<select name="label" lay-verify="required">
							<option value="">请选择类型</option>
							<option value="美食">美食</option>
							<option value="新闻">新闻</option>
							<option value="八卦">八卦</option>
							<option value="体育">体育</option>
							<option value="音乐">音乐</option>
						</select>
					</div>
				</div>
				<div class="layui-form-item ">
					<div class="layui-input-inline">
					<button type="submit" class="layui-btn layui-btn " lay-submit lay-filter="layuiadmin-app-form-submit" id="layuiadmin-app-form-submit">提交</button>
					  <button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
				</div>
			</form>
		</div>
		<script src="${ctx}/static/layuiAdmin/layui/layui.js"></script>
		<script>
			layui.use('form', function() {
				var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
				form.render();
			});

			$("form").submit(function(e) {
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			});
		</script>
	</body>
</html>
