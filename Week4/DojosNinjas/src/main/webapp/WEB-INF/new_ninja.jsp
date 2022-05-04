<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninjas</title>
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

<div class = "text-center">
<a href = "/">Dashboard</a>
</div>

	<h1 class="text-center">New Ninja:</h1>

	<div
		class=" d-flex justify-content-center container col-3 bg-info mx-auto p-4">


		<form:form action="/createNinja" method="post" modelAttribute="newNinja">
		
		
			
			
			
			<div class="form-row col-8 text-white mb-2">
				<form:label path="dojo">Dojo:</form:label>
				<form:errors path="firstName" class="text-danger" />
				<form:select path="dojo">
				<c:forEach items="${dojos}" var="dojo">

					<option value="${dojo.id}">${dojo.name}</option>

				</c:forEach>
			</form:select>
			</div>

			<div class="form-row col-8 text-white mb-2">
				<form:label path="firstName">First Name:</form:label>
				<form:errors path="firstName" class="text-danger" />
				<form:input path="firstName" />
			</div>
			<div class="form-row col-8 text-white mb-2">
				<form:label path="lastName">Last Name:</form:label>
				<form:errors path="lastName" class="text-danger" />
				<form:input path="lastName" />
			</div>
			<div class="form-row col-8 text-white mb-2">
				<form:label path="age">Age:</form:label>
				<form:errors path="age" class="text-danger" />
				<form:input path="age" />
			</div>
			<input class="btn btn-dark" type="submit" value="Submit"/>
		</form:form>
	</div>
	
</body>
</html>