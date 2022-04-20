<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->

<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>


<h2>Customer Name: 
<c:out value="${name}"/>
</h2>

<h3>Item Name: 
<c:out value="${item}"/>
</h3>

<h3>Price: $<c:out value="${price}"/>
</h3>

<h3>Description: 
<c:out value="${description}"/>
</h3>

<h3>Vendor: 
<c:out value="${vendor}"/>
</h3>


<h1>Dojo Locations</h1>
<c:forEach var="oneDojo" items="${dojosFromMyController}">
	<p><c:out value="${oneDojo}"></c:out></p>
</c:forEach>



</body>
</html>