<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/app.js"></script>
<meta charset="UTF-8">
<title>Omikuji</title>
</head>
<body>

	<h1 class="text-center">Here's Your Omikuji!</h1>




	<div class="container col-6 bg-dark mx-auto p-4">
		<h3 class="p-3 text-white">
			In <span><c:out value="${num}"></c:out></span> years, you will live
			in <span><c:out value="${city}"></c:out></span> with <span><c:out
					value="${person}"></c:out></span> as your roommate, <span><c:out
					value="${hobby}"></c:out></span> for a living. The next time you see a <span><c:out
					value="${livingThing}"></c:out></span>, you will have good luck. Also, <span><c:out
					value="${somethingNice}"></c:out></span>.
		</h3>
		<div class="col text-center p-3">
			<a class=" btn btn-primary" href="/omikuji">Go back</a>
		</div>


	</div>


</body>
</html>