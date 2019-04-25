<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/3
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
</head>

<body>
<div id="attrListInner"></div>

<div class="easyui-layout" data-options="fit:true" style="width: 100%;height: 500px">
    <div data-options="region:'north',split:true" style="padding-left:10px;height:50px;line-height: 50px">
        一级
        <select id="attr_class_1_select" onchange="attr_class_2(this.value)">
            <option>=请选择=</option>
        </select>
        二级<select id="attr_class_2_select" onchange="get_attr(this.value)">
            <option>=请选择=</option>
        </select>
    </div>
    <div data-options="region:'west',split:true" style="width:11%;">
        <ul style="list-style: none;margin-left: -10px">
            <li><a href="javascript:(0)">查询属性</a></li>
            <li><a href="javascript:goto_attr_add()">添加属性</a></li>
            <li><a href="javascript:(0)">编辑属性</a></li>
            <li><a href="javascript:(0)">删除属性</a></li>
        </ul>
    </div>
    <div data-options="region:'center'">
        111111
    </div>
</div>
<script type="text/javascript">

    $(function () {
        $.getJSON("js/json/class_1.js", function (data) {
            $(data).each(function (i, json) {
                $("#attr_class_1_select").append("<option value=" + json.id + ">" + json.flmch1 + "</option>")
            })
        })
    })

    /*二级级联表的内容*/
    function attr_class_2(class_1_id) {
        $("#attr_class_2_select").empty();
        $.getJSON("js/json/class_2_" + class_1_id + ".js", function (data) {
            $(data).each(function (i, json) {
                $("#attr_class_2_select").append("<option value=" + json.id + ">" + json.flmch2 + "</option>")
            })
        })
    }

    function goto_attr_add() {
        var flbh2 = $("#attr_class_2_select").val();
        var path = "goto_attr_add.do?flbh2=" + flbh2;
        addTab('添加属性',path);
    }

    function get_attr(flbh2) {
        $.post(
            "get_attr.do",
            {flbh2: flbh2},
            function (data) {
                $("#attrListInner").html(data);
            });
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
