<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main page</title>
</head>
<body>
	<h2 style="color:green; text-align:center;"> Login Successful </h2>
	<h2> Welcome, <%=session.getAttribute("empName") %>! </h2>
	
	<form action="ViewUsers" method="get" class="main-page-form">
		<input type="submit" value="View User details" class="center-button">
	</form>
	
	<form action="Logoutservlet" method="post" class="main-page-form">
		<input type="submit" value="Logout" class="logout-button">
	</form>
</body>
</html>