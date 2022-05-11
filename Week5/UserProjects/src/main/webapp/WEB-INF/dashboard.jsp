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
					<th>Project Name</th>
					<th>Created By</th>
					<th>Total Likes</th>
					<th>Like/Unlike</th>
				</tr>
			</thead>
			<c:forEach items="${projects}" var="project">
				<tr>
					<td><a href="/projects/projectDetails/${project.id}">${project.projectName}</a>
					</td>
					<td>${project.user.userName}</td>
					<td>${project.likers.size()}</td>
					<td><c:choose>
							<c:when test="${project.likers.contains(userLoggedIn)}">
								<a href="/project/${project.id}/unlike">Unlike</a>
							</c:when>
							<c:otherwise>
								<a href="/project/${project.id}/like">Like</a>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>


			<tbody>

			</tbody>



		</table>
		
</t:partial>

