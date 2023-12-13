<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript" src="js/confirm_msg.js"></script>
<div class="uss">
	<ul>
		<li><a href="index_admin.jsp">管理员：${admin.getUserName()}</a></li>
		<li><a href="select_all_customer_by_admin">顾客</a></li>
		<li><a href="select_all_store_by_admin">商家</a></li>
		<li><a href="select_all_good_by_admin">商品</a></li>
		<li style="float:right"><a href="#" onclick="logout_admin()">退出登录</a></li>
	</ul>
</div>