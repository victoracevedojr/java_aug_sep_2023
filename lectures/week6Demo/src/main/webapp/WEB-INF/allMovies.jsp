<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  When we add our forms, we will need additional lines here! -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--  For PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show all movies</title>
	<link rel="stylesheet" type="text/css" href="/css/myStyles.css" />
</head>
<body>
	<nav>
		<h1>The Movies Compendium</h1>
		<ul>
			<li><a href="/movies/create">Add movie</a></li>
			<li><a href="/directors/all">All directors</a></li>
			<li><a href="/performers/all">All performers</a></li>
		</ul>
	</nav>
	<h1>All movies</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="thisMovie" items="${ allMovies }">
				<tr>
					<td><c:out value="${ thisMovie.id }" /></td>
					<td><c:out value="${ thisMovie.title }" /></td>
					<td>
					<a href="/movies/${ thisMovie.id }/view" class="btn">View</a> 
					<a href="/movies/${ thisMovie.id }/edit" class="btn">Edit</a>
					<form action="/movies/${ thisMovie.id }/delete" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<input type="submit" value="Delete" class="btn-delete" />
					</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!--  Removed anchor tag and moved it up to the new nav bar -->
</body>
</html>