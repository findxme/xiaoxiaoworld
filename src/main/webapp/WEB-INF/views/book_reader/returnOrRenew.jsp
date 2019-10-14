<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/29 0029
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("adminNo",request.getParameter("adminNo"));
    request.setAttribute("ctx",request.getContextPath());
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>layui在线调试</title>
    <%--<link rel="stylesheet" href="${ctx}/static/layuiAdmin/layui/css/layui.css" media="all">--%>
    <%--<script src="${ctx}/static/layuiAdmin/layui/layui.js"></script>--%>
    <link rel="stylesheet" href="https://www.layuicdn.com/layui-v2.5.5/css/layui.css" media="all">
    <script src="https://www.layuicdn.com/layui-v2.5.5/layui.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/jquery-3.2.1.js"></script>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-form layui-card-header layuiadmin-card-header-auto">
            <div class="layui-form-item">
                <div class="demoTable">
                    <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
                        <input type="text" class="layui-input" id="startDate" placeholder="选择借书日期前">
                    </div>
                    <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
                        <input type="text" class="layui-input" id="endDate" placeholder="选择借书日期后">
                    </div>
                    <div class="layui-inline">
                        <input class="layui-input" name="demoReload" id="demoReload" autocomplete="off" placeholder="搜索">
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







<script type="text/html" id="barDemo">
    <button class="layui-btn layui-btn-xs" lay-event="renewBook">续借</button>
    <button class="layui-btn layui-btn-danger layui-btn-xs" lay-event="returnBook">还书</button>
</script>

<script>


    layui.use(['laypage', 'layer', 'table','laydate'], function(){
        var layer = layui.layer //弹层
            ,table = layui.table //表格
            ,laydate = layui.laydate;



        //执行一个 table 实例
        var myTable = table.render({
            elem: '#demo'
            // ,height: 420
            ,url: '${ctx}/tBookReader/notReturnBook' //数据接口
            ,title: '图书预览'
            ,page: true //开启分页
            ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,limit:10
            ,cols: [[ //标题栏
                {field: 'b_book_name', title: '书名',sort: true}
                ,{field: 'b_reader_name', title: '读者',sort: true}
                ,{field: 'b_admin_name', title: '管理员',sort: true}
                ,{field: 'b_borrow_date', title: '借阅时间',sort: true}
                ,{field: 'b_renew_frequency', title: '还能续借次数',sort: true}
                ,{field: 'b_renew_time', title: '续借时间长度',sort: true}
                ,{ title: '操作', toolbar: '#barDemo',align:'center',sort: true}
            ]]
            ,id:'testReload'

        });

        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event //获得 lay-event 对应的值
                ,tr = obj.tr;
            if(layEvent === 'renewBook'){
                var layer = layui.layer;
                layer.confirm('是否续借', function(renewBook){
                    $.ajax({
                        url:"${ctx}/tBookReader/renewBook",
                        data:{
                            "bookNo":data.b_book_no,
                            "readerNo":data.b_reader_no,
                        },
                        success:function(data){
                            console.log(data.status)
                            if(data.status===200){
                                myTable.reload({});
                            }
                            layer.msg(data.message)
                        }
                    })
                    layer.close(renewBook)
                })
            } else if(layEvent === 'returnBook'){
                var layer = layui.layer;
                layer.confirm('是否还书', function(index){
                    var adminNo = "${adminNo}";
                    $.ajax({
                        url:"${ctx}/tBookReader/returnBook",
                        data:{
                            "bookNo":data.b_book_no,
                            "readerNo":data.b_reader_no,
                            "adminNo":adminNo
                        },
                        success:function (data) {
                            if(data.status===200){

                                myTable.reload();
                            }
                            layer.msg(data.message)
                        },
                        error:{

                        }

                    })
                    layer.close(index)
                });
            }
        });

        laydate.render({
            elem:'#startDate'
        });

        laydate.render({
            elem:'#endDate'
        });

        var active = {
            reload:function(){
                table.reload('testReload',{
                    page:{
                        curr:1
                    },where:{
                        keyWord:$("#demoReload").val(),
                        startDate:$("#startDate").val(),
                        endDate:$("#endDate").val()
                    }
                });
            }
        }
        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>
</body>
</html>