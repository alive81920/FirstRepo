<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>发生了一个错误</title>
	<link href="css/headandfoot.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="header.jsp" />
	<script>var a='${msg}';</script>
	<c:if test="${!empty msg}"><script>alert(a);</script></c:if>

<jsp:include page="footer.jsp" />
</body>
</html>