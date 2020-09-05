<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="home/index">Home</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">quan ly <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/admin/category/index" >loai</a></li>
							<li><a href="/admin/product/index">san pham</a></li>
							<li><a href="/admin/customer/index">khach hang</a></li>
							<li><a href="/admin/Order/index">don hang</a></li>
						</ul>	
			</li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">thong ke <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/admin/inventoty/index" >ton kho</a></li>
							<li><a href="/admin/revenue/category">doanh so theo loai</a></li>
							<li><a href="/admin/revenue/customer">doanh so theo khach hang</a></li>
							<li><a href="/admin/revenue/year">doanh so theo nam</a></li>
							<li><a href="/admin/revenue/quarter">doanh so theo quy</a></li>
							<li><a href="/admin/revenue/month">doanh so theo thang</a></li>
						</ul>	
			</li>
			<li><a href="/home/feedback">tai khoan</a></li>
			<li><a href="/home/faq">FAQ</a></li>
			
		 </ul>
	</div>
</nav>