<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<h1 class="text-center">Save Travels</h1>

	<div class="container col-4">

		<table class="table table-info">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>

				<p:forEach items="${expenses}" var="expense">
					<tr>
						<!--  this comes from getters/setters in art.java-->
						<td>
						<a href="/expenseDetails/${expense.id}">${expense.name} </a>
						
				
						
						
						</td>
						<td><p:out value="${expense.vendor}"></p:out></td>
						<td><p:out value="${expense.amount}"></p:out></td>
						<td class= "d-flex justify-content-between" >
						
						<a class = "btn btn-info" href= "/edit/${expense.id}">Edit </a>
					
						<form:form action="/delete/${expense.id}" method="delete">
					
						<button class="btn btn-info">Delete</button>
						</form:form>
						</td>
					</tr>
				</p:forEach>
			</tbody>

		</table>

	</div>

	<h1 class="text-center">Add an Expense:</h1>

	<div
		class=" d-flex justify-content-center container col-3 bg-info mx-auto p-4">


		<form:form action="/create" method="post" modelAttribute="expense">
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