<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BOOKSTORE</title>
</head>
<body>	
	<c:forEach var="b" items="${books}">
		<p>Title: ${b.title}</p>
		<p>Author: ${b.author}</p>
		<p>Description: ${b.description}</p>
		<p>Price: ${b.price}$</p>
		<form action="" method="POST">
			<input type="hidden" name="id" value="${b.id}">
			<input type="submit" value="Add to Shopping Cart">
		</form>
	</c:forEach>
</body>
</html>