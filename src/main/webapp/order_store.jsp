<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>订单管理</title>
	<link href="css/headandfoot.css" type="text/css" rel="stylesheet"/>
	<link href="css/global.css" type="text/css" rel="stylesheet"/>
	<link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript" src="js/confirm_msg.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />
<jsp:include page="storeheader.jsp" />
	<c:if test="${empty user }"><%response.sendRedirect("index.jsp"); %></c:if>
	<script>var a='${msg}';</script>
	<c:if test="${!empty msg}"><script>alert(a);</script></c:if>
	
	<div class="usercenter">
		<ul>
			<li><a href="select_all_order_by_store">全部订单</a></li>
			<li><a href="select_no_confirm_in_store">未确认发货订单</a></li>
			<li><a href="select_customernoconfirmreceive_by_store">未确认收货的订单</a></li>
		</ul>
		<br>
		<table class="tabletolist">
			<tr>
				<th width="10%">名称</th>
				<th width="30%">图片</th>
				<th width="10%">数量</th>
				<th width=“10%”>总价</th>
				<th width=“10%”>买家电话</th>
				<th width=“10%”>买家地址</th>
				<th width="20%">操作</th>
		</tr>
		<c:forEach items="${p.list }" var="g">
			<tr>
				<td><p><a>${g.getGoodName()}</a></p></td>
				<td><p><img src=".${g.getGoodImage()}" width="100px" height="100px"></p></td>
				<td><p>${g.getAmount()}</p></td>
				<td><p>${g.getTotal()}</p></td>
				<td><p>${g.getUserPhone()}</p></td>
				<td><p>${g.getUserAdress()}</p></td>
				<td>
					<a class="btn btn-success" <c:if test="${g.getOrderstatus()!=1}">disabled</c:if> href="get_modify_order?ID=${g.getID()}&&op=5">确认发货</a>
				</td>
			</tr>
		</c:forEach>
		</table>
		<br>
		<jsp:include page="Page.jsp">
			<jsp:param value="select_all_order_by_store" name="url"/>
		</jsp:include>

	</div>
</body>
</html>