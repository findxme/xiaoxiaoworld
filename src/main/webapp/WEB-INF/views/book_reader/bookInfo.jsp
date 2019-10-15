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
    request.setAttribute("adminNo", request.getParameter("adminNo"));
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>layui在线调试</title>
    <%--<link rel="stylesheet" href="${ctx}/static/layuiAdmin/layui/css/layui.css" media="all">--%>
    <%--<script src="${ctx}/static/layuiAdmin/layui/layui.js"></script>--%>
    <link rel="stylesheet" href="https://www.layuicdn.com/layui-v2.5.5/css/layui.css" media="all">
    <script src="https://www.layuicdn.com/layui-v2.5.5/layui.js"></script>
</head>
<body>


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
                    <div class="layui-input-inline">
                        <input type="text" name="keyWord" id="keyWord" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <div class="layui-btn-group">
                        <button type="button" id="search" class="layui-btn">搜索</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-card-body">
            <table class="layui-hide" id="demo" lay-filter="test"></table>

        </div>
    </div>
</div>


<script type="text/html" id="barDemo">
    <button class="layui-btn layui-btn-xs" lay-event="borrowBook">借书</button>
</script>


<script type="text/javascript" src="${ctx}/static/js/cookieDao.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery-3.2.1.js"></script>

<script>

    function dropBox() {
        layui.use(['form'], function () {

            var form = layui.form;
            $.ajax({
                url: '${ctx}/tBookReader/dropBox',
                type: 'post',
                success: function (data) {
                    $.each(data, function (index, item) {
                        $("select[name='bookType']").append(new Option(item.b_book_type, item.b_book_type_no));
                    })
                    form.render();
                },
                error: function () {
                    layer.msg("错误")
                }

            })
        })
    }

    layui.use(['layer', 'table', 'form'], function () {
        var layer = layui.layer //弹层
            , table = layui.table //表格
            , form = layui.form;
        dropBox()


        //执行一个 table 实例
        var myTable = table.render({
            elem: '#demo'
            // ,height: 420
            , url: '${ctx}/tBooks/findBooksAll' //数据接口
            , title: '图书预览'
            , page: true //开启分页
            , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            , limit: 8
            , limits: [8, 16, 24, 32, 40]
            , totalRow: true //开启合计行
            , cols: [[ //标题栏
                {type: 'checkbox'}
                , {field: 'b_book_no', title: '图书编号', sort: true}
                , {field: 'b_book_name', title: '书名'}
                , {field: 'b_book_author', title: '作者'}
                , {field: 'b_book_number', title: '数量', sort: true}
                , {field: 'b_book_createDate', title: '入库时间'}
                , {field: 'b_book_type', title: '类型'}
                , {title: '操作', toolbar: '#barDemo', align: 'center', width: 110}
            ]]
            , id: 'testReload'
        });

        //监听头工具栏事件

        table.on('toolbar(test)', function (obj) {
            if (obj.event === 'add') {
                console.log("zengs")
                layer.msg("增加")
            }
        });


        //监听行工具事件
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event //获得 lay-event 对应的值
                , tr = obj.tr;
            if (layEvent === 'borrowBook') {

                var index = layer.open({
                    type: 1
                    , title: '读者编号'


                    , content: ' <div class="layui-form-item">' +
                        '<label class="layui-form-label">读者编号</label>' +
                        ' <div class="layui-input-inline">' +
                        '<input type="text" name="name" required value="" style="width: 200px" id="readerNo" lay-verify="required" placeholder="读者编号" autocomplete="off" class="layui-input"> ' +
                        '</div>' +
                        ' </div>' +
                        '         <div class="layui-form-item">\n' +
                        '          <div class="layui-input-block">\n' +
                        '           <button type="button" class="layui-btn" id="borrow" >出借</button>\n' +
                        '          </div>\n' +
                        '         </div> '
                    // ,maxmin: true
                    //  ,area: ['400px', '200px']
                });
                $("#borrow").on("click", function () {
                    var readerNo = $("#readerNo").val();
                    var adminNo = "${adminNo}";
                    $.ajax({
                        url: "${ctx}/tBookReader/borrowBook",
                        data: {
                            "bookNo": data.b_book_no,
                            "readerNo": readerNo,
                            "adminNo": adminNo
                        },
                        success: function (data) {
                            if (data.status === 200) {

                                myTable.reload({
                                    elem: '#demo'
                                });
                            }
                            layer.msg(data.message)
                        },
                        error: {}

                    })
                    layer.close(index)
                })
            }


        });


        form.on('select(book-type)', function (data) {

            table.reload('testReload', {
                page: {
                    curr: 1
                }, where: {
                    bookType: data.value
                }
            });

        })

        $("#search").on('click', function () {
            table.reload('testReload', {
                page: {
                    curr: 1
                }, where: {
                    keyWord: $("#keyWord").val()
                }
            });
        })
    });


</script>

</body>
</html>