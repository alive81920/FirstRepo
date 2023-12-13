<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>用户中心</title>
	<link href="css/headandfoot.css" type="text/css" rel="stylesheet"/>
	<link href="css/global.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="header.jsp" />
<c:if test="${tpye_user.equals('customer')}"><jsp:include page="userheader.jsp" /></c:if>
<c:if test="${tpye_user.equals('store')}"><jsp:include page="storeheader.jsp" /></c:if>
	<c:if test="${empty user }"><%response.sendRedirect("index.jsp"); %></c:if>
	<script>var a='${msg}';</script>
	<c:if test="${!empty msg}"><script>alert(a);</script></c:if>

<div class = "usercenter">
	<ul class="yyydec">
		<li style="width:100%"><h1 style="margin:10%;color:red;font-size:90px;font-weight:bold;text-align:center;padding: 14px 16px;">欢迎来到用户中心!</h1></li>
		<li style="width:100%"><a style="color:black;font-size:40px;font-weight:bold;text-align:center;margin:10%;text-decoration: none;display: block;">快来开启购物旅程吧!</a></li>
	</ul>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>