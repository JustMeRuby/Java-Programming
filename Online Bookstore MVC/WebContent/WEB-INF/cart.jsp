<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SHOPPING CART</title>
</head>
<body>
	<c:forEach var="i" items="${items}">
		<c:if test = "${i.quantity > 0}">
			<p>Item ID: ${i.id}</p>
			<p>Description: ${i.title}</p>
			<p>Unit Cost: ${i.price}$</p>
			<form action="" method="POST">
				<input type="hidden" name="id" value="${i.id}">
				Quantity: <input type="number" name="quantity" value="${i.quantity}">
				<input type="submit" name="update" value="Update">
			</form>
			<p>Total Cost: ${i.price * i.quantity}$</p><br>
		</c:if>
	</c:forEach>
	<p style="text-align:center">Click <a href="Controller">here</a> to return to home page</p>
</body>
</html>