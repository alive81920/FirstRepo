<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<div class="menu">
	<ul>
		<li><a href="index_good">首页</a></li>
		<li><a href="select_good_by_num">畅销</a></li>
		<li><a href="select_good_by_createtime">新品</a></li>
		<li class="box11seacher">
				<form action="select_good_in_all" method="post">
				<input type="text" class="input11seacher" name="searchgood">
				<input type="submit" value="搜索" class="button11seacher">
				</form>
		</li>
		<c:choose>
			<c:when test="${user == null }">
				<li style="float:right"><a href="customer_or_store.jsp">登录/注册</a></li>
			</c:when>
			<c:otherwise>
				<li style="float:right"><a href="user_center.jsp" >欢迎：${user.getUserName()}</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
