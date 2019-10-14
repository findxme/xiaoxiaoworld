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


</div>


<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-form layui-card-header layuiadmin-card-header-auto">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <select name="bookType" data-type="reload" id="bookType" lay-filter="book-type" lay-search>
                        <option value="">请选择图书类型</option>
                    </select>
                </div>
                <div class="layui-inline">
                    <input class="layui-input" name="id" id="TBookNo" autocomplete="off" placeholder="图书ID">
                </div>
                <div class="layui-inline">
                    <input class="layui-input" name="id" id="TBookName" autocomplete="off" placeholder="书名">
                </div>
                <div class="layui-inline">
                    <input class="layui-input" name="id" id="TBookAuthor" autocomplete="off" placeholder="作者">
                </div>
                <div class="layui-inline">
                    <div class="layui-btn-group">
                        <button class="layui-btn" id="Bookfind"data-type="reload">搜索</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-card-body">
            <table class="layui-hide" id="demo" lay-filter="test"></table>

        </div>
    </div>
</div>


<%--<script type="text/html" id="toolbarDemo">--%>
<%--    <div class="layui-btn-container">--%>
<%--        <button class="layui-btn layui-btn-sm" onclick="add()">新增</button>--%>
<%--&lt;%&ndash;        <button class="layui-btn layui-btn-sm" onclick="deleteList()">删除</button>&ndash;%&gt;--%>

<%--    </div>--%>

<%--</script>--%>

<%--<script type="text/html" id="barDemo">--%>
<%--    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>--%>
<%--    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>
<%--</script>--%>

<script src="https://www.layuicdn.com/layui-v2.5.5/layui.js"></script>
<script>

    function dropBox(){
        layui.use(['form'],function(){

            var form = layui.form;
            $.ajax({
                url:'${ctx}/tBookReader/dropBox',
                type:'post',
                success:function(data){
                    $.each(data,function(index,item){
                        $("select[name='bookType']").append(new Option(item.b_book_type,item.b_book_type_no));
                    })
                    form.render();
                },
                error:function(){
                    layer.msg("错误")
                }

            })
        })
    }
    var deleteListData = [];

    layui.use(['form', 'layer', 'table'], function () {
        var form = layui.form
            , layer = layui.layer //弹层
            , table = layui.table //表格

        dropBox()
        //执行一个 table 实例
        table.render({
            elem: '#demo'
            // ,height: 420
            , url: '${ctx}/tBooks/findBooksOne' //数据接口
            , title: '图书列表'
            , page: true //开启分页
            , toolbar: '#toolbarDemo'
            , cols: [[ //标题栏
                // {type: 'checkbox'},
                {field: 'b_book_no', title: '图书编号', sort: true}
                , {field: 'b_book_name', title: '书名', sort: true}
                , {field: 'b_book_author', title: '作者', sort: true}
                , {field: 'b_book_number', title: '数量', sort: true}
                , {field: 'b_book_createDate', title: '入库时间', sort: true}
                , {field: 'b_book_type', title: '类型', sort: true}
                // , {title: '操作', toolbar: '#barDemo', align: 'center', width: 110}

            ]]
            ,id:'idTest'
        });

        <%--table.on('checkbox(test)', function (obj) {--%>
        <%--    var checkStatus = table.checkStatus('idTest');--%>
        <%--    deleteListData = checkStatus.data;--%>
        <%--    console.log(deleteListData);--%>

        <%--});--%>
        <%--//监听行工具事件--%>
        <%--table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"--%>
        <%--    var data = obj.data //获得当前行数据--%>
        <%--        , layEvent = obj.event //获得 lay-event 对应的值--%>
        <%--        , field = obj.field;--%>
        <%--    if (layEvent === 'del') {--%>
        <%--        layer.confirm('确定删除' + data.b_book_no + "号记录?", function (index) {--%>
        <%--            //向服务端发送删除指令--%>
        <%--            var id = data.b_book_no;--%>
        <%--            // layer.msg(id);--%>
        <%--            $.ajax({--%>
        <%--                type: 'POST',--%>
        <%--                url: "${ctx}/tBooks/deleteByTBook",--%>
        <%--                data: {id: data.b_book_no},--%>
        <%--                success: function (msg) {--%>
        <%--                    if (msg === 0) {--%>
        <%--                        layer.msg("已借出书籍无法删除！", {icon: 5});--%>
        <%--                        layer.close(index);--%>
        <%--                    } else {--%>
        <%--                        obj.del(); //删除对应行（tr）的DOM结构--%>
        <%--                        layer.close(index);--%>
        <%--                        layer.msg("删除成功！", {icon: 6});--%>
        <%--                    }--%>
        <%--                }--%>
        <%--            });--%>
        <%--        });--%>
        <%--    } else if (layEvent === 'edit') {--%>

        <%--        var index = layer.open({--%>
        <%--            type: 2--%>
        <%--            , title: '图书编号：'+data.b_book_no--%>
        <%--            , content: 'book_listform_update?id='+data.b_book_no--%>
        <%--            // ,maxmin: true--%>
        <%--            , area: ['350px', '440px']--%>
        <%--        });--%>

        <%--    }--%>
        <%--});--%>
        var $ = layui.$, active = {
            reload: function(){
                //执行重载
                table.reload('idTest', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        bookNo:$("#TBookNo").val(),
                        bookName:$("#TBookName").val(),
                        bookAuthor:$("#TBookAuthor").val(),
                    }
                }, 'data');
            }
        };

        $('#Bookfind').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        form.on('select(book-type)',function(data){
            table.reload('idTest',{
                page:{
                    curr:1
                },where:{
                    bookType:data.value
                }
            });

        })

    });

</script>
</body>
</html>
