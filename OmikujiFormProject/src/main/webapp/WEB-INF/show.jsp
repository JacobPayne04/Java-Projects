<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Here's Your Omikuji</h1>
	<p>In <c:out value = "${number}" /> years, you will live in <c:out value = "${city}" /> with <c:out value = "${name}" /> as your roomate, <c:out value = "${hobby}" /> for a living the next time you see a <c:out value = "${living}" /> you will have good luck Also, <c:out value = "${nice}" /></p>
	<br />
	
	<a href="/omikuji">Go Back</a>
</body>