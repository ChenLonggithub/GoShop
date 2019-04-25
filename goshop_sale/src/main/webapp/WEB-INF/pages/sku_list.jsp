<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/20
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
商品列表：<br>
<c:forEach items="${list_sku}" var="sku">
    <div style="margin-top:10px;margin-left:10px;float:left;border:1px red solid;width:150px;height:180px">
        <img src="upload/image/${sku.spu.shp_tp}" width="100px" height="100px"><br>
            <a href="goto_sku_detail.do?sku_id=${sku.id}&spu_id=${sku.spu.id}" target="_blank"> ${sku.sku_mch}</a><br>
            ${sku.jg}<br>
            ${sku.sku_xl}<br>
    </div>
</c:forEach>
</body>
</html>
