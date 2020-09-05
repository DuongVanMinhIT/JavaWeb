<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Online Shopping Mall</title>
	<tiles:insertAttribute name="head"/>
</head>
<body>
	<div class="container">
		<header class="row">
			<h1 class="alert alert-succes">Administrator tool</h1>
		</header>
		<nav class="row">
			<tiles:insertAttribute name="menu"/>
		</nav>	
			<div class="row">
				<tiles:insertAttribute name="body"/>
			</div>
	
		<footer class="row">
			<p class="text-center">&copy;2019.All rights reserved.</p>
		</footer>
	</div>

</body>
</html>