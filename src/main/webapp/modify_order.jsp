<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>修改订单信息</title>
	<link href="css/headandfoot.css" type="text/css" rel="stylesheet"/>
	<link href="css/global.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="header.jsp" />
<jsp:include page="userheader.jsp" />
	<c:if test="${empty user }"><%response.sendRedirect("index.jsp"); %></c:if>
	<script>var a='${msg}';</script>
	<c:if test="${!empty msg}"><script>alert(a);</script></c:if>
<script type="text/javascript" src="js/confirm_msg.js"></script>

	<div class="usercenter">
		<form action="modify_order_msg?OrderID=${g.getID()}" method="post">
	<section>
		<div class="login">
			<h2>修改订单信息</h2>
			<p>将需要修改的信息删去填上新的信息，然后点击“提交修改”即可</p>
			<div class="inputbox">
				<span>电话：</span>
				<input type="tel" name="UserPhone" value="${g.getUserPhone() }" placeholder="请输入电话号码" required="required" oninput="if(value.length>15)value=value.slice(0,15)" onkeyup="value=value.replace(/[^\d]/g,'')">
			</div>
			<div class="inputbox">
				<span>收货地址：</span>
				<input type="text" name="UserAdress" value="${g.getUserAdress() }" placeholder="请店家收货地址" required="required" oninput="if(value.length>45)value=value.slice(0,45)" onkeyup="value = value.replace(/([^0-9A-z\u4e00-\u9fa5]|[\^\_])/g,'')">
			</div>
			<div class="inputbox">
				<span>购买数量：</span>
				<input type="text" name="amount" value="${g.getAmount() }" placeholder="请输入商品数量" required="required" oninput="if(value.length>15)value=value.slice(0,15)" onkeyup="value=value.replace(/[^\d]/g,'')">
			</div>
			<div class="group">
				<input type="submit" value="提交修改">
			</div>
		</div>	
	</section>
	</form>
	</div>

</body>
</html>