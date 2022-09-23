<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register page</title>
</head>
<body>
<form action="Servletdao" method="post"><br/>
EmpId<input type="number" name="empid"><br/>
EmpName<input type="text" name="empname"><br/>
EmpMail<input type="email" name="empmail"><br/>
<input type="submit" name="submit">
<input type="reset" name="reset">
</form>
</body>
</html>