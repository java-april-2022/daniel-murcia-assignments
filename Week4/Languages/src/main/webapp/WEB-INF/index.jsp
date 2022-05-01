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

	<h1 class="text-center">Languages</h1>

	<div class="container col-4">

		<table class="table table-info">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${languages}" var="language">
					<tr>
						<!--  this comes from getters/setters in art.java-->
						<td><a href="/languageDetails/${language.id}">${language.name}
						</a></td>
						<td><c:out value="${language.creator}"></c:out></td>
						<td><c:out value="${language.version}"></c:out></td>
						<td class="d-flex justify-content-between"><a
							class="btn btn-info" href="/edit/${language.id}">Edit </a> <form:form
								action="/delete/${language.id}" method="delete">

								<button class="btn btn-info">Delete</button>
							</form:form></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

	</div>

	<h1 class="text-center">Add a Language:</h1>

	<div
		class=" d-flex justify-content-center container col-3 bg-info mx-auto p-4">


		<form:form action="/create" method="post" modelAttribute="language">
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