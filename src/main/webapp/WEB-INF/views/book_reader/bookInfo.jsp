<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/29 0029
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("ctx",request.getContextPath());
    request.setAttribute("readerNo",request.getParameter("readerNo"));
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>layui在线调试</title>
    <link rel="stylesheet" href="${ctx}/static/layuiAdmin/layui/css/layui.css" media="all">
    <script src="${ctx}/static/layuiAdmin/layui/layui.js"></script>
</head>
<body>
<table class="layui-hide" id="demo" lay-filter="test"></table>

<template type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-normal" lay-event="add">新增</button>
        <button class="layui-btn layui-btn-danger" lay-event="delete">删除</button>
    </div>
</template>

<script type="text/html" id="barDemo">
    <button class="layui-btn layui-btn-xs" lay-event="borrowBook">借书</button>
    <button class="layui-btn layui-btn-danger layui-btn-xs" lay-event="returnBook">还书</button>
</script>


<script type="text/javascript" src="${ctx}/static/js/cookieDao.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery-3.2.1.js"></script>

<script>

    layui.use(['layer', 'table'], function(){
        var $ = layui.$ //jquery
            ,layer = layui.layer //弹层
            ,table = layui.table //表格


        //执行一个 table 实例
        var myTable = table.render({
            elem: '#demo'
            // ,height: 420
            ,url: '${ctx}/tBooks/findBooksAll' //数据接口
            ,title: '图书预览'
            ,page: true //开启分页
            ,toolbar: '#toolbarDemo' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,totalRow: true //开启合计行
            ,cols: [[ //标题栏
                {type:'checkbox'}
                ,{field: 'b_book_no', title: '图书编号',sort: true}
                ,{field: 'b_book_name', title: '书名'}
                ,{field: 'b_book_author', title: '作者'}
                ,{field: 'b_book_number', title: '数量',sort: true}
                ,{field: 'b_book_createDate', title: '入库时间'}
                ,{field: 'b_book_type', title: '类型'}
                ,{ title: '操作', toolbar: '#barDemo',align:'center',width:130}
            ]]

        });

        //监听头工具栏事件

        table.on('toolbar(test)',function(obj){
            if(obj.event === 'add'){
                console.log("zengs")
                layer.msg("增加")
            }
        });



        //监听行工具事件
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event //获得 lay-event 对应的值
                ,tr = obj.tr;
            if(layEvent === 'borrowBook'){
                layer.confirm('确定要借书？', function(index){
                    var readerNo = "${readerNo}"
                    $.ajax({
                        url:"${ctx}/tBookReader/borrowBook",
                        data:{
                            "bookNo":data.b_book_no,
                            "readerNo":readerNo
                        },
                        success:function (data) {
                            console.log(data.status)
                            if(data.status===200){

                                myTable.reload({
                                    page:{curr:1},
                                    where:{b_book_id:1}

                                });
                            }
                            if(data.status===404){
                                layer.msg(data.message);
                                /**
                                 * 按钮禁用
                                 */
                                // var tds =  tr.children();
                                // var btns = tds.children();
                                // console.log(btns)
                                // var btn = btns[0];
                                // btn.css("background","black")
                            }
                            if(data.status===555){
                                layer.msg(data.message);
                            }
                        },
                        error:{

                        }

                    })

                    layer.close(index);
                    //向服务端发送删除指令

                });
            } else if(layEvent === 'returnBook'){

                layer.confirm('确定要还书？', function(index){
                    var readerNo = "${readerNo}"
                    $.ajax({
                        url:"${ctx}/tBookReader/returnBook",
                        data:{
                            "bookNo":data.b_book_no,
                            "readerNo":readerNo
                        },
                        success:function (data) {
                            console.log(data.status)
                            if(data.status===200){
                                myTable.reload({
                                    page:{curr:1},
                                    where:{b_book_id:1}

                                });
                            }
                            if(data.status===404){
                                layer.msg(data.message);
                                /**
                                 * 按钮禁用
                                 */
                                // var tds =  tr.children();
                                // var btns = tds.children();
                                // console.log(btns)
                                // var btn = btns[0];
                                // btn.css("background","black")
                            }
                            if(data.status===555){
                                layer.msg(data.message);
                            }
                        },
                        error:{

                        }

                    })

                    layer.close(index);
                    //向服务端发送删除指令

                });
            }
        });

    });
</script>

</body>
</html>
