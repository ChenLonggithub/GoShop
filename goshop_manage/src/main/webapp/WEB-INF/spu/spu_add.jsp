<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/1
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
信息添加 ----${spu.flbh1}||${spu.flbh2}||${spu.pp_id}----
<hr>
<form action="spu_add.do" method="post" enctype="multipart/form-data">

    <input type="hidden" name="flbh1" value="${spu.flbh1}">
    <input type="hidden" name="flbh2" value="${spu.flbh2}">
    <input type="hidden" name="pp_id" value="${spu.pp_id}">
    商品名称：<input type="text" name="shp_mch"><br>
    商品描述：<textarea cols="50" name="shp_msh" rows="10" type="text"></textarea><br>
    商品图片：<br>
    <div id="div_0" style="float: left">
        <input id="file_0" type="file" name="files" style="display: none" onchange="replace_image(0)">
        <img id="image_0" onclick="select_image(0)" style="cursor:pointer;padding: 5px" src="image/upload_hover.jpg"
             width="90px" height="90px">
    </div>
    <input type="submit" name="" id="" value="提交" style="margin-top: 70px">
</form>
<script type="text/javascript">
    //使file生效
    function select_image(index) {
        $("#file_" + index).click();
    }

    //将用户选择的图片加载到游览器上显示出来
    function replace_image(index) {
        /*获得图片对象*/
        var blob_image = $("#file_" + index)[0].files[0];
        var url = window.URL.createObjectURL(blob_image);
        /*替换image*/
        $("#image_" + index).attr("src", url);

        var length = $(":file").length;

        if ((index + 1) == length) {
            // 用户选择的是最后一张图片
            add_image(index);
        }
    }

    //当用户选择一张图片后，添加一个image
    function add_image(index) {
        var a = '<div id="div_' + (index + 1) + '" style="float: left">';
        var b = '<input id="file_' + (index + 1) + '" type="file" name="files" style="display: none;" onchange="replace_image(' + (index + 1) + ')">';
        var c = '<img id="image_' + (index + 1) + '" onclick="select_image(' + (index + 1) + ')" style="cursor:pointer;padding: 5px" src="image/upload_hover.jpg" width="90px" height="90px">';
        var d = '</div>';
        $("#div_" + index).after(a + b + c + d);
    }
</script>
</body>
</html>
