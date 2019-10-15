

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("ctx",request.getContextPath());
%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">
    <title>小小世界图书馆</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link href="${ctx}/static/img/logo.png" rel="icon" type="image/x-ico">
    <link rel="stylesheet" href="${ctx}/static/layuiAdmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${ctx}/static/layuiAdmin/style/admin.css" media="all">
    <script type="text/javascript" src="${ctx}/static/js/cookieDao.js"></script>


</head>
<body class="layui-layout-body">

<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <!-- 头部区域 -->
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item layadmin-flexible" lay-unselect>
                    <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
                        <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
                    </a>

                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" layadmin-event="refresh" title="刷新">
                        <i class="layui-icon layui-icon-refresh-3"></i>
                    </a>
                </li>

            </ul>
            <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">


                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;">
                        <cite id="loginName">${userNmae}</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a lay-href="${ctx}/user/info">基本资料</a></dd>
                        <dd><a lay-href="${ctx}/user/password">修改密码</a></dd>
                        <hr>
                        <dd  style="text-align: center;"><a href="${ctx}/user/exit">退出</a></dd>
                    </dl>
                </li>


            </ul>
        </div>

        <!-- 侧边菜单 -->
        <div class="layui-side layui-side-menu">
            <div class="layui-side-scroll">
                <div class="layui-logo" lay-href="index">
                    <span>小小世界图书馆</span>
                </div>

                <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
                    <li data-name="home" class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;" lay-tips="主页" lay-direction="2">
                            <i class="layui-icon layui-icon-home"></i>
                            <cite>主页</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="console" class="layui-this">

                                <a lay-href="${ctx}/user/dataStatistics">控制台</a>
                            </dd>

                        </dl>
                    </li>

                    <li data-name="app" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="应用" lay-direction="2">
                            <i class="layui-icon layui-icon-app"></i>
                            <cite>图书信息管理</cite>
                        </a>
                        <dl class="layui-nav-child">


                            <dd data-name="list"><a lay-href="${ctx}/tBooks/list">图书列表</a></dd>
                            <dd data-name="tags"><a lay-href="${ctx}/tBooksType/booksType">分类管理</a></dd>

                        </dl>
                    </li>




                    <li data-name="app" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="应用" lay-direction="2">
                            <i class="layui-icon layui-icon-app"></i>
                            <cite>读者信息管理</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="list"><a lay-href="${ctx}/admin/readerAdmin/readerView">读者列表</a></dd>

                        </dl>
                    </li>

                    <li data-name="app" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="应用" lay-direction="2">
                            <i class="layui-icon layui-icon-app"></i>
                            <cite>借阅信息管理</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="header">
                                <a lay-href="" id="book">图书</a>
                                <script>
                                    // var adminNo = getCookie("adminNo")
                                    var adminNo = '${adminNo}';
                                    var str = "${ctx}/tBookReader/bookInfoPage?adminNo="+adminNo;
                                    document.getElementById("book").setAttribute("lay-href",str);
                                </script>
                            </dd>

                            <dd data-name="content">
                                <a lay-href="" id="returnOrRenew">消息中心</a>
                                <script>
                                    var adminNo1 = getCookie("adminNo")
                                    var str1 = "${ctx}/tBookReader/borrowingInfo?adminNo="+adminNo1;
                                    document.getElementById("returnOrRenew").setAttribute("lay-href",str1);
                                </script>
                            </dd>
                            <dd data-name="workorder">
                                <a lay-href="${ctx}/tBookReader/bookBorrowReturnInfo">工单系统</a>
                            </dd>
                        </dl>
                    </li>



                    <li data-name="set" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="设置" lay-direction="2">
                            <i class="layui-icon layui-icon-set"></i>
                            <cite>设置</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd class="layui-nav-itemed">
                                <a href="javascript:;">系统设置</a>
                                <dl class="layui-nav-child">
                                    <dd><a lay-href="${ctx}/user/email">邮件服务</a></dd>
                                </dl>
                            </dd>
                            <dd class="layui-nav-itemed">
                                <a href="javascript:;">我的设置</a>
                                <dl class="layui-nav-child">
                                    <dd><a lay-href="${ctx}/user/info">基本资料</a></dd>
                                    <dd><a lay-href="${ctx}/user/password">修改密码</a></dd>
                                </dl>
                            </dd>
                        </dl>
                    </li>
                </ul>
            </div>
        </div>

        <!-- 页面标签 -->
        <div class="layadmin-pagetabs" id="LAY_app_tabs">
            <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-down">
                <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
                    <li class="layui-nav-item" lay-unselect>
                        <a href="javascript:;"></a>
                        <dl class="layui-nav-child layui-anim-fadein">
                            <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                            <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                            <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
                <ul class="layui-tab-title" id="LAY_app_tabsheader">
                    <li lay-id="${ctx}/user/dataStatistics" lay-attr="" class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
                </ul>
            </div>
        </div>


        <!-- 主体内容 -->
        <div class="layui-body" id="LAY_app_body">
            <div class="layadmin-tabsbody-item layui-show">

                <iframe src="${ctx}/user/dataStatistics" frameborder="0" class="layadmin-iframe"></iframe>
            </div>
        </div>

        <!-- 辅助元素，一般用于移动设备下遮罩 -->
        <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
</div>

<script src="${ctx}/static/js/jquery-3.2.1.js"></script>
<script src="${ctx}/static/js/cookieDao.js"></script>
<script src="${ctx}/static/layuiAdmin/layui/layui.js"></script>
<script>

    layui.config({
        base: '../static/layuiAdmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use('index');
</script>
</body>
</html>


