<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Document Upload</title>
</head>
<body>
	<h2>Document Upload</h2>

	<form method="post" action="upload" enctype="multipart/form-data">
		Id :<input type="text" name="id"> <br> Document upload:<input
			type="file" name="document"> <br> <input type="submit"
			name="submit" value="uplaod">

	</form>
<br>
	<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>link</th>
		</tr>

		<c:forEach items="${documents }" var="document">
			<tr>
				<td>${document.id }</td>
				<td>${document.name }</td>
				<td> <a href="download?id=${document.id}">download</a></td>
			</tr>

		</c:forEach>

	</table>
</body>
</html>