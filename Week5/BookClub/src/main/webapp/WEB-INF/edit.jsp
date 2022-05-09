<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
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



	<h1 class="text-center">Change Your Entry:</h1>
	<div class="text-center">
		<a href="/dashboard">Back to shelves</a>
	</div>


	<div
		class=" d-flex justify-content-center container col-3 bg-info mx-auto p-4">


		<form:form action="/update/${editBook.id}" method="put"
			modelAttribute="editBook">
			<div class="form-row col-8 text-white mb-2">
				<form:label path="title">Title:</form:label>
				<form:errors path="title" class="text-danger" />
				<form:input path="title" />
			</div>
			<div class="form-row col-8 text-white mb-2">
				<form:label path="author">Author:</form:label>
				<form:errors path="author" class="text-danger" />
				<form:input path="author" />
			</div>
			<div class="form-row col-8 text-white mb-2">
				<form:label path="thoughts">Thoughts:</form:label>
				<form:errors path="thoughts" class="text-danger" />
				<form:input path="thoughts" />
			</div>
			<form:hidden value="${loggedInUser.id}" path="user" />
			<input type="submit" value="Submit" />
		</form:form>

	</div>
</body>
</html>