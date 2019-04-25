<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/23
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h6>最新加入的商品</h6>

<c:forEach items="${list_cart}" var="cart">
    <div class="one">
        <img src="upload/image/${cart.shp_tp}" width="80px;" />
        <span class="one_name">
                ${cart.sku_mch}
        </span>
        <span class="one_prece">
				<b>￥${cart.sku_jg}</b><br />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;删除
			</span>
    </div>
</c:forEach>
<div class="gobottom">
    共<span>2</span>件商品&nbsp;&nbsp;&nbsp;&nbsp;
    共计￥<span>20000</span>
    <button class="goprice">去购物车</button>
</div>
</body>
</html>
