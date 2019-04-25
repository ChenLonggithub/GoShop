<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/17
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body>

<div class="easyui-layout" data-options="fit:true" style="width: 100%;height: 500px">
    <div data-options="region:'north',split:true" style="padding-left:10px;height:50px;line-height: 50px">
        一级：<select id="sku_class_1_select" onchange="get_class_2(this.value);">
        <option>请选择</option>
    </select>
        二级：<select id="sku_class_2_select">
        <option>请选择</option>
    </select>
    </div>
    <div data-options="region:'west',split:true" style="width:11%;">
        <ul style="list-style: none;margin-left: -10px">
            <li><a href="javascript:goto_sku_add()">添加库存</a></li>
            <li><a href="javascript:;">编辑库存</a></li>
            <li><a href="javascript:(0)">删除库存</a></li>
        </ul>
    </div>
    <div data-options="region:'center'">
        111111
    </div>
</div>
<script type="text/javascript">
    /*一级级联表的内容*/
    $(function () {
        $.getJSON("js/json/class_1.js", function (data) {
            $(data).each(function (i, json) {
                $("#sku_class_1_select").append("<option value=" + json.id + ">" + json.flmch1 + "</option>");
            });
        });
    });

    /*二级级联表的内容*/
    function get_class_2(class_1_id) {
        $("#sku_class_2_select").empty();
        $.getJSON("js/json/class_2_" + class_1_id + ".js", function (data) {
            $(data).each(function (i, json) {
                $("#sku_class_2_select").append("<option value=" + json.id + ">" + json.flmch2 + "</option>")
            })
        })
    }

    function goto_sku_add() {
        var flbh1 = $("#sku_class_1_select").val();
        var flbh2 = $("#sku_class_2_select").val();
        var path="goto_sku_add.do?flbh1="+flbh1+"&flbh2="+flbh2;
        addTab('添加库存',path);
    }

    function addTab(title, url){
        if ($('#tt').tabs('exists', title)){
            $('#tt').tabs('select', title);
        } else {
            $('#tt').tabs('add',{
                title:title,
                href:url,
                closable:true,
                tools:[{
                    iconCls:'icon-mini-refresh',
                    handler:function(){
                        alert('refresh');
                    }
                }]
            });
        }
    }
</script>
</body>
</html>
