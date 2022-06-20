<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h3>Login:</h3>
<form action="LoginController">
	Username: <input type="text" placeholder="Enter Username" name="usrname"/><br/><br/>
	Password: <input type="password" placeholder="Enter Password" name="password"/><br/><br/>
	<input type="checkbox" value="admin" name="admin"/> Admin<br/><br/>
	<input type="submit" value="Login"/>
</form><br/>
<a href="Create_Account.jsp">Don't have a account?Register</a>
</body>
</html>