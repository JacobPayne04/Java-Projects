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
<title>books</title>
</head>
<body>

    <h1><c:out value="${ oneBook.title}" /></h1>
    <a href="/books">back to the shelves</a>

    <p>
         <c:out value="${oneBook.user.userName}" /> read <c:out value="${ oneBook.title}"/> by <c:out value="${ oneBook.author}" />
    </p>
    <p>Here are <c:out value="${oneBook.user.userName}" /> thoughts:</p>
    
    <p><c:out value="${oneBook.thoughts}"/></p>
	<a href="/books">Go Back</a>
</body>
</html>