<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruity Loops</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->

<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>

</head>
<body>


<h1 class = "text-info text-center">Fruit Store</h1>

<container class = "container my-auto d-flex align-items-center">
<table class = "table table-info table-bordered table-striped table-hover">
	<thead class = "thead-dark">
		<tr>
			<th>Name</th>
			<th>Price</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="oneFruit" items="${fruitsFromController}">
		<tr>
		
			<td><c:out value="${oneFruit.name}"></c:out></td>
			<td><c:out value="${oneFruit.price}"></c:out></td>
		
		</tr>
		</c:forEach>
		
	</tbody>
</table>
</container>


</body>
</html>