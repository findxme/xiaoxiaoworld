<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: No One
  Date: 2019/10/12
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://www.layuicdn.com/layui-v2.5.5/css/layui.css" media="all">
</head>
<%--${ReaderInfo}--%>
<%--No:${ReaderInfo.bReaderNo} <br>--%>
<%--Name:${ReaderInfo.bReaderName}<br>--%>
<%--Email:${ReaderInfo.bReaderEmail}<br>--%>
<%--Password:${ReaderInfo.bReaderPassword}<br>--%>
<%--Phone:${ReaderInfo.bReaderMobile}<br>--%>
<%--Remark:${ReaderInfo.bReaderRemarks}<br>--%>
<%--BorrowTime:${ReaderInfo.bReaderBorrowTime}<br>--%>
<%--BorrowNum:${ReaderInfo.bReaderBorrowNumber}<br>--%>
<%--BorrowAlready:${ReaderInfo.bReaderBorrowAlreadyNumber}--%>

<table class="layui-table" lay-size="lg" lay-skin="row">
<%--    <colgroup>--%>
<%--        <col width="150">--%>
<%--        <col width="300">--%>
<%--        --%>
<%--    </colgroup>--%>
    <thead>
    <tr>
        <th>读者编号</th>
        <th>读者姓名</th>
        <th>读者邮箱</th>
        <th>读者密码</th>
        <th>读者手机号</th>
        <th>读者备注</th>
        <th>读者借书时间</th>
        <th>读者可借数量</th>
        <th>读者已借数量</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${ReaderInfo.bReaderNo}</td>
        <td>${ReaderInfo.bReaderName}</td>
        <td>${ReaderInfo.bReaderEmail}</td>
        <td>${ReaderInfo.bReaderPassword}</td>
        <td>${ReaderInfo.bReaderMobile}</td>
        <td>${ReaderInfo.bReaderRemarks}</td>
        <td>${ReaderInfo.bReaderBorrowTime}</td>
        <td>${ReaderInfo.bReaderBorrowNumber}</td>
        <td>${ReaderInfo.bReaderBorrowAlreadyNumber}</td>

    </tr>
    </tbody>
</table>


</body>
</html>
