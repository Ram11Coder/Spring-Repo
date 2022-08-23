<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Creation</title>
</head>
<body>

<h2>Employee Creation Form :</h2>
<!-- <pre> -->
<form action="saveEmployess" method="post">
name :<input type="text" name="name"><br>
age : <input type="text" name="age"><br>
gender :Male <input type="radio" name="gender" value="MALE"> 
Female <input type="radio" name="gender" value="FEMALE"> 
Transgender <input type="radio" name="gender" value="TRANSGENDER"> <br>
desigination :<input type="text" name="desigination" >
<br>
<input type="submit" value="save">
</form>
<br>
<!-- </pre> -->
	
  ${msg}
  
  <a href="getAllEmployees">see All employees </a>
</body>
</html>