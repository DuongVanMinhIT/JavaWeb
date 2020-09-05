<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h2>Change password</h2>
<h2>${message}</h2>
<form action="/account/forgot" method="post">
	<div class="form-group">
		<label>Username</label>
		<input name ="id" class="form-control" >
	</div>
	<div class="form-group">
		<label>Current password</label>
		<input name ="pw" class="form-control" >
	</div>
	<div class="form-group">
		<label>new Confirm</label>
		<input name ="pw1" class="form-control" >
	</div>
	<div class="form-group">
		<label>new Confirm Password</label>
		<input name ="pw2" class="form-control" >
	</div>
	<div class="form-group">
		<button class="btn btn-default">Change</button>
	</div>
</form>