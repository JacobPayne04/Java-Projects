<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>One travel expense</h1>
	
	<p>Expense Name: <c:out value="${ oneTravel.expense}"/></p>
	<p>Expense description: <c:out value="${ oneTravel.description}"/></p>
	<p>vendor: <c:out value="${ oneTravel.vendor}"/></p>
	<p>Amount spent: <c:out value="${ oneTravel.amount}"/></p>
	
	
	<a href="/expenses">Go Back</a>
</body>
</html>