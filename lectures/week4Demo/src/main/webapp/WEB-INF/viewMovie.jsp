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
<title>View movie</title>
</head>
<body>
	<h1>About movie #<c:out value="${thisMovie.id}"/>: <c:out value="${thisMovie.title}"/></h1>
	<p>Rating: <c:out value="${ thisMovie.rating }" /></p>
	<p>Genre: <c:out value="${ thisMovie.genre }" /></p>
	<p>Release year: <c:out value="${ thisMovie.releaseYear }" /></p>
	<p>Description: <c:out value="${ thisMovie.description }" /></p>
	<p><a href="/movies/all">View all movies</a></p>
</body>
</html>