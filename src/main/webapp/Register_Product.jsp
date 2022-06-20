<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Product</title>
</head>
<body>
 
<h3>Register Product:</h3>
<form action="RegisterProductController">
	<input type="hidden" placeholder="Enter Username" name="usrname" value="${param.username}"/><br/><br/>
	Product Name: <c:out value="${param.selectList}" escapeXml="false"/><br/><br/>
	<!--  Product Name: <input type="text" placeholder="Enter Product Name" name="productname"/><br/><br/>-->
	Serial Number: <input type="text" placeholder="Enter Serial Number" name="serialno"/><br/><br/>
	Purchase Date: <input type="date" placeholder="Enter Purchase Date" name="purchasedate"/><br/><br/>
	<input type="submit" value="Submit"/>&nbsp;&nbsp;<input type="reset" value="Clear"/>
</form>
</body>
</html>