<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>注册/登录</title>
	<link href="css/headandfoot.css" type="text/css" rel="stylesheet"/>
	<link href="css/global.css" type="text/css" rel="stylesheet"/>
</head>
<body>
	<jsp:include page="header.jsp" />
	<section>
		<div class="login">
			<h2>注册/登录</h2>
			<div class="listchoose">
				<a href="register_customer.jsp">用户注册</a>
				<a href="login_customer.jsp">用户登录</a>
				<a href="register_store.jsp">商家注册</a>			
				<a href="login_store.jsp">商家登录</a>
			</div>
		</div>
	</section>
	<jsp:include page="footer.jsp" />
</body>
</html>