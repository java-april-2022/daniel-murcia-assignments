<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
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
	<main>
		<div class="container d-flex text-center">
			<div class="container bg-dark p-5">
				<div class="container col-6 bg-dark mx-auto p-4">
					<h2 class="text-primary">Register</h2>
					<form:form action="/registration" method="POST" modelAttribute="newUser">
						<input type="hidden" name="id">
						<div class="form-row text-start">
							<div class="col-15 text-white mb-2">
								<form:label path="userName">User Name:</form:label>
								<form:errors path="userName" class="text-danger" />
								<form:input path="userName" class = "form-control" />
							</div>
						</div>
						<div class="form-row text-start">
							<div class="col-15 text-white mb-2">
								<form:label path="email">Email:</form:label>
								<form:errors path="email" class="text-danger" />
								<form:input path="email" class = "form-control" />
							</div>
						</div>
						<div class="form-row text-start">
							<div class="col-15 text-white mb-2">
								<form:label path="password">Password:</form:label>
								<form:errors path="password" class="text-danger" />
								<form:password path="password" class = "form-control" />
							</div>
						</div>
						<div class="form-row text-start">
							<div class="col-15 text-white mb-2">
								<form:label path="confirm">Confirm Password:</form:label>
								<form:errors path="confirm" class="text-danger" />
								<form:password path="confirm" class = "form-control" />
							</div>
						</div>
						<div class="form-row">
							<div class="col-5 text-white">
								<input class="btn btn-info" type="submit" value="Submit">
							</div>
						</div>
					</form:form>
				</div>
			</div>
			
		</div>
		<div class="container d-flex text-center">
			<div class="container bg-light p-5">
				<div class="container col-6 bg-light mx-auto p-4">
					<h2 class="text-success">Login</h2>
					<form:form action="/login" method="POST" modelAttribute="newLogin">
						<div class="form-row text-start">
							<div class="col-15 text-dark mb-2">
								<form:label path="email">Email:</form:label>
								<form:errors path="email" class="text-danger" />
								<form:input path="email" class = "form-control" />
							</div>
						</div>
						<div class="form-row text-start">
							<div class="col-15 text-dark mb-2">
								<form:label path="password">Password:</form:label>
								<form:errors path="password" class="text-danger" />
								<form:password path="password" class = "form-control" />
							</div>
						</div>
						<div class="form-row">
							<div class="col-4 text-white">
								<input class="btn btn-success" type="submit" value="Login">
							</div>
						</div>
					

					</form:form>
				</div>
			</div>

		</div>

	</main>
</body>
</html>