<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>上传新商品</title>
	<link href="css/headandfoot.css" type="text/css" rel="stylesheet"/>
	<link href="css/global.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="header.jsp" />
<c:if test="${tpye_user.equals('store')}"><jsp:include page="storeheader.jsp" /></c:if>
	<c:if test="${empty user }"><%response.sendRedirect("index.jsp"); %></c:if>
	<script>var a='${msg}';</script>
	<c:if test="${!empty msg}"><script>alert(a);</script></c:if>
<script type="text/javascript" src="js/confirm_msg.js"></script>

	<div class="usercenter">
		<form action="add_good" method="post" enctype="multipart/form-data">
	<section>
		<div class="login">
			<h2>上传新商品</h2>
			<div class="inputbox">
				<span>名字：</span>
				<input type="text" name="GoodName" placeholder="请输入商品名字" required="required" oninput="if(value.length>25)value=value.slice(0,25)" onkeyup="value = value.replace(/([^0-9A-z\u4e00-\u9fa5]|[\^\_])/g,'')">
			</div>
			<div class="inputbox">
				<span>价格：</span>
				<input type="text" name="GoodPrice" placeholder="请设置商品价格" required="required" onkeyup="value=value.replace(/[^\-?\d.]/g,'')">
			</div>
			<div class="inputbox">
				<span>库存：</span>
				<input type="text" name="GoodStock" placeholder="请输入商品库存" required="required" onkeyup="value=value.replace(/[^\d]/g,'')">
			</div>
			<div class="inputbox">
				<span>介绍：</span>
				<textarea name="GoodIntrodution" cols="50" rows="6" placeholder="请输入商品简介" oninput="if(value.length>300)value=value.slice(0,300)" onkeyup="value = value.replace(/([^0-9A-z\u4e00-\u9fa5]|[\^\_])/g,'')"></textarea>
			</div>
			<div class="inputbox">
				<span>商品图片：</span>请上传图片,推荐大小≤5M
				<input type="file" name="GoodImage" accept="image/jpg,image/jpeg,image/png" required="required" onchange="checkfile(this)">
			</div>
			<div class="group">
				<input type="submit" value="提交修改">
			</div>
		</div>	
	</section>
	</form>
	</div>




<jsp:include page="footer.jsp" />
</body>
</html>