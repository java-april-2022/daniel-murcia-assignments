<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEW NFT</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<h1>New Art</h1>
	<form:form action="/create" method="post" modelAttribute="newArt">
		<div>
			<form:label path="title">title:</form:label>
			<form:errors path="title" class="text-danger" />
			<form:input path="title" />
		</div>
		<div>
			<form:label path="description">description:</form:label>
			<form:errors path="description" class="text-danger" />
			<form:input path="description" />
		</div>

		<div>
			<form:label path="url">URL:</form:label>
			<form:errors path="url" class="text-danger" />
			<form:textarea path="url" />
		</div>
		<button>Create Art</button>
	</form:form>

</body>
</html>