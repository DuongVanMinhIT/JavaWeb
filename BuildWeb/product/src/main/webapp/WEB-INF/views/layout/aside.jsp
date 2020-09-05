<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "s" uri = "http://www.springframework.org/tags" %>
<c:set var="cart" value="${sessionScope['scopedTarget.cartService']}"/>
<div class="panel panel-default">
	<div class="panel-heading"><s:message code="lyt.cart.title"/></div>
	<div class="panel-body">
		<img id = "cart-img" src="/static/images/supermarket.png" class="col-sm-5">
		<ul class="col-sm-7">
			<li><b id ="cart-cnt">${cart.count}</b> mat hang</li>
			<li><b id = "cart-amt" >${cart.amount}</b> ngan dong</li>
			
			<li>
				<a href="/cart/view">xem gio hang</a>
			</li>
		</ul>
	</div>
</div>
	
<div class="panel panel-default">
	<div class="panel-heading">Tìm kiếm</div>
	<div class="panel-body">
		<form action="/product/list-by-keywords" method="post">
			<input name ="keywords" class="form-control" placeholder ="keywords">
		</form>
	</div>
</div>	
<div class="panel panel-default">
	<div class="panel-heading"><s:message code="lyt.cate.title"/></div>
	<div class="list-group">	
		<c:set value="${pageContext.response.locale.language}" var="lang"/>
		<c:forEach var="c" items="${cates}">
		
		<a href="/product/list-by-category/${c.id}" class="list-group-item">${lang =='vi'?c.nameVN:c.name}</a>
		</c:forEach>
		
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-heading"> Đặc Biệt</div>	
	<div class="list-group">
		<a href="/product/list-by-special/0" class="list-group-item">hàng mới</a> 
		<a href="/product/list-by-special/1" class="list-group-item">bán chạy</a>
		<a href="/product/list-by-special/2" class="list-group-item">Xem nhiều</a>
		<a href="/product/list-by-special/3" class="list-group-item">giảm giá</a>
	</div>
</div>

<style id = "cart-css">	
</style>


