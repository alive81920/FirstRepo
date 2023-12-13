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
	
	
	<ul><li class="box11seacher">
			<form action="select_an_store_by_admin" method="post">
			<input type="text" class="input11seacher" placeholder="请输入需要查找的账号登录名" name="searchname">
			<input type="submit" value="搜索" class="button11seacher">
			</form>
	</li></ul>
	<script type="text/javascript" src="js/confirm_msg.js"></script>
	<table class="tabletolist">
			<tr>
				<th width="10%">ID</th>
				<th width="10%">登录名</th>
				<th width="10%">密码</th>
				<th width="10%">邮箱</th>
				<th width=“10%”>电话</th>
				<th width="20%">地址</th>
				<th width="10%">操作</th>
			</tr>
		
		<c:forEach items="${p.list }" var="g">
			<tr>
				<td><p>${g.getID()}</p></td>
				<td><p>${g.getUserName()}</p></td>
				<td><p>${g.getUserPwd()}</p></td>
				<td><p>${g.getUserEmail()}</p></td>
				<td><p>${g.getUserPhone()}</p></td>
				<td><p>${g.getUserAdress()}</p></td>
				<td>
					<a class="btn btn-danger" href="#" onclick="delete_store_by_ad(${g.getID()})">注销</a>
				</td>
			</tr>
		</c:forEach>
		</table>
		<br>
		<jsp:include page="Page.jsp">
			<jsp:param value="select_all_store_by_admin" name="url"/>
		</jsp:include>
	
	

</body>
</html>