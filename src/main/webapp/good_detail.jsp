<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>商品详情</title>
	<link href="css/headandfoot.css" type="text/css" rel="stylesheet"/>
	<link href="css/global.css" type="text/css" rel="stylesheet"/>
	<link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript" src="js/confirm_msg.js"></script>
</head>
<body>
	<script>var a='${msg}';</script>
	<c:if test="${!empty msg}"><script>alert(a);</script></c:if>
	
	<div style="margin:10%">
	<ul style="margin:10px;padding:10px;list-style-type: none;overflow: hidden;">
		<li style="float:left"><img src=".${g.getGoodImage()}" width="500px" height="500px"><li>
		<li style="float:left"><a style="margin-left:150px;padding: 14px 16px;text-decoration: none;text-align: center;font-size: 40px;">${g.getGoodName()}</a></li>
		
		<li><a style="display: block;margin-left:10px;padding: 14px 16px;text-decoration: none;text-align: center;color:red;font-size: 20px;">价格：${g.getGoodPrice()}元</a></li>
		<li><a style="display: block;margin-left:10px;padding: 14px 16px;text-decoration: none;text-align: center;font-size: 20px;">库存：${g.getGoodStock()}件</a></li>
		<li><a style="display: block;margin-left:10px;padding: 14px 16px;text-decoration: none;text-align: center;font-size: 20px;">季度已售：${g.getGoodNum()}件</a></li>
		<li><a style="display: block;margin-left:70px;padding: 14px 16px;text-decoration: none;text-align: left;font-size: 20px;">简介:</a></li>
		<li><a style="display: block;margin-left:70px;padding: 14px 16px;text-decoration: none;text-align: left;font-size: 20px;">${g.getGoodIntrodution()}</a></li>
		<li style="text-decoration: none;"><div class="listchoose"><a href="add_order?ID=${g.getID()}&&GoodName=${g.getGoodName()}" target="_blank">加入购物车</a></div></li>
	</ul>
	</div>

<jsp:include page="footer.jsp" />
</body>
</html>