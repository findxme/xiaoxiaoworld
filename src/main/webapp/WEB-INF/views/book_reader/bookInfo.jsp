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
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>layui在线调试</title>
    <link rel="stylesheet" href="${ctx}/static/layuiAdmin/layui/css/layui.css" media="all">

</head>
<body>
<table class="layui-hide" id="demo" lay-filter="test"></table>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">新增</button>
        <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
    </div>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看详细</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="${ctx}/static/layuiAdmin/layui/layui.js"></script>
<script>


    layui.use(['laypage', 'layer', 'table'], function(){
        var laydate = layui.laypage = layui.laypage //分页
            ,layer = layui.layer //弹层
            ,table = layui.table //表格


        //执行一个 table 实例
        table.render({
            elem: '#demo'
             // ,height: 420
             ,url: '${ctx}/tBookReader/books' //数据接口
            ,title: '图书预览'
            ,page: true //开启分页
            ,toolbar: '#toolbarDemo' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            // ,totalRow: true //开启合计行
            ,cols: [[ //标题栏
                {type:'checkbox'}
                ,{field: 'b_book_reader_id', title: 'ID',sort: true}
                ,{field: 'b_admin_name', title: '管理员姓名'}
                ,{field: 'b_book_name', title: '书名'}
                ,{field: 'b_reader_name', title: '借阅人姓名',sort: true}
                ,{ title: '操作', toolbar: '#barDemo',align:'center',width:150}
            ]]
        });

        //监听头工具栏事件
        table.on('toolbar(test)', function(obj){
            console.log("adsk");
            var checkStatus = table.checkStatus(obj.config.id)
                ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'add':
                    console.log("ads")
                    layer.msg("das")
                    layer.open({
                        type: 2
                        ,title: '添加图书信息'
                        ,content: 'book_listform_add.html'
                        ,maxmin: true
                        ,area: ['350px', '440px']
                    });

                    break;
                case 'delete':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else {
                        var data = checkStatus.data;
                        JSON.stringify(data)

                        // 删除多行
                        layer.alert(JSON.stringify(data));


                        // layer.msg('删除');
                    }
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event //获得 lay-event 对应的值
                ,field = obj.field;
            if(layEvent === 'del'){
                layer.confirm('确定删除'+data.b_book_reader_id+"号记录?", function(index){
                    // layer.msg(data.b_book_reader_id);
                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);
                    //向服务端发送删除指令

                });
            } else if(layEvent === 'edit'){

                // layer.msg('编辑操作'+data.id);

                // data.id 当前行数据id
                var index=layer.open({
                    type: 2
                    ,title: '查看详细'
                    ,content: 'book_listform_add.html'
                    // ,maxmin: true
                    ,area: ['350px', '440px']
                });

            }
        });

    });
</script>
</body>
</html>
