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
	<script type="text/javascript" src="js/confirm_msg.js"></script>
	
	<ul><li class="box11seacher">
			<form action="select_an_good_by_admin" method="post">
			<input type="text" class="input11seacher" placeholder="请输入需要查找的账号登录名" name="searchname">
			<input type="submit" value="搜索" class="button11seacher">
			</form>
	</li></ul>
	
	<table class="tabletolist">
			<tr>
				<th width="5%">商品ID</th>
				<th width="5%">商家ID</th>
				<th width="10%">商品名字</th>
				<th width="30%">商品图片</th>
				<th width="5%">商品价格</th>
				<th width=“25%”>商品介绍</th>
				<th width="5%">商品库存</th>
				<th width="5%">商品季度销量</th>
				<th width="10%">操作</th>
			</tr>
		<c:forEach items="${p.list }" var="g">
			<tr>
				<td><p>${g.getGoodID()}</p></td>
				<td><p>${g.getID()}</p></td>
				<td><p>${g.getGoodName()}</p></td>
				<td><p><img src=".${g.getGoodImage()}" width="100px" height="100px"></p></td>
				<td><p>${g.getGoodPrice()}</p></td>
				<td><p>${g.getGoodIntrodution()}</p></td>
				<td><p>${g.getGoodStock()}</p></td>
				<td><p>${g.getGoodNum()}</p></td>
				<td>
					<a class="btn btn-danger" href="#" onclick="delete_good_by_ad(${g.getGoodID()})">下架</a>
				</td>
			</tr>
		</c:forEach>
		</table>
		<br>
		<jsp:include page="Page.jsp">
			<jsp:param value="select_all_good_by_admin" name="url"/>
		</jsp:include>
	
	

</body>
</html>