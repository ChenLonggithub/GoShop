<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/22
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/css.css">
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
</head>
<script>
    function cart_submit() {
        $("#cart_form").submit();
    }
</script>
<body>
商品详情页面<br>
<div class="Dbox">
    <div class="box">
        <div class="left">
            <div class="timg"><img src="upload/image/${obj_sku.spu.shp_tp}" alt="" width="300px" height="300px"></div>
            <div class="timg2">
                <div class="lf"><img src="images/lf.jpg" alt=""></div>
                <div class="center">
                    <span><img src="images/icon_2.jpg" alt=""></span>
                    <span><img src="images/icon_3.jpg" alt=""></span>
                    <span><img src="images/icon_2.jpg" alt=""></span>
                    <span><img src="images/icon_3.jpg" alt=""></span>
                    <span><img src="images/icon_2.jpg" alt=""></span>
                </div>
                <div class="rg"><img src="images/rg.jpg" alt=""></div>
            </div>
            <div class="goods"><img src="images/img_6.jpg" alt=""></div>
        </div>
        <div class="cent">
            <div class="title">${obj_sku.sku_mch}</div>
            <div class="bg">
                <p>市场价：<strong>￥${obj_sku.jg}</strong></p>
                <p>促销价：<strong>￥${obj_sku.jg}</strong></p>
            </div>
            <div class="clear">
                <div class="min_t">选择版本：</div>
                <c:forEach items="${list_sku}" var="sku">
                    <div class="min_mx"><a
                            href="goto_sku_detail.do?sku_id=${sku.id}&spu_id=${sku.shp_id}">${sku.sku_mch}</a></div>
                </c:forEach>
            </div>
            <div class="clear">
                <div class="min_t">服务：</div>
                <div class="min_mx">服务1号1</div>
                <div class="min_mx">服务二号1112</div>
                <div class="min_mx">55英服务二号1111寸活动中3</div>
                <div class="min_mx">4</div>
                <div class="min_mx">呃呃呃5</div>
                <div class="min_mx">55英寸活动中6</div>
            </div>
            <div class="clear" style="margin-top:20px;">
                <div class="min_t" style="line-height:36px">数量：</div>
                <div class="num_box">
                    <input type="text" name="num" value="1" style="width:40px;height:32px;text-align:center;float:left">
                    <div class="rg">
                        <img src="images/jia.jpg" id='jia' alt="">
                        <img src="images/jian.jpg" id='jian' alt="">
                    </div>
                </div>
            </div>
            <div class="clear" style="margin-top:20px;">
                <form id="cart_form" action="add_cart.do" method="post">
                    <input type="hidden" name="sku_mch" value="${obj_sku.sku_mch}"/>
                    <input type="hidden" name="sku_jg" value="${obj_sku.jg}"/>
                    <input type="hidden" name="tjshl" value="1"/>
                    <input type="hidden" name="hj" value="${obj_sku.jg}"/>
                    <input type="hidden" name="shp_id" value="${obj_sku.shp_id}"/>
                    <input type="hidden" name="sku_id" value="${obj_sku.id}"/>
                    <input type="hidden" name="shp_tp" value="${obj_sku.spu.shp_tp}"/>
                    <input type="hidden" name="shfxz" value="1"/>
                    <input type="hidden" name="kcdz" value="${obj_sku.kcdz}"/>
                    <c:if test="${not empty user}">
                        <input type="hidden" name="yh_id" value="${user.id}"/>
                    </c:if>
                    <img src="images/shop.jpg" onclick="cart_submit()" alt="" style="cursor:pointer;">
                </form>

            </div>
        </div>
    </div>
</div>
<div class="Dbox1">
    <div class="boxbottom">
        <div class="top">
            <span>商品详情</span>
            <span>评价</span>
        </div>
        <div class="btm">
            ${obj_sku.spu.shp_msh}<br>
            <c:forEach items="${obj_sku.list_image}" var="image">
                <img src="upload/image/${image.url}" height="200px" width="200px"/>
            </c:forEach><br>
            <c:forEach items="${obj_sku.list_av_name}" var="av_name">
                ${av_name.shxm_mch}:${av_name.shxzh_mch}<br>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
