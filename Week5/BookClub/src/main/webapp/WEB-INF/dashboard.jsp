<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
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

<div class = "container mx-auto">

<h1>Welcome, <c:out value = "${loggedInUser.userName}"></c:out>!</h1>
<h3>Books from everyone's shelves:</h3>
	<a href="">Home</a> ||
	<a href="/new">Add a Book!</a> ||
	<a href="/bookbroker">Book Broker</a> ||
	<a href="/logout">Logout</a> ||
	
<table class = "table table-striped table-info">
<thead>
	<tr>
		<th>ID</th>
		<th>Title</th>
		<th>Author</th>
		<th>Posted By</th>
	</tr>
</thead>
	<c:forEach items = "${books}" var ="book">
		<tr>
		<td>${book.id}</td>
		<td>
		
		<a href="/show/${book.id}">${book.title}</a> 
		
		</td>
		<td>${book.author}</td>
		<td>${book.user.userName}</td>
		
		</tr>
	</c:forEach>
	
	
<tbody>

</tbody>

</table>

</div>


</body>
</html>

