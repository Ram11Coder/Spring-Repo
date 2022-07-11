<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Location</title>
</head>
<body>

	<form action="savelocation" method="post">
		id <input type="text" name="id"><br> code<input
			type="text" name="code"><br> name <input type="text"
			name="name"><br> type:urban<input type="radio"
			name="type" value="URBAN"> rural<input type="radio"
			name="type" value="RURAL"><br> <input type="submit"
			value="save">
	</form>
	${msg}
	<br>
	<a href="displayLocations">View All</a>
</body>
</html>