<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
	<div>
		<h1 align="center">Student Information update</h1>
		<form action="save" method="get">
			<table align="center">
				<tr>
					<td><input type="hidden" value= "${student.id}" name="id" /></td>
				</tr>
				<tr>
					<td>Name :</td>
					<td><input type="text" value="${student.name}" name="name" /></td>
				</tr>
				<tr>
					<td>Roll Number :</td>
					<td><input type="text" value="${student.rollno}" name="rollno" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update"></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>