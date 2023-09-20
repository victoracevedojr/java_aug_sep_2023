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
	<title>Show all directors</title>
	<link rel="stylesheet" type="text/css" href="/css/myStyles.css" />
</head>
<body>
	<nav>
		<h1>The Movies Compendium</h1>
		<ul>
			<li><a href="/movies/all">All movies</a></li>
			<li><a href="/directors/create">Add director</a></li>
		</ul>
	</nav>
	<h1>All director</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Number of films directed</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="thisDirector" items="${ allDirectors }">
				<tr>
					<td><c:out value="${ thisDirector.id }" /></td>
					<td><c:out value="${ thisDirector.fullName }" /></td>
					<td><c:out value="${ thisDirector.movies.size() }" /></td> <!-- Calling on size() method to get the number of items in the list of movies -->
					<td>
					<a href="/directors/${ thisDirector.id }/view" class="btn">View</a> 
					<a href="/directors/${ thisDirector.id }/edit" class="btn">Edit</a>
					<form action="/directors/${ thisDirector.id }/delete" method="post">
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