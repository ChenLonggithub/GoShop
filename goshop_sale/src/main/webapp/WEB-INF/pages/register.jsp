<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/19
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>注册页面</title>
    <link rel="stylesheet" href="css/sign.css"/>

    <script>
        // 1、获得焦点，内容为空，tip默认提示
        // 2、失去焦点，内容为空，tip为隐藏
        // 3、其他情况（按键抬起，失去焦点且内容不为空，或最后表单总验证）
        //    按键抬起为空，报错，不能为空
        //    内容匹配，成功
        //    内容不匹配，失败
        // 4、密码要进行安全等级检测，含数字、字母、特殊字符为强，两种为中，一种为弱
        // 5、确认密码失去焦点的时候就要验证是否一致
    </script>
</head>
<body>
<!--头部-->
<div class="header">
    <a class="logo" href="##"></a>
    <div class="desc">欢迎注册</div>
</div>
<!--版心-->
<div class="container">
    <!--京东注册模块-->
    <div class="register">
        <!--用户名-->
        <div class="register-box">
            <!--表单项-->
            <div class="box default">
                <label for="userName">用&nbsp;户&nbsp;名</label>
                <input type="text" id="userName" placeholder="您的账户名和登录名" />
                <i></i>
            </div>
            <!--提示信息-->
            <div class="tip">
                <i></i>
                <span></span>
            </div>
        </div>
        <!--设置密码-->
        <div class="register-box">
            <!--表单项-->
            <div class="box default">
                <label for="pwd">设 置 密 码</label>
                <input type="password" id="pwd" placeholder="建议至少两种字符组合" />
                <i></i>
            </div>
            <!--提示信息-->
            <div class="tip">
                <i></i>
                <span></span>
            </div>
        </div>
        <!--确认密码-->
        <div class="register-box">
            <!--表单项-->
            <div class="box default">
                <label for="pwd2">确 认 密 码</label>
                <input type="password" id="pwd2" placeholder="请再次输入密码" />
                <i></i>
            </div>
            <!--提示信息-->
            <div class="tip">
                <i></i>
                <span></span>
            </div>
        </div>
        <!--设置密码-->
        <div class="register-box">
            <!--表单项-->
            <div class="box default">
                <label for="email">邮 箱 验 证</label>
                <input type="text" id="email" placeholder="请输入邮箱" />
                <i></i>
            </div>
            <!--提示信息-->
            <div class="tip">
                <i></i>
                <span></span>
            </div>
        </div>
        <!--手机验证-->
        <div class="register-box">
            <!--表单项-->
            <div class="box default">
                <label for="mobile">手 机 验 证</label>
                <input type="text" id="mobile" placeholder="请输入手机号" />
                <i></i>
            </div>
            <!--提示信息-->
            <div class="tip">
                <i></i>
                <span></span>
            </div>
        </div>
        <!--注册协议-->
        <div class="register-box xieyi">
            <!--表单项-->
            <div class="box default">
                <input type="checkbox" id="ck" />
                <span>我已阅读并同意<a href="##">《京东用户注册协议》</a></span>
            </div>
            <!--提示信息-->
            <div class="tip">
                <i></i>
                <span></span>
            </div>
        </div>
        <!--注册-->
        <button id="btn">注册</button>
    </div>

</div>
</body>
</html>