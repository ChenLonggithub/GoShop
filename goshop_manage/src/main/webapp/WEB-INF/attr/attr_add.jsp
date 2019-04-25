<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/3
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>添加属性添加</h3>flbh2=${flbh2}
<hr>
<form action="attr_add.do">
    <input type="hidden" value="${flbh2}" name="flbh2">
    <table width="560px" border="1">
        <tr>
            <td>属性名：<input type="text" name="list_attr[0].shxm_mch"></td>
            <td></td>
            <td>添加属性值</td>
        </tr>
        <tr>
            <td>属性值：<input type="text" name="list_attr[0].list_value[0].shxzh"></td>
            <td>单位：<input type="text" name="list_attr[0].list_value[0].shxzh_mch"></td>
            <td><button>删除</button></td>
        </tr>
        <tr>
            <td>属性值：<input type="text" name="list_attr[0].list_value[1].shxzh"></td>
            <td>单位：<input type="text" name="list_attr[0].list_value[1].shxzh_mch"></td>
            <td><button>删除</button></td>
        </tr>
    </table><br><br>
    <table width="560px" border="1">
        <tr>
            <td>属性名：<input type="text" name="list_attr[1].shxm_mch"></td>
            <td></td>
            <td>添加属性值</td>
        </tr>
        <tr>
            <td>属性值：<input type="text" name="list_attr[1].list_value[0].shxzh"></td>
            <td>单位：<input type="text" name="list_attr[1].list_value[0].shxzh_mch"></td>
            <td><button>删除</button></td>
        </tr>
        <tr>
            <td>属性值：<input type="text" name="list_attr[1].list_value[1].shxzh"></td>
            <td>单位：<input type="text" name="list_attr[1].list_value[1].shxzh_mch"></td>
            <td><button>删除</button></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
