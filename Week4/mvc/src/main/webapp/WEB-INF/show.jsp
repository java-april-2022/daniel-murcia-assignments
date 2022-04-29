<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ taglib prefix = "t" tagdir="/WEB-INF/tags" %>

<h1><p:out value="${book.title}"></p:out></h1>

<t:partial>




<p:forEach items = "book"></p:forEach>



<h3> Description: <p:out value="${book.description}"></p:out></h3>
<h3> Language: <c:out value="${book.language}"></c:out></h3>
<h3> Number of Pages: <c:out value="${book.numberOfPages}"></c:out></h3>

	
</body>


</t:partial>

</html>