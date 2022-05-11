<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix= "t" tagdir="/WEB-INF/tags" %>
<%@page isErrorPage="true"%>

<t:partial>


		<table class="table table-striped">
			<thead>
				<tr>
					<th>Species</th>
					<th>Planted By</th>
					<th>Visitors</th>
					<th>Actions</th>
				</tr>
			</thead>
			<c:forEach items="${trees}" var="tree">
				<tr>
				
					<td>${tree.species}</td>
					<td>${tree.user.userName}</td>
					<td>${tree.visitors.size()}</td>
					<td><a href="/trees/treeDetails/${tree.id}">Details</a>
					</td>
					
					
				</tr>
			</c:forEach>


			<tbody>

			</tbody>



		</table>
		
</t:partial>

