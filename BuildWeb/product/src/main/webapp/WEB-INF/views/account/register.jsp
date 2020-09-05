<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "s" uri = "http://www.springframework.org/tags" %>
<h2>Login</h2>
<h2>${message}</h2>
<form:form action="/account/register" method="post" modelAttribute="form" enctype="multipart/form-data">
	<div class="form-group">
		<label><s:message code="user.id"/></label>
		<form:input path ="id" class="form-control" readonly="true"/>
		<form:errors path="id"/>
	</div>
	<div class="form-group">
		<label><s:message code="user.pw"/></label>
		<form:input path ="password" class="form-control" />
		<form:errors path="password"/>
	</div>
	<div class="form-group">
		<label>FullName</label>
		<form:input path ="fullname" class="form-control" />
		<form:errors path="fullname"/>
	</div>
	<div class="form-group">
		<label>Email address</label>
		<form:input path ="email" class="form-control" />
		<form:errors path="email"/>
	</div>
	<div class="form-group">
		<label>Photo</label>
		<input type="file" name = "photo_file">
		<form:hidden path ="photo" class="form-control" />
	</div>
	<div class="form-group">
		<button class="btn btn-default">Register</button>
	</div>
</form:form>