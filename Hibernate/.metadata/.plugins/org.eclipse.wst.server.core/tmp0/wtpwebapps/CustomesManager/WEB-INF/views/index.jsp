<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Cuso=tomer Manager</h1>
		<form method="get" action="search">
			<input type ="text" name ="keyword">
			<input type = "submit" name = "Search">
		</form>
	</div>
	<h1>${message}</h1>
</body>
</html>