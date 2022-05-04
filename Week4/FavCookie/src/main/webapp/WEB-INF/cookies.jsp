<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fitness</title>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/app.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>


<body>
<h1>Cookie Club</h1>
<a href = "/">Home</a> || 
<a href="/trainer">New Trainer</a> ||
<a href ="/new">New Fitness Class</a>

<table class = "table table-striped">
<thead>
	<tr>
		<th>Class ID</th>
		<th>Name</th>
		<th>Trainer</th>
		<th>Trainer Email</th>
	</tr>
</thead>
	<c:forEach items = "${items}" var ="item">
		<tr>
		<td>${item.id}</td>
		<td>${item.name}</td>

		</tr>
	</c:forEach>
	
	
<tbody>

</tbody>



</table>
</body>
</html>