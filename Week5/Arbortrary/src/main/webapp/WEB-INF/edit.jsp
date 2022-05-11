<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Project</title>
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



	<h1 class="text-center">Edit Tree</h1>
	<div class = "text-center">
		<a href="/dashboard">Home</a>
	</div>


	<div
		class=" d-flex justify-content-center container col-3 bg-info mx-auto p-4">


		<form:form action="/update/${editTree.id}" method="put" modelAttribute="editTree">
			<div class="form-row col-8 text-white mb-2">
				<form:label path="species">Species :</form:label>
				<form:errors path="species" class="text-danger" />
				<form:input path="species" />
			</div>
			<div class="form-row col-8 text-white mb-2">
				<form:label path="location">Location:</form:label>
				<form:errors path="location" class="text-danger" />
				<form:input path="location" />
			</div>
			<div class="form-row col-8 text-white mb-2">
				<form:label path="reason">Reason:</form:label>
				<form:errors path="reason" class="text-danger" />
				<form:input path="reason" />
			</div>
			<div class="form-row col-8 text-white mb-2">
				<form:label path="datePlanted">Date Planted:</form:label>
				<form:errors path="datePlanted" class="text-danger" />
				<form:input path="datePlanted" />
			</div>
			
		<!--  HIDDEN INPUT FOR USER ID  -->
			<form:hidden value="${loggedInUser.id}" path = "user"/>
			<input type="submit" value="Submit" />
		</form:form>

	</div>
</body>
</html>