<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Language Details</title>
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
<body class="container col-3 p-3 text-center">



	<h2>${language.name}</h2>
	<h4>Creator: ${language.creator}</h4>
	<h4>Current Version: ${language.version}</h4>
	<div class = "d-flex justify-content-between">
	<a class="btn btn-info" href="/edit/${language.id}">Edit </a>
	<form:form action="/delete/${language.id}" method="delete">

		<button class="btn btn-info">Delete</button>
	</form:form>
	
			
	</div>
	
	<div class = "col-12 text-center">
	<a href="/languages">Dashboard</a>
	</div>
	
	


</body>
</html>