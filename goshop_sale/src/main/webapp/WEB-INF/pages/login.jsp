<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>京东-欢迎登录</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

</head>
<script>
    function login() {
        $("#formlogin").submit();
    }
</script>
<body>
<div class="w">
    <!-- 头部，logo部分 -->
    <div class="logo">
        <img alt="京东" src="${pageContext.request.contextPath }/images/logo.png"></img>
        <font size="5px" class="welcome-login">欢迎登录</font>
    </div>
    <a class="questions" onmouseover="color:red;" target="_blank"
       href="https://surveys.jd.com/index.php?r=survey/index/sid/568245/lang/zh-Hans">登录页面，调查问卷</a>
</div>
<!-- body -->
<div id="content">
    <div class=login-wrap>
        <div class="w">
            <!-- 登录框 -->
            <div class="login-form">
                <div class="login-tab login-tab-l">
                    <a class="ss" href="javascript:void(0)" style="color: #666">扫码登录</a>
                </div>
                <div class="login-tab login-tab-r">
                    <a class="ss" href="javascript:void(0)" style="color:#f00">账户登录</a>
                </div>
                <!-- 主体 -->
                <div class="login-box">
                    <div class="mt tab-h"></div>
                    <div class="msg-wrap">
                        <div class="msg-warn">
                            <label>公共场所不建议自动登录，以防账号丢失</label>
                        </div>
                    </div>

                    <!-- 输入框 -->
                    <div class="mc">
                        <div class="form">
                            <form id="formlogin" action="login.do" method="post">
                                <div class="item item-fore1">
                                    <!-- <div class="input-group-addon glyphicon glyphicon-user">aa</div> -->
                                    <label for="loginanme" class="login-label name-label ">账号</label>
                                    <input  class="itxt" type="text" name="yh_mch" placeholder="邮箱/用户名/已验证手机">
                                </div>
                                <div class="item item-fore2">
                                    <label for="loginanme" class="login-label name-label">密码</label>
                                    <input type="text"  class="itxt"name="yh_mm" placeholder="请输入密码">
                                </div>

                                <div class="item item-fore4">
                                    <div class="safe">
                                        <input class="jdcheckbox" type="checkbox" name="remember">自动登录
                                        <a href="#" class="forgetPassword" style="text-align: right;">忘记密码</a>
                                    </div>
                                </div>

                                <!-- 登录按钮 -->
                                <div class="item item-fore5">
                                    <div class="login-btn">
                                        <a href="javascript:login();"  class="btn-img btn-entry"  tabindex="6" id="loginsubmit">
                                            登  录</a>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="login-banner" ><!-- style="background-color:#041422" -->
            <div class="w">
                <img  class="main-img"  height="475px" width="90px"
                      src="${pageContext.request.contextPath}/images/login.jpg">
                <!-- <div id="banner-bg"  class="i-inner"
                        style="background: url(//img11.360buyimg.com/da/jfs/t3154/258/5179306513/128208/9d5b12bd/5864cf6eN542ab244.jpg) "></div> -->
            </div>
        </div>
    </div>

</div>

<div class="w">
    <div id="footer">
        <div class="links">
            <a rel="nofollow" target="_blank" href="//www.jd.com/intro/about.aspx">
                关于我们
            </a>
            |
            <a rel="nofollow" target="_blank" href="//www.jd.com/contact/">
                联系我们
            </a>
            |
            <a rel="nofollow" target="_blank" href="//zhaopin.jd.com/">
                人才招聘
            </a>
            |
            <a rel="nofollow" target="_blank" href="//www.jd.com/contact/joinin.aspx">
                商家入驻
            </a>
            |
            <a rel="nofollow" target="_blank" href="//www.jd.com/intro/service.aspx">
                广告服务
            </a>
            |
            <a rel="nofollow" target="_blank" href="//app.jd.com/">
                手机京东
            </a>
            |
            <a target="_blank" href="/links.vm/club.jd.com/links.aspx">
                友情链接
            </a>
            |
            <a target="_blank" href="//media.jd.com/">
                销售联盟
            </a>
            |
            <a href="//club.jd.com/" target="_blank">
                京东社区
            </a>
            |
            <a href="//gongyi.jd.com" target="_blank">
                京东公益
            </a>
            |
            <a target="_blank" href="//en.jd.com/" clstag="pageclick|keycount|20150112ABD|9">English Site</a>
        </div>
        <div class="copyright">
            Copyright &copy; 2004-2017  京东JD.com 版权所有
        </div>
    </div>
</div>
</body>
</html>