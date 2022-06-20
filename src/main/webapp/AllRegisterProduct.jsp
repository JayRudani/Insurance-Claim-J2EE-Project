<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="SearchController">
	<input type="hidden" name="username" value="${ param.username }"/>
	<input type="hidden" name="search" value="registerProduct"/>
	<input type="text" placeholder="Enter Product Name" name="registerProduct"/>
	<input type="submit" value="Search"/>
</form>
<% String table = (String)request.getAttribute("table"); // Read the table value here %>
<%= table %>
<a href="AdminIndex.jsp">Go Back</a>
</body>
</html>