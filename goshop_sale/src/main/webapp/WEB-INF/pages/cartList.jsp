<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>


<link rel="stylesheet" type="text/css" href="css/css.css">	
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function change_shfxz(checked,sku_id){
		var shfxz = "0";
		if(checked){
			shfxz="1";
		}
		
		$.post("change_shfxz.do",{sku_id:sku_id,shfxz:shfxz},function(data){
			$("#cartListInner").html(data);
		});
	}
</script>
<title>购物车</title>
</head>
<body>
	<div class="search">
		<div class="logo"><img src="./images/logo.jpg" alt=""></div>
		<div class="search_on">
			<div class="se">
				<input type="text" name="search" class="lf">
				<input type="submit" class="clik" value="搜索" style="height: 32px;">
			</div>
			<div class="se">
				<a href="">取暖神奇</a>
				<a href="">1元秒杀</a>
				<a href="">吹风机</a>
				<a href="">玉兰油</a>
			</div>
		</div>
	</div>
	<div id="cartListInner">
		<jsp:include page="common/cartListInner.jsp"></jsp:include>
	</div>

	<div class="footer">
		<div class="top"></div>
		<div class="bottom"><img src="images/foot.jpg" alt=""></div>
	</div>
</body>
</html>