<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <link href="css/headandfoot.css" type="text/css" rel="stylesheet"/>
	<link href="css/global.css" type="text/css" rel="stylesheet"/>
	<title>WebShopping</title>
</head>

<body>
	<jsp:include page="header.jsp" />
	
	<script>
		var a='${msg}';
	</script>
	<c:if test="${!empty msg}"><script>alert(a);</script></c:if>
	<script type="text/javascript" src="js/confirm_msg.js"></script>
	
	
	<div class="col-md-12 product-model-sec">

            <c:forEach items="${p.list}" var="g">
                <ul style="text-decoration: none;list-style-type: none;dispplay:flex;margin-left: 35%;">
                	<li style="text-decoration: none;">
                		<img src=".${g.getGoodImage()}" width="400px" height="400px">
                	</li>
                	<li style="text-decoration: none;">
                		<a style="font-size: 25px;text-decoration: none;text-align: center;">${g.getGoodName()}</a>
                	</li>
                	<li style="text-decoration: none;">
                		<a style="font-size: 20px;color:red;text-decoration: none;text-align: center;">￥${g.getGoodPrice()}元</a>
                	</li>
                	<li style="text-decoration: none;"><div class="listchoose">
                		<a href="good_details?ID=${g.getID()}&&GoodName=${g.getGoodName()}" target="_blank">商品详情</a>
                		<a href="add_order?ID=${g.getID()}&&GoodName=${g.getGoodName()}" target="_blank">加入购物车</a>
                	</div></li>
                </ul>
                <br>
            </c:forEach>

        </div>
	
	<jsp:include page="Page.jsp">
	<jsp:param name="url" value="select_good_in_all"></jsp:param>
    </jsp:include>
	
</body>