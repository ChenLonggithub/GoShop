<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/17
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath %>">
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<html>
<head>
    <title>Title</title>
</head>

<body>
sku商品信息管理
<hr>
<form action="save_sku.do">
    <input type="hidden" value="${flbh1}">
    <input type="hidden" value="${flbh2}"><br>
    品牌：<select id="sku_tm_select" name="pp_id" onchange="get_product(this.value)"></select>
    商品：<select id="spu_list" name="id"></select><br>
    分类属性：
    <c:forEach items="${attr_list}" var="attr" varStatus="vs">
        <input type="checkbox" name="list_attr[${vs.index}].shxm_id"
               id="" value="${attr.id}" onclick="show_value(${attr.id},this.checked)">${attr.shxm_mch}
    </c:forEach>
    <br>
    <c:forEach items="${attr_list}" var="attr" varStatus="vs">
        <div id="value_${attr.id}" style="display: none">
            <c:forEach items="${attr.list_value}" var="attrValue">
                <input type="radio" value="${attrValue.id}"
                       name="list_attr[${vs.index}].shxzh_id">${attrValue.shxzh} ${attrValue.shxzh_mch}
            </c:forEach>
        </div>
    </c:forEach><br>

    商品库存名称：<input type="text" name="sku_mch"/><br>
    商品库存数量：<input type="text" name="kc"/><br>
    商品库存价格：<input type="text" name="jg"/><br>
    商品库存地址：<input type="text" name="kcdz"/><br>
    <br>
    <input type="submit" value="提交">
</form>
<script type="text/javascript">
    $(function () {
        var flbh1 = "${flbh1}";
        $.getJSON("js/json/tm_class_1_" + flbh1 + ".js", function (data) {
            $("#sku_tm_select").empty();
            $(data).each(function (i, json) {
                $("#sku_tm_select").append("<option value=" + json.id + ">" + json.ppmch + "</option>");
            });
        })
    });

    /*根据pp_id 和 flbh2的值，获取到商品的值*/
    function get_product(pp_id) {
        var flbh2 = "${flbh2}";
        $.post(
            "getSpuList.do",
            {pp_id: pp_id, flbh2: flbh2},
            function (data) {
                $("#spu_list").empty();
                $(data).each(function (i, json) {
                    $("#spu_list").append("<option value=" + json.id + ">" + json.shp_mch + "</option>");
                })
            }
        )
    }

    function show_value(id, checked) {
        if(checked){
            $("#value_"+id).show();
        }else{
            $("#value_"+id).hide();
        }
    }
</script>
</body>
</html>
