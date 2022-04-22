<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->

<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/app.js"></script>

</head>
<body>

	<div class="container col-6 bg-dark mx-auto p-4">
		<h2 class="text-primary">Send an Omikuji!</h2>
		<form action="/omikuji/show" method="POST">
			<div class="form-row">
				<div class="col-8 text-white mb-2">
					<label for="num">Select a number from 5 to 25:</label> <select
						name="num" class="form-control">

						<c:forEach var="i" begin="5" end="25" step="1" varStatus="status">
							<option><c:out value="${i}"></c:out></option>

						</c:forEach>

					</select>
				</div>
			</div>
			<div class="form-row">
				<div class="col-8 text-white mb-2">
					<label for="name">Enter the name of any city:</label> <input
						type="text" name="city" class='form-control'>
				</div>
			</div>
			<div class="form-row">
				<div class="col-8 text-white mb-2">
					<label for="name">Enter the name of any real person:</label> <input
						type="text" name="person" class='form-control'>
				</div>
			</div>
			<div class="form-row">
				<div class="col-8 text-white mb-2">
					<label for="name">Enter professional endeavor or hobby:</label> <input
						type="text" name="hobby" class='form-control'>
				</div>
			</div>
			<div class="form-row">
				<div class="col-8 text-white mb-2">
					<label for="name">Enter any type of living thing:</label> <input
						type="text" name="livingThing" class='form-control'>
				</div>
			</div>

			<div class="form-row">
				<div class="col-8 text-white mb-2">
					<label for="name">Say something nice to someone:</label> <input
						type="text" name="somethingNice" class='form-control'>
				</div>
			</div>
			<div class="form-row">
				<div class="col-5 text-white">
					<label for="">Send and show a friend</label>
				</div>
				<br>
			</div>
			<div class="form-row">
				<div class="col-5 text-white">
					<input class="btn btn-primary" type="submit" value="Submit">
				</div>
			</div>
		</form>
	</div>

</body>
</html>