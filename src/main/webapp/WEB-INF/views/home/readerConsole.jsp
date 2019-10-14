<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>--%>

<%
    request.setAttribute("ctx", request.getContextPath());
    String readerName=String.valueOf(session.getAttribute("userName"));
    request.setAttribute("readerName",readerName);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layuiAdmin 控制台主页一</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${ctx}/static/layuiAdmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${ctx}/static/layuiAdmin/style/admin.css" media="all">
    <meta http-equiv="refresh" content="60">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-row layui-col-space15">


                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">数据概1览</div>
                        <div class="layui-card-body">
                            <%--                <div id="main" style="width: 600px;height:400px;"></div>--%>
                            <div class="layui-carousel layadmin-carousel layadmin-dataview" data-anim="fade"
                                 lay-filter="LAY-index-dataview">
                                <div carousel-item>
                                    <%--                    <div><i class="layui-icon layui-icon-loading1 layadmin-loading"></i></div>--%>
                                    <%--                    <div></div>--%>
                                    <%--                    <div></div>--%>

                                    <div id="main" style="width: 1700%;height:300%;">111</div>
                                    <div id="main2" style="width: 1700%;height:300%;"></div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="layui-card">
                        <div class="layui-tab layui-tab-brief layadmin-latestData">
                            <ul class="layui-tab-title">
                                <li class="layui-this">${readerName}的借书记录</li>
                                <%--                <li>今日热帖</li>--%>
                            </ul>
                            <div class="layui-tab-content">
                                <div class="layui-tab-item layui-show">
                                    <%--                    <table id="LAY-index-topSearch"></table>--%>
                                    <table class="layui-hide" id="demo" lay-filter="test"></table>
                                </div>
                                <div class="layui-tab-item">
                                    <table id="LAY-index-topCard"></table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<script type="text/html" id="toolbarDemo">--%>
<%--    <div class="layui-btn-container">--%>
<%--        <button class="layui-btn layui-btn-sm" onclick="add()">新增</button>--%>
<%--        &lt;%&ndash;        <button class="layui-btn layui-btn-sm" onclick="deleteList()">删除</button>&ndash;%&gt;--%>
<%--    </div>--%>
<%--</script>--%>

<%--  <script src="${ctx}/static/layuiAdmin/layui/layui.js?t=1"></script>--%>
<script src="${ctx}/static/js/echarts.min.js"></script>
<%--  <script src="${ctx}/static/js/jquery-3.2.1.js"></script>--%>
<script src="https://www.layuicdn.com/layui-v2.5.5/layui.js"></script>
<%--  <script src="${ctx}/static/layuiAdmin/lib/index.js"></script>--%>
<script>
    // <!-- 基于准备好的dom，初始化echarts实例 -->
    var myChart = echarts.init(document.getElementById('main'));
    var option = {


        title: {
            text: '图书信息统计',
            //subtext: '纯属虚构',
            x: 'center'
        },

        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['未借图书', '已借图书']
        },
        series: [
            {
                name: '访问来源',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    {value:${map.notBorrowingBooks}, name: '未借图书'},
                    {value:${map.borrowingQuantity}, name: '已借图书'}
                    // {value:22, name: '未借图书'},
                    // {value:7, name: '已借图书'}

                ],
                label: {
                    normal: {
                        show: true,
                        //position:'inner', //标签的位置
                        /* {b}对于data.name。{c}对应data.value，{d}对应百分比 */
                        formatter: "{b} : {c} ({d}%)"
                    }
                },

                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };


    window.onresize = myChart.resize;
    myChart.setOption(option);

    var deleteListData = [];
    layui.use(['laypage', 'layer', 'table'], function () {
        var laydate = layui.laypage = layui.laypage //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格

        //执行一个 table 实例
        table.render({
            elem: '#demo'
            // ,height: 420
            , url: '${ctx}/readerView/findOneReaderByBook' //数据接口
            //  , title: '图书列表'
            , page: true //开启分页
            // , toolbar: '#toolbarDemo'
            , id: 'idTest'
            , cols: [[ //标题栏
                // {type: 'checkbox'},
                {field: 'b_book_reader_id', title: 'id', sort: true}
                , {field: 'b_book_no', title: '图书编号', sort: true}
                , {field: 'b_book_name', title: '图书名字', sort: true}
                , {field: 'b_reader_no', title: '读者编号', sort: true}
                , {field: 'b_reader_name', title: '读者名字', sort: true}
                , {field: 'b_user_no', title: '管理员编号', sort: true}
                , {field: 'b_admin_name', title: '管理员名字', sort: true}
                , {field: 'b_borrow_date', title: '借书日期', sort: true}
                , {field: 'is_return_book', title: '是否归还', sort: true}
                // , {field: 'b_book_type', title: '类型', sort: true}
                //  , {title: '操作', toolbar: '#barDemo', align: 'center', width: 110}

            ]]
        });
        table.on('checkbox(test)', function (obj) {
            var checkStatus = table.checkStatus('idTest');
            deleteListData = checkStatus.data;
            console.log(deleteListData);

        });
    });

    layui.config({
        base: '../static/layuiAdmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'console']);
</script>
</body>
</html>

