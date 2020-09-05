<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<h2 class="alert alert-success">Inventory</h2>
<table class="table">
	<thead>
		<tr>
			<th>category</th>
			<th>quantity</th>
			<th>value</th>
			<th>Min</th>
			<th>Max</th>
			<th>AVG</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="e" items="${data}">
			<tr>
				<td>$<f:formatNumber value="${e[0]}" pattern="#,###" /></td>
				<td>${e[1]}</td>
				<td>$<f:formatNumber value="${e[2]}" pattern="#,###.00" /></td>
				<td>$<f:formatNumber value="${e[3]}" pattern="#,###.00" /></td>
				<td>$<f:formatNumber value="${e[4]}" pattern="#,###.00" /></td>
				<td>$<f:formatNumber value="${e[5]}" pattern="#,###.00" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jsp:include page="inventoryCustomerChart.jsp"/>