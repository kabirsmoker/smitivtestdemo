<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Student List</h1>
	<table align="center">
		<c:forEach items="${stdList}" var="std" varStatus="loopCounter">
			<tr>
				<td>${std.id}</td>
				<td>${std.name}</td>
				<td>${std.rollno}</td>
				<td><a href="pfUpdate?id=${std.id}">edit</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>