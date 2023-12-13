<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>商家登录</title>
	<link href="css/headandfoot.css" type="text/css" rel="stylesheet"/>
	<link href="css/global.css" type="text/css" rel="stylesheet"/>
</head>
<body>

	<jsp:include page="header.jsp" />
	
	<script>
		var a='${msg}';
	</script>
	<c:if test="${!empty msg}"><script>alert(a);</script></c:if>
	
	<form action="login_store" method="post">
	
	<section>
		<div class="login">
			<h2>商家登录</h2>
			<div class="inputbox">
				<span>账号：</span>
				<input type="text" name="UserName" placeholder="请输入账号" required="required"  oninput="if(value.length>25)value=value.slice(0,25)" onkeyup="value = value.replace(/([^0-9A-z\u4e00-\u9fa5]|[\^\_])/g,'')">
			</div>
			<div class="inputbox">
				<span>密码：</span>
				<input type="password" name="UserPwd" placeholder="请输入密码" required="required"  oninput="if(value.length>25)value=value.slice(0,25)" onkeyup="value = value.replace(/([^0-9A-z\u4e00-\u9fa5]|[\^\_])/g,'')">
			</div>
			<div class="group">
				<a href="customer_or_store.jsp">返回上一页</a>
				<a href="register_store.jsp">注册新商家</a>
				<input type="submit" value="登录">
			</div>
		</div>	
	</section>
	</form>
	<jsp:include page="footer.jsp" />

</body>
</html>