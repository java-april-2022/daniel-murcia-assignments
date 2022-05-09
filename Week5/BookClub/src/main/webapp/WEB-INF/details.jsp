<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Details</title>
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

<div class = "container">

<h2>${book.title}</h2>
<a href="/dashboard">Back to the shelves</a>

<c:if test="${book.user.id != loggedInUser.id }">
<div>
<h2>${book.user.userName} read ${book.title} by ${book.author}.</h2>

<h3> Here are ${book.user.userName}'s thoughts:</h3>

</div>

</c:if>

<c:if test="${book.user.id == loggedInUser.id }">
<div>
<h2>You read ${book.title} by ${book.author}.</h2>

<h3> Here are your thoughts:</h3>

</div>

</c:if>


<p>${book.thoughts}</p>

<c:if test="${book.user.id == loggedInUser.id}">

<a href="/edit/${book.id}">Edit</a>

<a href="/delete/${book.id}">Delete</a>


</c:if>






</div>


</body>
</html>