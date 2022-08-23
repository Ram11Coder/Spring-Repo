<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Employee's list :</h2>


<table border="1px">
<tr>
<th>Id</th>
<th>Name</th>
<th>Age</th>
<th>Gender</th>
<th>Desigination</th>
</tr>

<c:forEach  items="${employees}" var="employee">
<tr>
<td>${employee.id}</td>
<td>${employee.name}</td>
<td>${employee.age}</td>
<td>${employee.gender}</td>
<td>${employee.desigination}</td>
<td><a href="deleteEmployee?id=${employee.id }">delete</a></td>
<td><a href="editEmployee?id=${employee.id }">edit</a></td>
</tr>
</c:forEach>
</table>
<a href="createEmployee">Create Employee</a>
</body>
</html>