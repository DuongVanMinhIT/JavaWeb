<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<h2>Oreder Info</h2>
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
<c:forEach var="d" items="${details}">
 <tr >
 	  <td >${d.product.id}</td>
      <td>${d.product.name}</td>
      <td>${d.unitPrice}</td>
      <td>${d.discount}</td>
      <td>${d.quantity}</td>
      <td >${d.quantity * d.unitPrice *(1 - d.discount)}</td>
    </tr>
</c:forEach>
</tbody>	
</table>
<form:form action="/order/checkout" modelAttribute="Order" enctype="multipart/form-data">
	<div class="form-group">
		<label>Customer</label>
		<form:input path ="id" class="form-control" readonly="true"/>
	</div>
	
	<div class="form-group">
		<label>Customer</label>
		<form:input path ="customer.id" class="form-control" readonly="true"/>
	</div>
		
	<div class="form-group">
		<label>Order Date</label>
		<form:input path ="orderDate" class="form-control" readonly="true"/>
	</div>
	<div class="form-group">
		<label>Shipping address</label>
		<form:input path ="address" class="form-control"readonly="true" />
	</div>
	<div class="form-group">
		<label>Total Amount</label>
		<form:input path ="amount" class="form-control" readonly="true"/>
	</div>
	<div class="form-group">
		<label>Notes</label>
		<form:textarea path ="description" class="form-control" rows="3" readonly="true"/>
	</div>
</form:form>
