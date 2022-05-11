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

	<div class="container">
		<a href="/dashboard">Home</a> || <a href="/new">New Tree</a> || <a
			href="/logout">Logout</a> ||

		<h1>Tree Details:</h1>

		<h2>${tree.species} planted by ${tree.user.userName}</h2>
		<h4>Where: ${tree.location}</h4>
		<h4>When: ${tree.datePlanted}</h4>
		<h4>Reason: ${tree.reason}</h4>

		<h4>Visited by:</h4>

		<c:forEach items="${visitors}" var="visitor">

			<h3>${visitor.userName}</h3>

		</c:forEach>

		<h4>
			<c:choose>
				<c:when test="${visitors.contains(userLoggedIn)}">
					<a href="/tree/${tree.id}/unvisit">I did not visit this tree.</a>
				</c:when>
				<c:otherwise>
					<a href="/tree/${tree.id}/visit">I visited this tree.</a>
				</c:otherwise>
			</c:choose>
		</h4>



		<!-- IF THE DISPLAYED PROJECT WAS CREATED BY THE LOGGED IN USER, SHOW EDIT/DELETE BTNS. -->
		<c:if test="${tree.user.id == loggedInUser.id}">

			<a href="/edit/${tree.id}">Edit</a>
			<a href="/delete/${tree.id}">Delete</a>

		</c:if>






	</div>
</body>
</html>