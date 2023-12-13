<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>后台管理</title>
	<link href="css/headandfoot.css" type="text/css" rel="stylesheet"/>
	<link href="css/global.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<c:if test="${tpye_admin==0}"><jsp:include page="admin0header.jsp" /></c:if>
<c:if test="${tpye_admin==1}"><jsp:include page="admin1header.jsp" /></c:if>
	<c:if test="${empty admin }"><%response.sendRedirect("login_admin.jsp"); %></c:if>
	<script>var a='${msg}';</script>
	<c:if test="${!empty msg}"><script>alert(a);</script></c:if>
	
	<ul class="yyydec">
		<li style="width:100%"><h1 style="margin:10%;color:red;font-size:90px;font-weight:bold;text-align:center;padding: 14px 16px;">欢迎来到后台管理系统!</h1></li>
	</ul>

</body>
</html>