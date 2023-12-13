<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>添加新管理员</title>
	<link href="css/headandfoot.css" type="text/css" rel="stylesheet"/>
	<link href="css/global.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<c:if test="${tpye_admin==0}"><jsp:include page="admin0header.jsp" /></c:if>
<c:if test="${tpye_admin==1}"><jsp:include page="admin1header.jsp" /></c:if>
	<c:if test="${empty admin }"><%response.sendRedirect("login_admin.jsp"); %></c:if>
	<script>var a='${msg}';</script>
	<c:if test="${!empty msg}"><script>alert(a);</script></c:if>
	
	<form action="register_admin" method="post">
	<section>
		<div class="login">
			<h2>注册新管理员</h2>
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
				<input type="email" name="UserEmail" placeholder="请输入邮箱" required="required" oninput="if(value.length>45)value=value.slice(0,45)"required pattern="^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$">
			</div>
			<div class="inputbox">
				<span>电话：</span>
				<input type="tel" name="UserPhone" placeholder="请输入电话号码" required="required" oninput="if(value.length>15)value=value.slice(0,15)" onkeyup="value=value.replace(/[^\d]/g,'')">
			</div>
			<div class="inputbox">
				<span>类型：</span>
				<input type="text" name="UserType" placeholder="请输入管理员类型" required="required" oninput="if(value.length>2)value=value.slice(0,2)" onkeyup="value=value.replace(/[^\d]/g,'')">
			</div>
			<div class="group">
				<input type="submit" value="注册">
			</div>
		</div>	
	</section>
	</form>
	<jsp:include page="footer.jsp" />
</body>
</html>