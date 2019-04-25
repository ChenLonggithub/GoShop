<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/1
  Time: 21:32
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
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
</head>
<body>

<div class="easyui-layout" data-options="fit:true" style="width: 100%;height: 500px">
    <div data-options="region:'north',split:true" style="padding-left:10px;height:50px;line-height: 50px">
        一级<select id="class_1_select" onchange="class_2(this.value)">
        <option>=请选择=</option>
    </select>
        二级<select id="class_2_select">
        <option>=请选择=</option>
    </select>
        品牌<select id="tm_select">
        <option>=请选择=</option>
    </select>
    </div>
    <div data-options="region:'west',split:true" style="width:11%;padding-top: 10px">
        <ul class="easyui-tree">
            <li><a href="javascript:;" onclick="addTab('商品查询','')" style="margin-top: 10px;">商品查询</a></li>
            <li><a href="javascript:goto_spu_add()"  style="margin-top: 10px;">商品添加</a></li>
            <li><a href="javascript:;" onclick="addTab('商品编辑','')"  style="margin-top: 10px;">商品编辑</a></li>
            <li><a href="javascript:;" onclick="addTab('商品删除','')"  style="margin-top: 10px;">商品删除</a></li>
        </ul>
    </div>
    <div data-options="region:'center'" >
        <div  class="easyui-tabs" id="spu_data">

        </div>
    </div>
</div>

<script type="text/javascript">
    /*一级级联表的内容*/
    $(function (){
        $.getJSON("js/json/class_1.js",function(data){
            $(data).each(function(i,json){
                $("#class_1_select").append("<option value="+json.id+">"+json.flmch1+"</option>");
            });
        });
    });
    /*二级级联表的内容*/
    function class_2(class_1_id) {
        $("#class_2_select").empty();
        $.getJSON("js/json/class_2_"+class_1_id+".js",function (data) {
            $(data).each(function (i,json) {
                $("#class_2_select").append("<option value="+json.id+">"+json.flmch2+"</option>")
            })
        })
        /*当二级级联表内容加载好之后，调用品牌函数*/
        get_tm(class_1_id);
    }
    /*品牌级联表的内容*/
    function get_tm(class_1_id) {
        $("#tm_select").empty();
        $.getJSON("js/json/tm_class_1_"+class_1_id+".js",function (data) {
            $(data).each(function (i,json) {
                $("#tm_select").append("<option value="+json.id+">"+json.ppmch+"</option>")
            })
        })
    }

    function goto_spu_add() {
        var class_1_id = $("#class_1_select").val();
        var class_2_id = $("#class_2_select").val();
        var tm_id = $("#tm_select").val();
        var path="goto_spu_add.do?flbh1="+class_1_id+"&flbh2="+class_2_id+"&pp_id="+tm_id;
        addTab('商品添加',path);
    }

    function addTab(title, url){
        if ($('#spu_data').tabs('exists', title)){
            $('#spu_data').tabs('select', title);
        } else {
            $('#spu_data').tabs('add',{
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
