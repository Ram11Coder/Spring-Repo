<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit location</title>
</head>
<body>

	<form action="updateLoc" method="post">
		id <input type="text" name="id" value="${location.id}" readonly><br>
		code<input type="text" name="code" value="${location.code}"><br>
		name <input type="text" name="name" value="${location.name}"><br>
		Type:<br>urban<input type="radio" name="type" value="URBAN"
			${location.type=='URBAN'?'checked':''}> rural<input
			type="radio" name="type" value="RURAL"
			${location.type=='RURAL'?'checked':''}><br> <input
			type="submit" value="save">
	</form>
</body>
</html>