<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h2>forgot password</h2>
<h2>${message}</h2>
<form action="/account/forgot" method="post">
	<div class="form-group">
		<label>Username</label>
		<input name ="id" class="form-control" >
	</div>
	<div class="form-group">
		<label>email</label>
		<input name ="email" class="form-control" >
	</div>
	<div class="form-group">
		<button class="btn btn-default">retrive password</button>
	</div>
</form>