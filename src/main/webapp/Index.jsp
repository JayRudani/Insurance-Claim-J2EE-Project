<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String name = (String)request.getAttribute("username"); // Read the username value here %>
<h2>Hii <%= name %></h2>
<h3>Your Registered Product:</h3>
<% String table = (String)request.getAttribute("table"); // Read the table value here %>
<%= table %>
<a href="AllProductNameController?username=<%= name %>">Register a New Product</a><br/><br/>
<!--  <a href="Register_Product.jsp?username=<%= name %>">Register a New Product</a><br/><br/>-->
<a href="Login.jsp">Logout</a>
</body>
</html>