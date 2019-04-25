<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/19
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/css.css">
    <script type="text/javascript" src='js/jquery-1.7.2.min.js'></script>
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>
<div class="top_img">
    <img src="./images/top_img.jpg" alt="">
</div>
<jsp:include page="common/searchArea.jsp"></jsp:include>
<jsp:include page="common/class_list.jsp"></jsp:include>
<div class="banner">
    <div class="ban">
        <img src="./images/banner.jpg" width="980" height="380" alt="">
    </div>
</div>

</body>
</html>
