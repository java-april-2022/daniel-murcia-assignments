<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="p"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojos</title>
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

	<h1 class="text-center">New Dojo:</h1>

	<div
		class=" d-flex justify-content-center container col-3 bg-info mx-auto p-4">


		<form:form action="/createDojo" method="post" modelAttribute="newDojo">
			<div class="form-row col-8 text-white mb-2">
				<form:label path="name">Name:</form:label>
				<form:errors path="name" class="text-danger" />
				<form:input path="name" />
			</div>
			<input class ="btn btn-dark" type="submit" value="Submit"/>
		</form:form>
	</div>
	
</body>
</html>