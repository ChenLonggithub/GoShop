<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/17
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
属性列表：<br><br>
<c:forEach items="${list_attr}" var="attr">
    ${attr.shxm_mch}:
    <c:forEach items="${attr.list_value}" var="attrValue" varStatus="v">
        ${attrValue.shxzh} ${attrValue.shxzh_mch}
    </c:forEach>
    <br>
</c:forEach>
</body>
</html>
