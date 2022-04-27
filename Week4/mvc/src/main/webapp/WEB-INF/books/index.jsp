<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Read Share</title>
</head>
<body>
	<h1>All Books</h1>

	<table class="table table-dark">

		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Language</th>
				<th>Number of Pages</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${books}" var="book">
				<tr>
					<!--  this comes from getters/setters in art.java-->
					<td><c:out value="${book.id}"></c:out></td>
					<td>
					<a href= "/books/<c:out value="${book.id}"></c:out>"><c:out value="${book.title}"></c:out></a>
					
					
					
					</td>
					<td><c:out value="${book.language}"></c:out></td>
					<td><c:out value="${book.numberOfPages}"></c:out></td>
				</tr>
			</c:forEach>

		</tbody>


	</table>

</body>
</html>