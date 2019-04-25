<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/19
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    $(function (){
        var yh_mch = getMyCookie("yh_nch");
        $("#show_name").text(decodeURIComponent(yh_mch));
    });

    function getMyCookie(key){
        var val = "";

        // 对cookie操作
        var cookies = document.cookie;
        cookies = cookies.replace(/\s/,"");
        var cookie_array = cookies.split(";");
        for(i=0;i<cookie_array.length;i++){
            // yh_mch=lilei
            var cookie = cookie_array[i];
            var array = cookie.split("=");
            if(array[0]==key){
                val = array[1];
            }
        }

        return val;
    }
</script>
<body>
<div class="top">

    <div class="top_text">

        <c:if test="${empty user}">
            <a href="goto_register.do">免费注册</a>
            <a href="goto_login.do">你好，请登录<span id="show_name" style="color:red"></span></a>
            <a href="">网站导航</a>
            <a href="">企业采购</a>
        </c:if>
        <c:if test="${not empty user}">
            <a href="goto_logout.do">退出登录</a>
            <a href="" style="color: red">用户名称:${user.yh_mch}</a>
            <a href="" style="color: red">用户昵称:${user.yh_nch}</a>
            <a href="">用户订单</a>
            <a href="">我的订单</a>
            <a href="">我的京东</a>
            <a href="">京东会员</a>
        </c:if>

    </div>
</div>
</body>
</html>
