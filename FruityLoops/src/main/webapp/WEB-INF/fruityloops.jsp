<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table>
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<tr>
			<c:forEach items="${listofFruitsFromController}" var="fruit">
					<td><c:out value="${fruit.name}"/></td>
					<td><c:out value="${fruit.price}"/></td>
				</c:forEach>
			</tr>
		</table>

	</div>
</body>
</html>