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
</head>
<body>
	<h1>Let's add a movie!</h1>
	<form:form modelAttribute="newMovie" method="POST" action="/movies/new">
		<p>
			<form:label path="title">Title:</form:label>
			<form:errors path="title"/>
			<form:input path="title"/>
		</p>
		<p>
			<form:label path="genre">Genre:</form:label>
			<form:errors path="genre"/>
			<form:input path="genre"/>
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:errors path="description"/>
			<form:textarea path="description" rows="5" cols="50"/>
		</p>
		<p>
			<form:label path="releaseYear">Release year:</form:label>
			<form:errors path="releaseYear"/>
			<form:input type="number" path="releaseYear" value="1890"/>
		</p>
		<p>
			<form:label path="rating">Rating:</form:label>
			<form:errors path="rating"/>
			<form:select path="rating" items="${possibleRatings}"/>
		</p>
		<input type="submit" value="Add movie"/>
	</form:form>
</body>
</html>