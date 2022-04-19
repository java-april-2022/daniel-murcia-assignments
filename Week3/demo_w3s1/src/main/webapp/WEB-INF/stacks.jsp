<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>All Stacks:</h1>
<c:outforEach items = "${myStacks}" var = "stack">

<c:out value = "${stack}"></c:out>


</c:outforEach>


<a href = "/stacks"/>Stacks</a>
 


</body>
</html>