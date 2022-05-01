<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@page isErrorPage="true"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Languages</title>
</head>
<body>


	<h1 class="text-center">Edit Language:</h1>

	<div
		class=" d-flex justify-content-center container col-3 bg-info mx-auto p-4">


		<form:form action="/update/${editLanguage.id}" method="put" modelAttribute="editLanguage">
			<div class="form-row col-8 text-white mb-2">
				<form:label path="name">Name:</form:label>
				<form:errors path="name" class="text-danger" />
				<form:input path="name" />
			</div>
			<div class="form-row col-8 text-white mb-2">
				<form:label path="creator">Creator:</form:label>
				<form:errors path="creator" class="text-danger" />
				<form:input path="creator" />
			</div>
			<div class="form-row col-8 text-white mb-2">
				<form:label path="version">Version:</form:label>
				<form:errors path="version" class="text-danger" />
				<form:input path="version" />
			</div>
			<input type="submit" value="Submit" />
		</form:form>

	</div>




</body>
</html>