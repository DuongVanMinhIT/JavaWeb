<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<table class="table">
<thead>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Name VN</th>
    <th></th>  
  </tr>
</thead>  
<tbody>
<c:forEach var="e" items="${list}">
 <tr >
 	<td>${e.id}</td>
 	<td>${e.name}</td>
 	<td>${e.nameVN}</td>
     <td>
     	<a class="btn btn-sm btn-info" href="${base}/edit/${e.id}">edit</a>
     	<a class="btn btn-sm btn-danger" href="${base}/delete/${e.id}">Delete</a>
     </td>
    </tr>
</c:forEach>   
</tbody>	
</table>