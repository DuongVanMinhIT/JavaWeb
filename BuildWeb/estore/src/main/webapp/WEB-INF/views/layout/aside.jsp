<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="panel panel-default">
	<div class="panel-heading">Shopping Cart</div>
	<div class="panel-body">
		<img src="/static/images/supermarket.png" class="col-sm-5">
		<ul class="col-sm-7">
			<li>10 mathang</li>
			<li>10 mathang</li>
			<li>
				<a href="">xem gio hang</a>
			</li>
		</ul>
	</div>
</div>
	
<div class="panel panel-default">
	<div class="panel-heading">Tìm kiếm</div>
	<div class="panel-body">
		<form action="/product/search" method="post">
			<input name ="keywords" class="form-control" placeholder ="keywords">
		</form>
	</div>
</div>	
<div class="panel panel-default">
	<div class="panel-heading">Danh Muc</div>
	<div class="list-group">
		<c:forEach var="c" items="${category}">
		<a href="#" class="list-group-item">${c.NameVN}</a></c:forEach>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-heading"> Đặc Biệt</div>
	<div class="list-group">
		<a href="#" class="list-group-item">hàng mới</a> 
		<a href="#" class="list-group-item">bán chạy</a>
		<a href="#" class="list-group-item">yêu thích</a>
		<a href="#" class="list-group-item">giảm giá</a>
	</div>
</div>