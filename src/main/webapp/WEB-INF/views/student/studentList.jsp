<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/24 0024
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%
        request.setAttribute("ctx",request.getContextPath());
    %>
    <title>学生列表</title>
    <link rel="stylesheet" href="${ctx}/static/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
    <div class="container">
        <table class="table table-bordered">
            <thead>
                <th>
                    <input type="checkbox" name="studentAllCheck">
                </th>
                <th>姓名</th>
                <th>密码</th>
                <th>性别</th>
                <th>专业</th>
                <th>地址</th>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.users}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.password}</td>
                        <td>${item.sex}</td>
                        <td>${item.department}</td>
                        <td>${item.address}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
