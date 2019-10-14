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
<div class="demoTable">
    图书ID：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="TBookID" autocomplete="off">
    </div>
    书名：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="TBookName" autocomplete="off">
    </div>
    作者：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="TBookAuthor" autocomplete="off">
    </div>
    类型：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="TBookType" autocomplete="off">
    </div>
    <button class="layui-btn" id="Bookfind"data-type="reload">搜索</button>
</div>
<table class="layui-hide" id="demo" lay-filter="test"></table>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" onclick="add()">新增</button>
<%--        <button class="layui-btn layui-btn-sm" onclick="deleteList()">删除</button>--%>

    </div>

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
            , url: '${ctx}/tBooks/findBooksAll' //数据接口
            , title: '图书列表'
            , page: true //开启分页
            , toolbar: '#toolbarDemo'
            , id: 'idTest'
            , cols: [[ //标题栏
                // {type: 'checkbox'},
                {field: 'b_book_no', title: '图书编号', sort: true}
                , {field: 'b_book_name', title: '书名', sort: true}
                , {field: 'b_book_author', title: '作者', sort: true}
                , {field: 'b_book_number', title: '数量', sort: true}
                , {field: 'b_book_createDate', title: '入库时间', sort: true}
                , {field: 'b_book_type', title: '类型', sort: true}
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
                layer.confirm('确定删除' + data.b_book_no + "号记录?", function (index) {
                    //向服务端发送删除指令
                    var id = data.b_book_no;
                    // layer.msg(id);
                    $.ajax({
                        type: 'POST',
                        url: "${ctx}/tBooks/deleteByTBook",
                        data: {id: data.b_book_no},
                        success: function (msg) {
                            if (msg === 0) {
                                layer.msg("已借出书籍无法删除！", {icon: 5});
                                layer.close(index);
                            } else {
                                obj.del(); //删除对应行（tr）的DOM结构
                                layer.close(index);
                                layer.msg("删除成功！", {icon: 6});
                            }
                        }
                    });
                });
            } else if (layEvent === 'edit') {

                var index = layer.open({
                    type: 2
                    , title: '图书编号：'+data.b_book_no
                    , content: 'book_listform_update?id='+data.b_book_no
                    // ,maxmin: true
                    , area: ['350px', '440px']
                });

            }
        });
        var $ = layui.$, active = {
            reload: function(){
                 var tBooksID = $('#TBookID');
                var tBookName = $('#TBookName');
                var tBookName = $('#TBookAuthor');
                var tBookName = $('#TBookType');
                var tBookName = $('#TBookName');
                // console.log(demoReload.val());
                //执行重载
                table.reload('idTest', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        // key: {
                        tBooksID: tBooksID.val()

                      //  KeyWords:$("#TBookID").val()
                        // }
                    }
                }, 'data');
            }
        };

        $('#Bookfind').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });


    });

    function add() {
        layer.open({
            type: 2
            , title: '添加图书信息'
            , content: 'book_listform_add'
            // ,maxmin: true
            , area: ['350px', '440px']
        });
    }

    function deleteList() {
        if (deleteListData.length === 0) {
            layer.msg('请选择一行');
        } else {
            JSON.stringify(deleteListData)

            // 删除多行
            layer.alert(JSON.stringify(deleteListData));


            // layer.msg('删除');
        }
    }

</script>
</body>
</html>
