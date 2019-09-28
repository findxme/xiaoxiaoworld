

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("ctx",request.getContextPath());
%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">
    <title>layuiAdmin std - 通用后台管理模板系统（iframe标准版）</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${ctx}/static/layuiAdmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${ctx}/static/layuiAdmin/style/admin.css" media="all">

    <script>
        /^http(s*):\/\//.test(location.href) || alert('请先部署到 localhost 下再访问');
    </script>
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
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="http://www.layui.com/admin/" target="_blank" title="前台">
                        <i class="layui-icon layui-icon-website"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" layadmin-event="refresh" title="刷新">
                        <i class="layui-icon layui-icon-refresh-3"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search" layadmin-event="serach" lay-action="template/search.html?keywords=">
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">

                <li class="layui-nav-item" lay-unselect>
                    <a lay-href="app/message/index.html" layadmin-event="message" lay-text="消息中心">
                        <i class="layui-icon layui-icon-notice"></i>

                        <!-- 如果有新消息，则显示小圆点 -->
                        <span class="layui-badge-dot"></span>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="theme">
                        <i class="layui-icon layui-icon-theme"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="note">
                        <i class="layui-icon layui-icon-note"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="fullscreen">
                        <i class="layui-icon layui-icon-screen-full"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;">
                        <cite>贤心</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a lay-href="set/user/info.html">基本资料</a></dd>
                        <dd><a lay-href="set/user/password.html">修改密码</a></dd>
                        <hr>
                        <dd layadmin-event="logout" style="text-align: center;"><a>退出</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="about"><i class="layui-icon layui-icon-more-vertical"></i></a>
                </li>
                <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
                    <a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
                </li>
            </ul>
        </div>

        <!-- 侧边菜单 -->
        <div class="layui-side layui-side-menu">
            <div class="layui-side-scroll">
                <div class="layui-logo" lay-href="index">
                    <span>layuiAdmin</span>
                </div>

                <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
                    <li data-name="home" class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;" lay-tips="主页" lay-direction="2">
                            <i class="layui-icon layui-icon-home"></i>
                            <cite>主页</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="console" class="layui-this">

                                <a lay-href="index">控制台</a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="${ctx}/static/layuiAdmin/src/views/home/homepage1.jsp">主页一</a>
                            </dd>
                            <dd data-name="console">
                                <a lay-href="${ctx}/static/layuiAdmin/src/views/home/homepage2.jsp">主页二</a>
                            </dd>
                        </dl>
                    </li>

                    <li data-name="app" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="应用" lay-direction="2">
                            <i class="layui-icon layui-icon-app"></i>
                            <cite>图书信息管理</cite>
                        </a>
                        <dl class="layui-nav-child">

                            <dd data-name="content">
                                <a href="javascript:;">内容系统</a>
                                <dl class="layui-nav-child">
                                    <dd data-name="list"><a lay-href="user2/list ">图书列表</a></dd>
                                    <dd data-name="tags"><a lay-href="${ctx}/static/layuiAdmin/src/views/app/content/tags.html">分类管理</a></dd>
                                </dl>
                            </dd>
                        </dl>
                    </li>




                    <li data-name="app" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="应用" lay-direction="2">
                            <i class="layui-icon layui-icon-app"></i>
                            <cite>读者信息管理</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="list"><a lay-href="${ctx}/static/layuiAdmin/src/views/app/content/list.html">读者增</a></dd>
                            <dd data-name="tags"><a lay-href="${ctx}/static/layuiAdmin/src/views/app/content/tags.html">读者删</a></dd>
                            <dd data-name="comment"><a lay-href="${ctx}/static/layuiAdmin/src/views/app/content/comment.html">读者改</a></dd>
                            <dd data-name="comment"><a lay-href="${ctx}/static/layuiAdmin/src/views/app/forum/replys.html">读者查询</a></dd>
                        </dl>
                    </li>

                    <li data-name="app" class="layui-nav-item">
                        <a href="javascript:;" lay-tips="应用" lay-direction="2">
                            <i class="layui-icon layui-icon-app"></i>
                            <cite>借阅信息管理</cite>
                        </a>
                        <dl class="layui-nav-child">

                            <dd data-name="content">
                                <a href="javascript:;">内容系统</a>
                                <dl class="layui-nav-child">

                                    <dd data-name="list"><a lay-href="${ctx}/static/layuiAdmin/src/views/app/content/list.html">借阅列表</a></dd>
                                    <dd data-name="tags"><a lay-href="${ctx}/static/layuiAdmin/src/views/app/content/tags.html">借书</a></dd>
                                    <dd data-name="comment"><a lay-href="${ctx}/static/layuiAdmin/src/views/app/content/comment.html">还书</a></dd>
                                    <dd data-name="comment"><a lay-href="${ctx}/static/layuiAdmin/src/views/app/forum/replys.html">续借</a></dd>
                                </dl>
                            </dd>
                            <a lay-href="${ctx}/static/layuiAdmin/src/views/app/message/index.html">消息中心（在一周内如果要归还在这里）</a>
                            </dd>
                            <dd data-name="workorder">
                                <a lay-href="${ctx}/static/layuiAdmin/src/views/app/workorder/list.html">工单系统</a>
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
                                <dd><a lay-href="${ctx}/static/layuiAdmin/src/views/set/system/website.html">网站设置</a></dd>
                                <dd><a lay-href="${ctx}/static/layuiAdmin/src/views/set/system/email.html">邮件服务</a></dd>
                            </dl>
                        </dd>
                        <dd class="layui-nav-itemed">
                            <a href="javascript:;">我的设置</a>
                            <dl class="layui-nav-child">
                                <dd><a lay-href="${ctx}/static/layuiAdmin/src/views/set/user/info.html">基本资料</a></dd>
                                <dd><a lay-href="${ctx}/static/layuiAdmin/src/views/set/user/password.html">修改密码</a></dd>
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
                    <li lay-id="home/console.html" lay-attr="home/console.html" class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
                </ul>
            </div>
        </div>


        <!-- 主体内容 -->
        <div class="layui-body" id="LAY_app_body">
            <div class="layadmin-tabsbody-item layui-show">
                <iframe src="index" frameborder="0" class="layadmin-iframe"></iframe>
            </div>
        </div>

        <!-- 辅助元素，一般用于移动设备下遮罩 -->
        <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
</div>

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


