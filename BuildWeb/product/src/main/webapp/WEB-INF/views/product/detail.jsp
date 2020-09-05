<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix = "f"%>
<div class="row">
	<div class="col-sm-5">
		<img src="https://cdn.tgdd.vn/Products/Images/42/210644/iphone-11-128gb-green-600x600.jpg" width="300px"/>
	</div>
	<div class="col-sm-7">
		<ul class="detail-info">
			<li>Name:${product.name}</li>
			<li>unitPrice:<f:formatNumber value="${product.unitPrice}" pattern="#,###.00"/> VNĐ</li>
			<li>productDate:<f:formatDate value="${product.productDate}" pattern="dd-MM-yyyy"/></li>
			<li>category:${product.category.nameVN}</li>
			<li>quantity:${product.quantity}</li>
			<li>discount:<f:formatNumber value="${product.discount}" type="percent"/></li>
			<li>viewCount:${product.viewCount}</li>
			<li>available:${product.available ? 'Yes' : 'No'} </li>
			<li>special:${product.special ? 'Yes' : 'No'}</li>
        </ul>
	</div>
</div>


<div class="text-justify">${product.desctiption}</div>

<ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#tag1">Hang cung loai</a></li>
  <li><a data-toggle="tab" href="#tag2">Hang yeu thich</a></li>
  <li><a data-toggle="tab" href="#tag3">da xem</a></li>
</ul>
<div class="tab-content">
  <div id="#tag1" class="tab-pane fade in active">
    <c:forEach var="p" items="${list}">
      <a href="/product/detail/${p.id}">
        <img class="thumb-img" src="https://cdn.tgdd.vn/Products/Images/42/210644/iphone-11-128gb-green-600x600.jpg" alt="Lights" style="width:100%">
       </a>
</c:forEach> 
  </div>
  <div id="#tag2" class="tab-pane fade">
    <c:forEach var="favo" items="${favoList}">
      <a href="/product/detail/${favo.id}">
        <img class="thumb-img" src="https://cdn.tgdd.vn/Products/Images/42/210644/iphone-11-128gb-green-600x600.jpg" alt="Lights" style="width:100%">
       </a>
</c:forEach>
  </div>
  <div id="#tag3" class="tab-pane fade">
    <c:forEach var="view" items="${viewed_list }">
      <a href="/product/detail/${view.id}">
        <img class="thumb-img" src="https://cdn.tgdd.vn/Products/Images/42/210644/iphone-11-128gb-green-600x600.jpg" alt="Lights" style="width:100%">
       </a>
</c:forEach>
  </div>
</div>

<h3></h3>




