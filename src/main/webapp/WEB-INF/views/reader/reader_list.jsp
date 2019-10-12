<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>layui在线调试</title>
    <link rel="stylesheet" href="https://www.layuicdn.com/layui-v2.5.5/css/layui.css" media="all">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>

<table class="layui-hide" id="demo" lay-filter="test"></table>

<script type="text/html" id="toolbarDemo">
<%--    <div class="layui-btn-container">--%>
<%--        <button class="layui-btn layui-btn-sm" onclick="add()">新增</button>--%>


<%--    </div>--%>
<%--        <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">--%>
<%--        <div class="layui-input-inline">--%>
<%--            <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">--%>
<%--        </div>--%>
    <%--        <button class="layui-btn layui-btn-sm" onclick="deleteList()">删除</button>--%>

<%--    <label class="layui-form-label"></label>--%>
<label class="layui-form-label" style="text-align: center">|</label>
    <div class="layui-input-inline">
        <input type="text" name="title" required  lay-verify="required" placeholder="请输入读者姓名" autocomplete="off" class="layui-input">
    </div>
    <button class="layui-btn layui-btn-sm" onclick="QueryMy()">查询</button>
<div class="layui-inline">
<label class="layui-form-label" style="text-align: center">|</label>
</div>
<button class="layui-btn layui-btn-sm" onclick="add()">新增</button>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="https://www.layuicdn.com/layui-v2.5.5/layui.js"></script>
<script>

    var deleteListData = [];

    layui.use(['laypage', 'layer', 'table'], function () {
        var laydate = layui.laypage = layui.laypage //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格

        //执行一个 table 实例
        table.render({
            elem: '#demo'
            // ,height: 420
            , url: '${ctx}//admin/readerAdmin/findReadersAll' //数据接口
            , title: '读者信息列表'
            , page: true //开启分页
            , toolbar: '#toolbarDemo'
            , id: 'idTest'
            , cols: [[ //标题栏
                // {type: 'checkbox'},
                {field: 'b_reader_no', title: '读者编号', sort: true}
                , {field: 'b_reader_name', title: '姓名', sort: true}
                , {field: 'b_reader_email', title: '邮箱', sort: true}
                // , {field: 'b_reader_borrow_already_number', title: '借阅数量', sort: true}
                , {field: 'b_reader_mobile', title: '手机号', sort: true}
                    , {field: 'b_reader_password', title:'读者密码',sort:true}
                               , {field: 'b_reader_borrow_already_number', title: '已借阅数量', sort: true}
                               , {field: 'b_reader_borrow_number', title:'读者可借阅数',sort:true}
                , {field: 'b_reader_Remarks', title: '备注', sort: true}
                , {title: '操作', toolbar: '#barDemo', align: 'center', width: 110}

            ]]
        });

        table.on('checkbox(test)', function (obj) {
            var checkStatus = table.checkStatus('idTest');
            deleteListData = checkStatus.data;
            console.log(deleteListData);

        });
        //监听行工具事件
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event //获得 lay-event 对应的值
                , field = obj.field;
            if (layEvent === 'del') {
                layer.confirm('确定删除' + data.b_reader_no + "号记录?", function (index) {
                    //向服务端发送删除指令
                    var id = data.b_reader_no;
                     layer.msg(id);
                    $.ajax({
                        type: 'POST',
                        url: "${ctx}/admin/readerAdmin/deleteByTReader",
                        data: {no: data.b_reader_no},
                        success: function (msg) {
                            if (msg === 0) {
                                layer.msg("已借出书籍无法删除！", {icon: 5});
                                layer.close(index);
                            } else {
                                obj.del(); //删除对应行（tr）的DOM结构
                                layer.close(index);
                                layer.msg("删除成功！", {icon: 6});
                                window.location.reload();
                            }
                        }
                    });
                });
            } else if (layEvent === 'edit') {

                var index = layer.open({
                    type: 2
                    , title: '读者编号：'+data.b_reader_no
                    , content: 'reader_listform_update?no='+data.b_reader_no
                    // ,maxmin: true
                    , area: ['350px', '440px']
                });

            }
        })
    });

    function add() {
        layer.open({
            type: 2
            , title: '添加读者信息'
            , content: '${ctx}/admin/readerAdmin/readerAddView'
            // ,maxmin: true
            , area: ['350px', '500px']
        });
    }
    
    function QueryMy() {
        console.log("查询测试ing");
        layer.open({
            type: 2
            , title: '查询信息'
            , content: '${ctx}/admin/readerAdmin/readerAddView'
            // ,maxmin: true
            , area: ['350px', '500px']
        });

    }


</script>
</body>
</html>
