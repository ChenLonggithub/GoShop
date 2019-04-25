<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/23
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
</head>
<script>
    function showCart() {
        $.post("queryCart.do",function (data) {
            $("#cartList").html(data);
        })
        $("#cartList").show();
    }

    function hideCart() {
        $("#cartList").hide();
    }
</script>
<body>
<div class="card">
    <a href="goto_cartList.do" onmouseover="showCart()" onmouseout="hideCart()">购物车
        <div class="num">0</div>
    </a>

    <!--购物车商品-->
    <div id="cartList" class="cart_pro" style="display: none">
        <jsp:include page="miniCartList.jsp"></jsp:include>
    </div>
</div>
</body>
</html>
