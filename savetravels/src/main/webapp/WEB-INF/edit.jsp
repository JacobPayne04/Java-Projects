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
	    <h1>Editing Travel Expense ${travel.id}</h1>
    <form:form action="/expenses/process/edit/${travel.id}" method="post" modelAttribute="travel">
    <input type="hidden" name="_method" value="PATCH">
        <div class="form-group">
            <p>Expense Name:</p>
            <form:input type="text" path="expense" class="form-control"></form:input>
            <form:errors path="expense" />
        </div>
        <div class="form-group">
            <p>Vendor:</p>
            <form:input type="text" path="vendor" class="form-control"></form:input>
            <form:errors path="vendor" />
        </div>
        <div class="form-group">
            <p>Amount:</p>
            <form:input type="number" path="amount" class="form-control"></form:input>
            <form:errors path="amount" />
        </div>
        <div class="form-group">
            <p>Description:</p>
            <form:input type="text" path="description" class="form-control"></form:input>
            <form:errors path="description" />
        </div>
        <input type="submit" value="Edit Travel" class="btn btn-primary" />
    </form:form>
</body>
</html>