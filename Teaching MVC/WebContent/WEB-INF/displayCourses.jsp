<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DISPLAYING COURSES</title>
</head>
<body>
	<c:if test="${not empty message}">
		<script>alert("Error: ${message}")</script>
	</c:if>
	
	<h2>Courses of Professor No: ${profNo}</h2>
	<c:forEach var="c" items="${courses}">
		<p>Course No: ${c.courseNo}</p>
		<p>Course Name: ${c.courseName}</p>
		<form action="" method="POST">
			<input type="hidden" name="profNo" value="${profNo}">
			<input type="hidden" name="courseNo" value="${c.courseNo}">			
			<input type="submit" name="delete" value="Delete">
		</form>
		<br>
	</c:forEach>
	
	<form action="" method="POST">
		<input type="hidden" name="profNo" value="${profNo}">
		<input type="text" name="courseNo" placeholder="courseNo">	
		<input type="submit" name="add" value="Add New Course">
	</form>
	
	<p style="text-align:center">Click <a href="Controller">here</a> to return to home page</p>
</body>
</html>