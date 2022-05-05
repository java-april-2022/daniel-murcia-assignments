<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Expense</title>
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

	<h1 class="text-center">Edit Expense:</h1>

	<div
		class=" d-flex justify-content-center container col-3 bg-info mx-auto p-4">


		<form:form action="/update/${editExpense.id}" method="put" modelAttribute="editExpense">
			<div class="form-row col-8 text-white mb-2">
				<form:label path="name">Expense Name:</form:label>
				<form:errors path="name" class="text-danger" />
				<form:input path="name" />
			</div>
			<div class="form-row col-8 text-white mb-2">
				<form:label path="vendor">Vendor:</form:label>
				<form:errors path="vendor" class="text-danger" />
				<form:input path="vendor" />
			</div>
			<div class="form-row col-8 text-white mb-2">
				<form:label path="amount">Amount:</form:label>
				<form:errors path="amount" class="text-danger" />
				<form:input path="amount" />
			</div>
			<div class="form-row col-8 text-white mb-2">
				<form:label path="description">Description:</form:label>
				<form:errors path="description" class="text-danger" />
				<form:textarea path="description" />
			</div>
			<input type="submit" value="Submit" />
		</form:form>

	</div>
</body>
</html>