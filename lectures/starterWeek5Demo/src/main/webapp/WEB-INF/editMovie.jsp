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
	<title>Edit movie</title>
	<link rel="stylesheet" type="text/css" href="/css/formStyles.css" />
</head>
<body>
	<nav>
		<h1 class="red">The Movies Compendium</h1>
		<ul>
			<li><a href="/movies/all">All movies</a></li>
			<li><a href="/directors/all">All directors</a></li>
		</ul>
	</nav>
	<h1>Edit movie:</h1>
	<form:form action="/movies/${ thisMovie.id }/update" method="post" modelAttribute="thisMovie" class="form">
		<!-- Allow us to use a PUT request -->
		<input type="hidden" name="_method" value="put">
		<div>
			<form:label path="title">Title:</form:label>
			<form:errors path="title"/>
			<form:input path="title"/>
		</div>
		<div>
			<form:label path="genre">Genre:</form:label>
			<form:errors path="genre"/>
			<form:input path="genre"/>
		</div>
		<div>
			<form:label path="description">Description:</form:label>
			<form:errors path="description"/>
			<form:textarea path="description" rows="5" cols="50"/>
		</div>
		<div>
			<form:label path="releaseYear">Release year:</form:label>
			<form:errors path="releaseYear"/>
			<form:input type="number" path="releaseYear"/> <!-- No value="" here so that we can use the year from our database -->
		</div>
		<div>
			<form:label path="rating">Rating:</form:label>
			<form:errors path="rating"/>
			<form:select path="rating" items="${possibleRatings}"/>
		</div>
		<p>Allow user to pick a director via a dropdown!</p>
		<input type="submit" value="Edit movie" class="btn"/>
	</form:form>
</body>
</html>