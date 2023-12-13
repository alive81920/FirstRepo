<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>购物车</title>
	<link href="css/headandfoot.css" type="text/css" rel="stylesheet"/>
	<link href="css/global.css" type="text/css" rel="stylesheet"/>
	<link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript" src="js/confirm_msg.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />
<jsp:include page="userheader.jsp" />
	<c:if test="${empty user }"><%response.sendRedirect("index.jsp"); %></c:if>
	<script>var a='${msg}';</script>
	<c:if test="${!empty msg}"><script>alert(a);</script></c:if>
	<script type="text/javascript" src="js/confirm_msg.js"></script>
	<div class="usercenter">
		<ul>
			<li><a href="select_all_order_by_customer">全部订单</a></li>
			<li><a href="select_nopay_order">未支付订单</a></li>
			<li><a href="select_store_noconfirm">商家未确认发货订单</a></li>
			<li><a href="select_customer_noconfirmrecive">未确认收货的订单</a></li>
		</ul>
		<br>
		<table class="tabletolist">
			<tr>
				<th width="10%">名称</th>
				<th width="30%">图片</th>
				<th width="10%">数量</th>
				<th width=“10%”>总价</th>
				<th width="25%">操作</th>
		</tr>
		<c:forEach items="${p.list }" var="g">
			<tr>
				<td><p><a>${g.getGoodName()}</a></p></td>
				<td><p><img src=".${g.getGoodImage()}" width="100px" height="100px"></p></td>
				<td><p>${g.getAmount()}</p></td>
				<td><p>${g.getTotal()}</p></td>
				<td>
					<a class="btn btn-success" <c:if test="${g.getPaystatus()>0}">disabled</c:if> href="get_modify_order?ID=${g.getID()}&&op=1">支付</a>
					<a class="btn btn-success" <c:if test="${g.getOrderstatus()!=2}">disabled</c:if> href="get_modify_order?ID=${g.getID()}&&op=2">确认收货</a>
					<a class="btn btn-success" <c:if test="${g.getOrderstatus()>0}">disabled</c:if> href="get_modify_order?ID=${g.getID()}&&op=3">修改</a>
					<a class="btn btn-danger" <c:if test="${g.getOrderstatus()>0}">disabled</c:if> href="#" onclick="is_delete(${g.getID()})">删除</a>
				</td>
			</tr>
		</c:forEach>
		</table>
		<br>
		<jsp:include page="Page.jsp">
			<jsp:param value="select_customer_noconfirmrecive" name="url"/>
		</jsp:include>
	</div>
</body>
</html>