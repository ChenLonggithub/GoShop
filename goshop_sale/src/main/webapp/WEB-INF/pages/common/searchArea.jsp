<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/19
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="search">
    <div class="logo"><img src="./images/qw.png" alt="" style="height: 72px"></div>
    <div class="search_on">
        <div class="se">
            <form action="keywords.do">
                <input type="text" name="keywords" class="lf">
                <input type="submit" class="clik" value="搜索">
            </form>
        </div>
        <div class="se">
            <a href="">取暖神奇</a>
            <a href="">1元秒杀</a>
            <a href="">吹风机</a>
            <a href="">玉兰油</a>
        </div>
    </div>
    <jsp:include page="miniCart.jsp"></jsp:include>
</div>
</body>
</html>
