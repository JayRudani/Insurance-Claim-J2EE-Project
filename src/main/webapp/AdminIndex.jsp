<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
<% String name = (String)request.getAttribute("username"); // Read the table value here %>
<h2>Hii <%= name %></h2>
<a href="AdminController?condition=allUser">See all User</a><br/><br/>
<a href="AdminController?condition=allProducts">See all Available Product</a><br/><br/>
<a href="Login.jsp">Logout</a>
</body>
</html>