<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>修改商品信息</title>
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
		<form action="modify_good?GoodID=${g.getGoodID()}" method="post" enctype="multipart/form-data">
	<section>
		<div class="login">
			<h2>修改商品信息</h2>
			<p>将需要修改的信息删去填上新的信息，然后点击“提交修改”即可</p>
			<div class="inputbox">
				<span>名字：</span>
				<input type="text" name="GoodName" value="${g.getGoodName()}" required="required" oninput="if(value.length>25)value=value.slice(0,25)" onkeyup="value = value.replace(/([^0-9A-z\u4e00-\u9fa5]|[\^\_])/g,'')">
			</div>
			<div class="inputbox">
				<span>价格：</span>
				<input type="text" name="GoodPrice" value="${g.getGoodPrice()}" required="required" onkeyup="value=value.replace(/[^\-?\d.]/g,'')">
			</div>
			<div class="inputbox">
				<span>库存：</span>
				<input type="text" name="GoodStock" value="${g.getGoodStock()}" required="required" onkeyup="value=value.replace(/[^\d]/g,'')">
			</div>
			<div class="inputbox">
				<span>介绍：</span>
				<textarea name="GoodIntrodution" cols="50" rows="6" oninput="if(value.length>300)value=value.slice(0,300)" onkeyup="value = value.replace(/([^0-9A-z\u4e00-\u9fa5]|[\^\_])/g,'')">${g.getGoodIntrodution()}</textarea>
			</div>
			<div class="inputbox">
				<span>商品图片：</span>请上传图片,推荐大小≤5M
				<a>原图片：<img src=".${g.getGoodImage()}"  width="100px" height="100px"></a>
				<input type="file" name="GoodImage" accept="image/jpg,image/jpeg,image/png" onchange="checkfile(this)">
			</div>
			<div class="group">
				<input type="submit" value="提交修改">
			</div>
		</div>	
	</section>
	</form>
	</div>



</body>
</html>