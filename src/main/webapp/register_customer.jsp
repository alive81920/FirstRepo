<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>用户注册</title>
	<link href="css/headandfoot.css" type="text/css" rel="stylesheet"/>
	<link href="css/global.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript" src="js/confirm_msg.js"></script>
</head>

<body>
	<jsp:include page="header.jsp" />
	<script>
		var a='${msg}';
	</script>
	<c:if test="${!empty msg}"><script>alert(a);</script></c:if>
	
	<form action="register_customer" method="post">
	<section>
		<div class="login">
			<h2>注册用户</h2>
			<div class="inputbox">
				<span>账号：</span>
				<input type="text" name="UserName" placeholder="请设置账号" required="required" oninput="if(value.length>25)value=value.slice(0,25)" onkeyup="value = value.replace(/([^0-9A-z\u4e00-\u9fa5]|[\^\_])/g,'')">
			</div>
			<div class="inputbox">
				<span>密码：</span>
				<input type="password" name="UserPwd" placeholder="请设置密码" required="required" oninput="if(value.length>25)value=value.slice(0,25)" onkeyup="value = value.replace(/([^0-9A-z\u4e00-\u9fa5]|[\^\_])/g,'')">
			</div>
			<div class="inputbox">
				<span>邮箱：</span>
				<input type="email" name="UserEmail" placeholder="请输入邮箱" required="required" oninput="if(value.length>45)value=value.slice(0,45)" required pattern="^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$">
			</div>
			<div class="inputbox">
				<span>电话：</span>
				<input type="tel" name="UserPhone" placeholder="请输入电话号码" required="required" oninput="if(value.length>15)value=value.slice(0,15)" onkeyup="value=value.replace(/[^\d]/g,'')">
			</div>
			<div class="inputbox">
				<span>地址：</span>
				<input type="text" name="UserAdress" placeholder="请输入收货地址" required="required" oninput="if(value.length>45)value=value.slice(0,45)" onkeyup="value = value.replace(/([^0-9A-z\u4e00-\u9fa5]|[\^\_])/g,'')">
			</div>
			<div class="group">
				<a href="customer_or_store.jsp">返回上一页</a>
				<a href="login_customer.jsp">登录已有账号</a>
				<input type="submit" value="注册">
			</div>
		</div>	
	</section>
	</form>
	<jsp:include page="footer.jsp" />
</body>
</html>