<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/1
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="css/css/font-awesome.min.css">
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
</head>
<style>
    a{
        text-decoration: none;
    }
</style>
<body class="easyui-layout">
<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">
    <span style="font-size: 24px;font-family: '微软雅黑 Light'">电商网站后台管理员操作界面</span>
</div>
<div data-options="region:'west',split:true,title:'&nbsp;&nbsp;&nbsp;&nbsp;管理界面'" style="width:14%;padding:10px;">
    <div class="easyui-accordion" style="width:100%;">
        <div title="商品管理" data-options="iconCls:'icon-look'" style="overflow:auto;padding:6px;">
            <ul class="easyui-tree">
                <li><a href="javascript:;" onclick="addTab('商品信息管理','goto_spu.do')"><i class="fa fa-cog fa-fw"></i>&nbsp;商品信息管理</a></li>
                <li><a href="javascript:;" onclick="addTab('商品属性管理','goto_attr.do')"><i class="fa fa-cog fa-fw"></i>&nbsp;商品属性管理</a></li>
                <li><a href="javascript:;" onclick="addTab('商品库存单元管理','goto_sku.do')"><i class="fa fa-cog fa-fw"></i>&nbsp;商品库存单元管理</a></li>
                <li><a href="javascript:;" onclick="addTab('商品缓存管理','')"><i class="fa fa-cog fa-fw"></i>&nbsp;商品缓存管理</a></li>
            </ul>
        </div>
        <div title="其他管理" data-options="iconCls:'icon-lock'" style="padding:10px;">
            111111111
        </div>
    </div>

</div>
<!--    <div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">
        east region
    </div>-->

<div data-options="region:'center',title:'数据界面'">
    <div class="easyui-tabs" id="tt" style="height: 480px;" >
        <div title="首页" data-options="iconCls:'icon-help',closable:true" style="padding:10px;">
            <h3>欢迎来到我的购物后台</h3>
        </div>
    </div>
</div>

<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">
    <span style="margin-left: 250px">Jquery EasyUI中文网内容基于EasyUI官网, Copyright © 2014 - 2019, 粤ICP备14024044号, All Rights Reserved</span>
</div>
</body>
<script>

    $(function () {
        $(".tree-icon,.tree-file").removeClass("tree-icon tree-file");
        $(".tree-icon,.tree-folder").removeClass("tree-icon tree-folder tree-folder-open tree-folder-closed");
    })

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
</html>