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



	<h1 class="text-center">Edit Project</h1>
	<div class = "text-center">
		<a href="/dashboard">Home</a>
	</div>


	<div
		class=" d-flex justify-content-center container col-3 bg-info mx-auto p-4">


		<form:form action="/update/${editProject.id}" method="put" modelAttribute="editProject">
			<div class="form-row col-8 text-white mb-2">
				<form:label path="projectName">Project Name:</form:label>
				<form:errors path="projectName" class="text-danger" />
				<form:input path="projectName" />
			</div>
			<div class="form-row col-8 text-white mb-2">
				<form:label path="description">Project Description:</form:label>
				<form:errors path="description" class="text-danger" />
				<form:input path="description" />
			</div>
			
		<!--  HIDDEN INPUT FOR USER ID  -->
			<form:hidden value="${loggedInUser.id}" path = "user"/>
			<input type="submit" value="Submit" />
		</form:form>

	</div>
</body>
</html>