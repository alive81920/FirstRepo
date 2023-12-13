<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link href="css/headandfoot.css" type="text/css" rel="stylesheet"/>
	<link href="css/global.css" type="text/css" rel="stylesheet"/>
	<meta charset="UTF-8">
	<title>WebShopping</title>
</head>

<body>
	<jsp:include page="header.jsp" />
	
	<script>
		var a='${msg}';
	</script>
	<c:if test="${!empty msg}"><script>alert(a);</script></c:if>
	
	<ul class="yyydec">
		<li style="width:100%"><h1 style="margin:10%;color:red;font-size:90px;font-weight:bold;text-align:center;padding: 14px 16px;">欢迎来到WebShopping!</h1></li>
		<li style="width:100%"><a style="color:black;font-size:40px;font-weight:bold;text-align:center;margin:10%;text-decoration: none;display: block;">快来开启你的购物旅程吧!</a></li>
	</ul>

	<jsp:include page="footer.jsp" />
</body>