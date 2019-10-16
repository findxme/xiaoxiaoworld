<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>邮件服务</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="https://www.layuicdn.com/layui-v2.5.5/css/layui.css" media="all">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <style>
        .layui-form-label {
            width: 100px;
        }

        .file {
            position: relative;
            display: inline-block;
            background: #1E9FFF;
            border: 1px solid #99D3F5;
            border-radius: 4px;
            padding: 4px 12px;
            /*overflow: hidden;*/
            color: white;
            text-decoration: none;
            text-indent: 0;
            line-height: 20px;
            /*margin: 0;*/
            /*width: 100px;*/
        }

        .file input {
            position: absolute;
            font-size: 100px;
            right: 0;
            opacity: 0;
        }

        .file:hover {
            background: #1E9FFF;
            border-color: #78C3F3;
            color: #004974;
            text-decoration: none;
        }
    </style>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">文件服务</div>
                <div class="layui-card-body">
                    <div class="layui-form" wid100 lay-filter="">
                        <form enctype="multipart/form-data" method="post" action="${ctx}/file/upload">
                            <div class="layui-form-item">
                                <div class="layui-inline">
                                    <a href="javascript:;" class=" file">
                                        <i class="layui-icon">&#xe67c;</i>
                                        <input type="file" name="file" class="file-name"
                                               onchange="upload()">选择文件</input>
                                    </a>
                                    <button type="submit" class="layui-btn  layui-btn-sm">上传</button>
                                    <div class="layui-inline" id="file-name"></div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <table class="layui-hide" id="demo" lay-filter="test"></table>


            </div>
        </div>
    </div>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit" >下载</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="https://www.layuicdn.com/layui-v2.5.5/layui.js"></script>
<script>
    layui.use(['form', 'table'],function () {
        var form = layui.form
            , table = layui.table; //只有执行了这一步，部分表单元素才会自动修饰成功
        // form.render();

        table.render({
            elem: '#demo'
            // ,height: 420
            , url: '${ctx}/file/list' //数据接口
            , title: '图书列表'
            // , page: true //开启分页
            , toolbar: '#toolbarDemo'
            , cols: [[ //标题栏
                // {type: 'checkbox'},
                {field: 'name', title: '文件名', sort: true}
                , {field: 'size', title: '文件大小', sort: true}
                , {title: '操作', toolbar: '#barDemo', align: 'center', width: 110}

            ]]
            , id: 'idTest'
        });


        //监听行工具事件
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event //获得 lay-event 对应的值
                , field = obj.field;
            if (layEvent === 'del') {
                layer.confirm('确定删除 ' + data.name + "?", function (index) {
                    //向服务端发送删除指令
                    $.ajax({
                        type: 'POST',
                        url: "${ctx}/file/deleteFile",
                        data: {name: data.name},
                        success: function (msg) {
                            if (msg === 0) {
                                layer.msg("删除失败！", {icon: 5});
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
                $(this).attr('href',"${ctx}/file/downloadFile?name="+data.name);
            }

        });

    });

    function upload() {
        $('#file-name').text($(".file-name").val());
    }

</script>
</body>
</html>