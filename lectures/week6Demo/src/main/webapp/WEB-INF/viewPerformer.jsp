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
    <title>About ???</title>
	<link rel="stylesheet" type="text/css" href="/css/myStyles.css" />
</head>
<body>
	<nav>
		<h1 class="red">The Movies Compendium</h1>
		<ul>
			<li><a href="/movies/all">All movies</a></li>
			<li><a href="/directors/all">All directors</a></li>
			<li><a href="/performers/all">All performers</a></li>
		</ul>
	</nav>
	<h1>About <c:out value="${ thisPerformer.firstName }" /> <c:out value="${ thisPerformer.lastName }" />:</h1>
	<p>All movies that feature this performer:</p>
	<ul>
		<c:forEach var="thisMovie" items="${thisPerformer.performerMovies }"><!--  Notice we're grabbing the attribute that holds all movies linked to this performer -->
			<li value="${ thisMovie.id }"><c:out value="${thisMovie.title}"/></li>
		</c:forEach>
	</ul>
	<form method="POST" action="/performers/${ thisPerformer.id }/addMovie">
		<label>Add a new movie:</label>
		<select name="movie_id">
			<c:forEach var="availableMovie" items="${allAvailableMovies }">
				<option value="${ availableMovie.id }"><c:out value="${availableMovie.title}"/></option>
			</c:forEach>
		</select>
		<input type="submit" value="Add movie"/>
	</form>
</body>
</html>