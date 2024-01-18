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
<title>Travel</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Expenses</th>
				<th>Vendor</th>
				<th>Amount</th>
			</tr>
		</thead>
		<c:forEach items="${AllTravel}" var="travel">
            <tbody>
                <tr> <td><a href="/expenses/show/${travel.id}"><c:out value="${travel.expense}" /></a></td>
                    <td><c:out value="${travel.expense}" /></td>
                    <td><c:out value="${travel.vendor}" /></td>
                    <td><c:out value="${travel.amount}" /></td>
                   <td><a class="btn btn-outline-warning"
						href="/expenses/edit/${travel.id}">Edit</a> <form action="/expenses/delete/${travel.id}" method="post">
						<input type="hidden" name="_method" value="delete"> <input
							class="btn btn-outline-danger" type="submit" value="Delete">
					</form></td>
                </tr>
            </tbody>
        </c:forEach>
	</table>
	<form:form action="expenses/process/new" method="post"
		modelAttribute="travel">
		<div>
			<p>Expense Name :</p>
			<form:input type="text" path="expense"></form:input>
			<form:errors path="expense" />
		</div>
		<div>
			<p>Vendor:</p>
			<form:input type="text" path="vendor"></form:input>
			<form:errors path="vendor" />
		</div>
		<div>
			<p>amount :</p>
			<form:input type="number" path="amount"></form:input>
			<form:errors path="amount" />
		</div>
		<div>
			<p>Description :</p>
			<form:input type="text" path="description"></form:input>
			<form:errors path="description" />
		</div>
		<input type="submit" value="Add Travel" class="btn btn-primary" />
	</form:form>
</body>
</html>