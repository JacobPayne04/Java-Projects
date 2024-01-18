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
<form:form action="/books/process/new" method="post" modelAttribute="book">
<!-- DONT FORGET HIDDEN INPUT -->
<form:input type="hidden" path="user" value="${user_id}"/>
<a href="/books">back to the shelves</a>
		<div>
			<p>Title:</p>
			<form:input type="text" path="title"></form:input>
			<form:errors path="title" />
		</div>
		<div>
			<p>author :</p>
			<form:input type="text" path="author"></form:input>
			<form:errors path="author" />
		</div>
		<div>
			<p>Thoughts :</p>
			<form:input type="text" path="thoughts"></form:input>
			<form:errors path="thoughts" />
		</div>
		<input type="submit" value="Add Book" class="btn btn-primary" />
	</form:form>
</body>
</html>