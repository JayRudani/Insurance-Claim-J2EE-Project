<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All User</title>
</head>
<body>
<form action="SearchController">
	<input type="hidden" name="search" value="user"/>
	<input type="text" placeholder="Enter Username" name="username"/>
	<input type="submit" value="Search"/>
</form>
<% String table = (String)request.getAttribute("table"); // Read the table value here %>
<%= table %>
<a href="AdminIndex.jsp">Go Back</a>
</body>
</html>