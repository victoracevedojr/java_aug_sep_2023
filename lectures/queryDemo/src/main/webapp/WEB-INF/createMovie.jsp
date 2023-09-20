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
	<title>Create Movie</title>
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
	<h1>Let's add a movie!</h1>
	<form:form modelAttribute="newMovie" method="POST" action="/movies/new" class="form">
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
			<form:input type="number" path="releaseYear" value="1890"/>
		</div>
		<div>
			<form:label path="rating">Rating:</form:label>
			<form:errors path="rating"/>
			<form:select path="rating" items="${possibleRatings}"/>
		</div>
		<div>
			<form:label path="movieDirector">Movie director:</form:label>
			<form:errors path="movieDirector"/>
			<form:select path="movieDirector">
				<!-- "id" column for the value in the Director model, "fullName" column for the text to display for the label -->
				<form:options items="${allDirectors}" itemValue="id" itemLabel="fullName" />
			</form:select>
			
		</div>
		<input type="submit" value="Add movie" class="btn"/>
	</form:form>
	<!-- Removed anchor tag and moved up to new nav bar -->
</body>
</html>