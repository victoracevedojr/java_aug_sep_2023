<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All performers</title>
	<link rel="stylesheet" type="text/css" href="/css/myStyles.css" />
</head>
<body>
	<nav>
		<h1>The Movies Compendium</h1>
		<ul>
			<li><a href="/movies/all">All movies</a></li>
			<li><a href="/directors/all">All directors</a></li>
			<li><a href="/performers/new">Add performer</a></li>
		</ul>
	</nav>
	<h1>All performers</h1>
	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Number of movies</td>
				<td>Actions</td>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="thisPerformer" items="${ allPerformers }">
				<tr>
					<td><c:out value="${ thisPerformer.id }"/></td>
					<td><c:out value="${ thisPerformer.firstName }"/> <c:out value="${ thisPerformer.lastName }"/></td>
					<td>???</td>
					<td>
						<a href="/performers/${ thisPerformer.id }/view" class="btn">View</a> 
						<a href="/performers/${ thisPerformer.id }/edit" class="btn">Edit</a>
						<form action="/performers/${ thisPerformer.id }/delete" method="post">
							<input type="hidden" name="_method" value="delete"/>
							<input type="submit" value="Delete" class="btn-delete" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>