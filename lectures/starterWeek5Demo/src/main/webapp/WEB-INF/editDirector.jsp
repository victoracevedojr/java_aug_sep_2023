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
	<title>Edit director</title>
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
	<h1>Edit director:</h1>
	<form:form action="/directors/${ thisDirector.id }/update" method="post" modelAttribute="thisDirector" class="form">
		<!-- Allow us to use a PUT request -->
		<input type="hidden" name="_method" value="put">
		<div>
			<form:label path="firstName">First name:</form:label>
			<form:errors path="firstName"/>
			<form:input path="firstName"/>
		</div>
		<div>
			<form:label path="lastName">Last name:</form:label>
			<form:errors path="lastName"/>
			<form:input path="lastName"/>
		</div>
		<p>Figure out how to add date field here and other inputs!</p>
		<input type="submit" value="Edit director" class="btn"/>
	</form:form>
</body>
</html>