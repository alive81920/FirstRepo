<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>修改个人信息</title>
	<link href="css/headandfoot.css" type="text/css" rel="stylesheet"/>
	<link href="css/global.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript" src="js/confirm_msg.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />
<jsp:include page="storeheader.jsp" />
	<c:if test="${empty user }"><%response.sendRedirect("index.jsp"); %></c:if>
	<script>var a='${msg}';</script>
	<c:if test="${!empty msg}"><script>alert(a);</script></c:if>
	
	<div class="usercenter">
		<form action="motify_store" method="post">
	<section>
		<div class="login">
			<h2>修改个人信息</h2>
			<div class="inputbox">
				<p>将需要修改的信息删去填上新的信息，然后点击“提交修改”即可</p>
				<span>账号：</span>
				<input type="text" name="UserName" value="${user.getUserName() }" placeholder="请设置账号" required="required" oninput="if(value.length>25)value=value.slice(0,25)" onkeyup="value = value.replace(/([^0-9A-z\u4e00-\u9fa5]|[\^\_])/g,'')">
			</div>
			<div class="inputbox">
				<span>密码：</span>
				<input type="password" name="ReUserPwd" value="${user.getUserPwd() }" placeholder="请设置密码" required="required" oninput="if(value.length>25)value=value.slice(0,25)" onkeyup="value = value.replace(/([^0-9A-z\u4e00-\u9fa5]|[\^\_])/g,'')">
			</div>
			<div class="inputbox">
				<span>确认密码：</span>
				<input type="password" name="UserPwd" value="${user.getUserPwd() }" placeholder="请设置密码" required="required" oninput="if(value.length>25)value=value.slice(0,25)" onkeyup="value = value.replace(/([^0-9A-z\u4e00-\u9fa5]|[\^\_])/g,'')">
			</div>
			<div class="inputbox">
				<span>邮箱：</span>
				<input type="email" name="UserEmail" value="${user.getUserEmail() }" placeholder="请输入邮箱" required="required" oninput="if(value.length>45)value=value.slice(0,45)"required pattern="^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$">
			</div>
			<div class="inputbox">
				<span>电话：</span>
				<input type="tel" name="UserPhone" value="${user.getUserPhone() }" placeholder="请输入电话号码" required="required" oninput="if(value.length>15)value=value.slice(0,15)" onkeyup="value=value.replace(/[^\d]/g,'')">
			</div>
			<div class="inputbox">
				<span>地址：</span>
				<input type="text" name="UserAdress" value="${user.getUserAdress() }" placeholder="请店家收货地址" required="required" oninput="if(value.length>45)value=value.slice(0,45)" onkeyup="value = value.replace(/([^0-9A-z\u4e00-\u9fa5]|[\^\_])/g,'')">
			</div>
			<div class="group">
				<input type="submit" value="提交修改">
			</div>
		</div>	
	</section>
	</form>
	</div>


<jsp:include page="footer.jsp" />
</body>
</html>