<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix= "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage= "true" %>

<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Books!</title>
</head>
<body>

<div class = "container">
		
	<h1>New Book</h1>
	<form:form action="/books" method ="post" modelAttribute ="book">
		<div>
			<form:label path = "title">Title</form:label>
			<form:errors path="title" class = "text-danger"/>
			<form:input path = "title"/> 
		</div>
		<div>
			<form:label path="description">Description</form:label>
			<form:errors path="description" class = "text-danger"/>
			<form:textarea path = "description"/>
		</div>
		<div>
			<form:label path="language">Language</form:label>
			<form:errors path="language" class = "text-danger"/>
			<form:input path = "language"/>
		</div>
		<div>
			<form:label path="numberOfPages">Pages</form:label>
			<form:errors path="numberOfPages" class = "text-danger"/>
			<form:input type = "number" path= "numberOfPages"/>
		</div>
		<input type ="submit" value= "Submit"/>
	</form:form>
	
</div>


</body>
</html>