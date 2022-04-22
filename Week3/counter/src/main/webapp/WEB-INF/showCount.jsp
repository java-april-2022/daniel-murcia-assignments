<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Count</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->

<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body class="container p-3 my-auto inline-block text-center">

	<h1>
		You have visited
		<c:out value="${countToShow}"></c:out>
		times.
	</h1>



	<a href="/">Test Another Visit?</a>

	<br>
	<br>

	<a href="/by2">Test A Double Visit?</a>

	<br>
	<br>

	<a href="/reset">Reset Counter</a>


</body>
</html>