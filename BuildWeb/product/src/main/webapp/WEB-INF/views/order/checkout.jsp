<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<h2>Checkout</h2>
<h4>${message}</h4>
<table class="table">
<thead>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Unit Price</th>
    <th>Discount</th>
    <th>Quantity</th>
    <th>Amount</th>
  </tr>
</thead>  
<tbody>
<c:forEach var="p" items="${sessionScope['scopedTarget.cartService'].itmes}">
 	<tr>
 	  <td >${p.id}</td>
      <td>${p.name}</td>
      <td>${p.unitPrice}</td>
      <td>${p.discount}</td>
      <td>${p.quantity}</td>
      <td >${p.quantity * p.unitPrice *(1 - p.discount)}</td>
    </tr>
</c:forEach>
</tbody>	
</table>
<form:form action="/order/checkout" method="post" modelAttribute="order">
	<div class="form-group">
		<label>Customer</label>
		<form:input path ="customer.id" class="form-control" readonly="true"/>
	</div>
		
	<div class="form-group">
		<label>Order Date</label>
		<form:input path ="orderDate" class="form-control" />
	</div>
	<div class="form-group">
		<label>Shipping address</label>
		<form:input path ="address" class="form-control" />
	</div>
	<div class="form-group">
		<label>Total Amount</label>
		<form:input path ="amount" class="form-control" />
	</div>
	<div class="form-group">
		<label>Notes</label>
		<form:textarea path ="description" class="form-control" rows="3" />
	</div>
	<div class="form-group">
		<button class="btn btn-default">Register</button>
	</div>
</form:form>
