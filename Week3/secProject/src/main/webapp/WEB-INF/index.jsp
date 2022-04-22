<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->

<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
	<h1>Dojo Form</h1>
	<form action="/results" method="post">

		<p>
			Name: <input type="text" name="firstName">
		</p>
		<p>
			Email: <input type="text" name="email">
		</p>
		<p>
			Program: <select name="program">
				<option value="java">Java</option>
				<option value="MERN">Java</option>
				<option value="Azure">Java</option>
			</select>
		</p>

		<p>
			<button>Submit</button>
		</p>

	</form>

</body>
</html>