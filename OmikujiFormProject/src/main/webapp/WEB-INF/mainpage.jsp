
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
	<h1>Send an Omikuji</h1>
	<form action="/omikuji/process" method="POST">
		<label for="">pick any number from 5 to 254</label>
		<input type="number" name="number"><br>
		
		<label for="">Enter the name of any city</label>
		<input type="text" name="city"><br>
		
		<label for="">Enter the name of any real person</label>
		<input type="text" name="name"><br>
		
		<label for="">Enter professional endeavor or hobby</label>
		<input type="text" name="hobby"><br>
		
		<label for="">Enter any type of living thing</label>
		<input type="text" name="living" ><br>
		
		<label for="">say something nice to someone</label>
		<input type="text" name="nice"><br>
		
		<p>send and show a friend</p><br>
		<button type="submit" >Send</button>
	</form>
</body>
</html>