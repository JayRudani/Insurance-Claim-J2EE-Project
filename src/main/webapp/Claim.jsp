<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${ param.claim != 0 }">
<h3>Claim Product Warranty:</h3>
<form action="ClaimController">
Claim Date: <input type="date" placeholder="Enter Claim Date" name="claimdate"/><br/><br/>
Write Detailed Description of the Incident/Issue:<br/><br/>
<textarea cols="35" rows="5" maxlength="100" placeholder="Maximum 100 Words" name="description"></textarea>
<input type="hidden"name="serno" value="${param.serialno}"/>
<input type="hidden"name="usrname" value="${param.username}"/><br/><br/>
<input type="submit" value="Submit"/>
</form>
</c:when>
<c:otherwise>
<c:redirect url="/Error.jsp"/>
</c:otherwise>
</c:choose>
</body>
</html>