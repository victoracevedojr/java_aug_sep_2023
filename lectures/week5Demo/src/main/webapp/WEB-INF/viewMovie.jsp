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
	<link rel="stylesheet" type="text/css" href="/css/myStyles.css" />
</head>
<body>
	<nav>
		<h1 class="red">The Movies Compendium</h1>
		<ul>
			<li><a href="/movies/all">All movies</a></li>
			<li><a href="/directors/all">All directors</a></li>
		</ul>
	</nav>
	<h1>About movie #<c:out value="${thisMovie.id}"/>: <c:out value="${thisMovie.title}"/></h1>
	<p>Rating: <c:out value="${ thisMovie.rating }" /></p>
	<p>Genre: <c:out value="${ thisMovie.genre }" /></p>
	<p>Release year: <c:out value="${ thisMovie.releaseYear }" /></p>
	<p>Description: <c:out value="${ thisMovie.description }" /></p>
	<!-- Notice how we're linking to another class and grabbing an attribute! -->
	<p>Director: <c:out value="${ thisMovie.movieDirector.fullName }" /></p>
	<!-- Link moved to navbar -->
</body>
</html>