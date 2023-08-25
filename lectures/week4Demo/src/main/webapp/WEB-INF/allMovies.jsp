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
</head>
<body>
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
					<a href="/movies/${ thisMovie.id }/view">View</a> 
					<a href="/movies/${ thisMovie.id }/edit">Edit</a>
					<form action="/movies/${ thisMovie.id }/delete" method="post">
						<input type="hidden" name="_method" value="delete"/>
						<input type="submit" value="Delete"/>
					</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="/movies/create">Add movie</a>
</body>
</html>