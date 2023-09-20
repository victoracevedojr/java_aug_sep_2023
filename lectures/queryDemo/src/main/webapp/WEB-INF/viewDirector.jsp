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
	<title>View director</title>
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
	<h1>About director #<c:out value="${thisDirector.id}"/>: <c:out value="${ thisDirector.fullName }"/></h1>
	<!-- Challenge for you to try: Figure out how to reformat this date in a prettier format, like "May 10, 1995" -->
	<p>Birthdate: <c:out value="${ thisDirector.birthdate }"/></p>
	<p>Movies directed:</p>
	<ul>
		<!-- Go through each movie linked to this director, then display its title -->
		<c:forEach var="thisMovie" items="${ thisDirector.movies }">
			<li><c:out value="${ thisMovie.title }" /></li>
		</c:forEach>
	</ul>

</body>
</html>