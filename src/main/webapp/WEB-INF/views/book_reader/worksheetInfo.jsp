<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/29 0029
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
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
    <script type="text/javascript" src="${ctx}/static/js/jquery-3.2.1.js"></script>
    <script src="https://www.layuicdn.com/layui-v2.5.5/layui.js"></script>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-form layui-card-header layuiadmin-card-header-auto">
            <div class="layui-form-item">
                <div class="demoTable">
                    <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
                        <input type="text" class="layui-input" id="startDate" placeholder="选择还书日期前">
                    </div>
                    <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
                        <input type="text" class="layui-input" id="endDate" placeholder="选择还书日期后">
                    </div>
                    <div class="layui-inline">
                        <input class="layui-input" name="demoReload" id="demoReload" autocomplete="off"
                               placeholder="搜索">
                    </div>
                    <button class="layui-btn" data-type="reload">搜索</button>
                </div>
            </div>
        </div>
        <div class="layui-card-body">
            <table class="layui-hide" id="demo" lay-filter="test"></table>

        </div>
    </div>
</div>


<script id="itemDemo" type="text/javascript">

</script>


<script type="text/html" id="barDemo">
    <button class="layui-btn layui-btn-xs"  lay-event="borrowAndReturn" id="returnOrRenew">借还信息</button>
    <button class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</button>
</script>


<script>


    layui.use(['laydate', 'layer', 'table'], function () {
        var laydate = layui.laydate //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格


        //执行一个 table 实例
        table.render({
            elem: '#demo'
            // ,height: 420
            , url: '${ctx}/tBookReader/books' //数据接口
            , title: '图书预览'
            , page: true //开启分页
            , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            , totalRow: true //开启合计行
            , limit: 8
            , limits: [8, 16, 32, 48, 64]
            , cols: [[ //标题栏
                {type: 'checkbox'}
                , {field: 'b_book_reader_id', title: '工单编号', sort: true, align: 'center'}
                , {field: 'b_book_name', title: '书名', sort: true, align: 'center'}
                , {field: 'b_reader_name', title: '读者', sort: true, align: 'center'}
                , {field: 'b_admin_name', title: '管理员', sort: true, align: 'center'}
                , {field: 'b_borrow_date', title: '借书日期', sort: true, align: 'center'}
                , {field: 'b_return_date', title: '还书日期', sort: true, align: 'center'}
                , {title: '操作', toolbar: '#barDemo', align: 'center', width: 190}

            ]],
            id: 'testReload'

        });


        //监听行工具事件
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            console.log("asdij")
            var data = obj.data //获得当前行数据
                , layEvent = obj.event //获得 lay-event 对应的值
                , field = obj.field;
            if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    layer.msg(data.id);
                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);
                    //向服务端发送删除指令

                });
            } else if (layEvent === 'borrowAndReturn') {

                // data.id 当前行数据id
                <%--var index=layer.open({--%>
                <%--    type: 2--%>
                <%--    ,title: '借还信息'--%>
                <%--    ,content: '${ctx}/tBookReader/borrowingInfo'--%>
                <%--    // ,maxmin: true--%>
                <%--    ,area: ['600px', '300px']--%>
                <%--});--%>
                <%--window.location.href='${ctx}/tBookReader/borrowingInfo';--%>
                parent.layui.index.openTabsPage("${ctx}/tBookReader/borrowingInfo?adminNo=${adminNo}", "消息中心");
                <%--document.getElementById("returnOrRenew").setAttribute("lay-href","${ctx}/tBookReader/borrowingInfo")--%>
            }
        });

        laydate.render({
            elem: '#startDate'
        });

        laydate.render({
            elem: '#endDate'
        });

        var active = {
            reload: function () {
                table.reload('testReload', {
                    page: {
                        curr: 1
                    }, where: {
                        keyWord: $("#demoReload").val(),
                        startDate: $("#startDate").val(),
                        endDate: $("#endDate").val()
                    }
                });
            }
        }
        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>
</body>
</html>