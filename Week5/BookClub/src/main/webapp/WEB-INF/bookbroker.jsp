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
	<h3>
		Hello <c:out value="${loggedInUser.userName}"></c:out>!  Welcome to...
	</h3>
	<h1>The Book Broker!</h1>
	<a href="/dashboard">Back to the Shelves</a> ||
	<a href="/logout">Logout</a> ||
	
	<br>
	<br>

	<h4>Available Books to Borrow:</h4>
	<table class="table table-striped table-info">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Owner</th>
				<th>Actions</th>
			</tr>
		</thead>
		<c:forEach items="${availableBooks}" var="book">
			<tr>
				<td>${book.id}</td>
				<td><a href="/show/${book.id}">${book.title}</a></td>
				<td>${book.author}</td>
				<td>${book.user.userName}</td>
				<td><c:choose>

						<c:when test="${book.user.id == userLoggedIn.id }">

							<a href="/edit/${book.id}">Edit</a>

							<a href="/delete/${book.id}">Delete</a>

						</c:when>

						<c:otherwise>


							<a href="/borrow/${book.id}">Borrow</a>


						</c:otherwise>

					</c:choose></td>
			</tr>
		</c:forEach>

		<tbody>

		</tbody>

	</table>
<br>

	<h4>Books I'm Borrowing:</h4>
	<table class="table table-striped table-info">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Owner</th>
				<th>Actions</th>
			</tr>
		</thead>
		<c:forEach items="${borrowedBooks}" var="book">
			<tr>
				<td>${book.id}</td>
				<td><a href="/show/${book.id}">${book.title}</a></td>
				<td>${book.author}</td>
				<td>${book.user.userName}</td>
				<td><a href="/return/${book.id}">Return</a></td>
			</tr>
		</c:forEach>

		<tbody>

		</tbody>

	</table>
	
	</div>
</body>
</html>

