<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<h2>order lsit</h2>
<table class="table">
<thead>
  <tr>
    <th>Id</th>
    <th>order Date</th>
    <th>address</th>
    <th>amont</th>
    <th></th>
  </tr>
</thead>  
<tbody>
<c:forEach var="o" items="${orders}">
 <tr>
 	  <td >${o.id}</td>
      <td>${o.orderDate}</td>
      <td>${o.address}</td>
      <td>${0.amount}</td>
      
      <td>
      	<a class="btn btn-sm btn-warning" href="/order/detail/${o.id}">Detail</a>
      </td>
    </tr>
</c:forEach>
</tbody>	
</table>
 