<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>查看全部商品</title>
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
			<li><a href="select_good_by_store">全部商品</a></li>
			<li><a href="select_all_good_by_store_stock">库存状态排序</a></li>
			<li><a href="select_good_by_store_num">热销商品</a></li>
			<li class="box11seacher">
				<form action="select_good_in_store?ID=${user.getID()}" method="post">
				<input type="text" class="input11seacher" name="searchgood">
				<input type="submit" value="搜索" class="button11seacher">
				</form>
			</li>
			<li style="float:right"><a href="add_good.jsp" class="active">添加商品</a></li>
		</ul>
		<br>
		<table class="tabletolist">
			<tr>
				<th width="10%">名称</th>
				<th width="25%">图片</th>
				<th width="10%">价格</th>
				<th width="20%">介绍</th>
				<th width=“10%”>库存</th>
				<th width="10%">季度销量</th>
				<th width="15%">操作</th>
		</tr>
		<c:forEach items="${p.list }" var="g">
			<tr>
				<td><p><a href="good_details?ID=${g.getID()}&&GoodName=${g.getGoodName()}" target="_blank">${g.getGoodName()}</a></p></td>
				<td><p><img src=".${g.getGoodImage()}" width="100px" height="100px"></p></td>
				<td><p>${g.getGoodPrice()}</p></td>
				<td><p>${g.getGoodIntrodution()}</p></td>
				<td><p>${g.getGoodStock()}</p></td>
				<td><p>${g.getGoodNum()}</p></td>
				<td>
					<a class="btn btn-success" href="get_modify_good?ID=${g.getID()}&&GoodName=${g.getGoodName()}">修改</a>
					
					<a class="btn btn-danger" href="#" onclick="delect_good(${g.getGoodID()})">下架</a>
				</td>
			</tr>
		</c:forEach>
		</table>
		<br>
		<jsp:include page="Page.jsp">
			<jsp:param value="select_good_by_store" name="url"/>
		</jsp:include>
	</div>
</body>
</html>