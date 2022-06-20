<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create an Account</title>
</head>
<body>
<h3>Create Account:</h3>
<form action="CreateAccountController">
	Username: <input type="text" placeholder="Enter Username" name="usrname"/><br/><br/>
	Password: <input type="text" placeholder="Enter Password" name="password"/><br/><br/>
	Phone Number: <input type="text" placeholder="Enter Phone Number" name="phone"/><br/><br/>
	Email: <input type="email" placeholder="Enter Email" name="email"/><br/><br/>
	Address: <input type="text" placeholder="Enter Address" name="address"/><br/><br/>
	<input type="submit" value="Submit"/>&nbsp;&nbsp;<input type="reset" value="Clear"/>
</form><br/>
<a href="Login.jsp">Go Back to Login Page</a>
</body>
</html>