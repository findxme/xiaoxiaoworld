<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <link rel="stylesheet" href="https://www.layuicdn.com/layui-v2.5.5/css/layui.css" media="all">

</head>
<body>
<div class="layui-form" lay-filter="layuiadmin-app-form-list" id="layuiadmin-app-form-list form"
     style="padding: 20px 30px 0 0;">
    <form action="${ctx}/admin/readerAdmin/updateByExample" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">读者编号</label>
            <div class="layui-input-inline">
                <input type="text" name="no" lay-verify="" min="0" placeholder="请输入可借阅数量" autocomplete="off"
                       class="layui-input" readonly value="${reader.b_reader_no}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="text" name="email" lay-verify="required|email" placeholder="请输入邮箱" autocomplete="off"
                       class="layui-input" value="${reader.b_reader_email}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-inline">
                <input type="text" name="mobile" lay-verify="required|phone" placeholder="请输入手机号" autocomplete="off"
                       class="layui-input" value="${reader.b_reader_mobile}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="text" name="password" lay-verify="" placeholder="请输入密码" autocomplete="off"
                       class="layui-input" value="${reader.b_reader_password}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">数量</label>
            <div class="layui-input-inline">
                <input type="number" name="number" lay-verify="" min="0" placeholder="请输入可借阅数量" autocomplete="off"
                       class="layui-input" value="${reader.b_reader_borrow_number}">
            </div>
        </div>
<%--        <div class="layui-form-item">--%>
<%--            <label class="layui-form-label">类型</label>--%>
<%--            <div class="layui-input-inline">--%>
<%--                <select name="type" lay-verify="required">--%>
<%--                    <option value="">请选择类型</option>--%>
<%--                    <c:forEach items="${typeList}" var="type">--%>
<%--                        <option value="${type.b_book_type_no}" <c:if test="${type.b_book_type_no==book.b_book_type_no}">selected</c:if>>${type.b_book_type}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <button type="submit" class="layui-btn layui-btn " lay-submit lay-filter="layuiadmin-app-form-submit"
                        id="layuiadmin-app-form-submit">提交
                </button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script src="https://www.layuicdn.com/layui-v2.5.5/layui.js"></script>
<script>
    layui.use('form', function () {
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
        form.render();
    });

    $("form").submit(function (e) {
        var index = parent.layer.getFrameIndex(window.name);
        window.parent.location.reload();
        parent.layer.close(index);
    });


</script>
</body>
</html>
