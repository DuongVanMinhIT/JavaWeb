<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h2>Edit profile</h2>
<h2>${message}</h2>
<form:form action="/account/edit" method="post" modelAttribute="form" enctype="multipart/form-data">
	<div class="form-group">
		<label>Username</label>
		<form:input path ="id" class="form-control" readonly="true"/>
	</div>
		
	<div class="form-group">
		<label>FullName</label>
		<form:input path ="fullname" class="form-control" />
	</div>
	<div class="form-group">
		<label>Email address</label>
		<form:input path ="email" class="form-control" />
	</div>
	<div class="form-group">
		<label>Photo</label>
		<img alt="" src="/static/images/customers/${form.photo}" style="width:80px;height:90px">
		<input type="file" name = "photo_file">
		<form:hidden path ="photo" class="form-control" />
	</div>
	<div class="form-group">
		<button class="btn btn-default">Register</button>
	</div>
	<form:hidden path ="password" />
	<form:hidden path ="activated" />
	<form:hidden path ="admin" />
</form:form>