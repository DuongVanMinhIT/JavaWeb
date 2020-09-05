<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>Login</h2>
<h2>${message}</h2>
<form action="/account/login" method="post">
	<div class="form-group">
		<label>Username</label>
		<input name ="id" class="form-control" value="${uid}">
	</div>
	<div class="form-group">
		<label>pasword</label>
		<input name ="pw" class="form-control" value="${pwd}">
	</div>
	<div class="form-group">
			<label>Remember me?</label>
			
			<input name ="rm" type="checkbox">
			
		
	</div>
	<div class="form-group">
		<button class="btn btn-default">Login</button>
	</div>
</form>