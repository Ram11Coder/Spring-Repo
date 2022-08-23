<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee edit form</title>
</head>
<body>

	<h2>Employee correction Form :</h2>
	<!-- <pre> -->
	<form action="updateEmployee" method="post">
		id :<input type="text" name="id" value="${employee.id}" readonly><br>
		name :<input type="text" name="name" value="${employee.name}"><br>
		age : <input type="text" name="age" value="${employee.age}"><br>
		gender :Male <input type="radio" name="gender" value="MALE"
			${employee.gender=='MALE'?'checked':''}> Female <input
			type="radio" name="gender" value="FEMALE"
			${employee.gender=='FEMALE'?'checked':''}> Transgender <input
			type="radio" name="gender" value="TRANSGENDER"
			${employee.gender=='TRANSGENDER'?'checked':''}> <br>
		desigination :<input type="text" name="desigination"
			value="${employee.desigination}"> <br> <input
			type="submit" value="update">
	</form>
	<br>
	<!-- </pre> -->
</body>
</html>