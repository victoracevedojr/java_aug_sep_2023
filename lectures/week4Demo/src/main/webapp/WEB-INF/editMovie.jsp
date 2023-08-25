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
</head>
<body>
	<h1>Edit movie:</h1>
	<form:form action="/movies/${ thisMovie.id }/update" method="post" modelAttribute="thisMovie">
		<!-- Allow us to use a PUT request -->
		<input type="hidden" name="_method" value="put">
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
			<form:input type="number" path="releaseYear"/> <!-- No value="" here so that we can use the year from our database -->
		</p>
		<p>
			<form:label path="rating">Rating:</form:label>
			<form:errors path="rating"/>
			<form:select path="rating" items="${possibleRatings}"/>
		</p>
		<input type="submit" value="Edit movie"/>
	</form:form>
	<p><a href="/movies/all">All movies</a></p>
</body>
</html>