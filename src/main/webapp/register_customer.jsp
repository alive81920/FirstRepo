<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>

<head>
	<meta charset="UTF-8">
	<title>用户登录</title>
	<link href="css/header.css" type="text/css" rel="stylesheet"/>
	<link href="css/footer.css" type="text/css" rel="stylesheet"/>
</head>

<body>
	<jsp:include page="header.jsp" />
	
	<fieldset>
	<legend>用户注册</legend>
	<form action="#" method="post">
	<table cellpadding="2" align="center">
		<tr>
		<td align="left">账号:</td>
		<td><input type="text" name="UserName" /></td>
		</tr>
	</table>
	</form>	
	</fieldset>

	<jsp:include page="footer.jsp" />
</body>
</html>