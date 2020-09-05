<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<div class="panel panel-default">
	<div class="panel-body">

		<form:form action="${base}/index" modelAttribute="entity" enctype="multipart/form-data">
			<div class="row">
				<div class="form-group col-sm-6">
					<label>Order id</label>
					<form:input path="id" class="form-control" />
				</div>
				<div class="form-group col-sm-6">
					<label>Customer</label>
					<form:input path="customer.id" class="form-control" />
				</div>
			</div>

			<div class="row">
				
				<div class="form-group col-sm-6">
					<label>Order Date</label>
					<form:input path="orderDate" class="form-control" />
				</div>
				<div class="form-group col-sm-6">
					<label>Shipping Address</label>
					<form:input path="address" class="form-control" />
				</div>
			</div>
			<div class="row">
				
				<div class="form-group col-sm-6">
					<label>Total Amount</label>
					<form:input path="amount" class="form-control" />
				</div>
				
			</div>
			<div class="row">
				<div class="form-group col-sm-12">
					<label>Description</label>
					<form:textarea path="description" class="form-control" rows="3" style="width: 100%;" />
				</div>
				<div class="form-group col-sm-12">
					<button class="btn btn-primary" formaction="${base}/create">Create</button>
					<button class="btn btn-warning" formaction="${base}/update">Update</button>
					<button class="btn btn-danger" formaction="${base}/delete">Delete</button>
					<a class="btn btn-default" href="${base}/index">Reset</a>
				</div>
			</div>

		</form:form>
		<c:if test ="${!empty details }">
			<jsp:include page="details.jsp"/>
		</c:if>
		
	</div>
</div>