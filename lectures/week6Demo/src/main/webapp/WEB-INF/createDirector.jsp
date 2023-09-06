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
	<title>Create Director</title>
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
	<h1>Let's add a director!</h1>
	<form:form modelAttribute="newDirector" method="POST" action="/directors/new" class="form">
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
		<div>
			<form:label path="birthdate">Birth date:</form:label>
			<form:errors path="birthdate"/>
			<form:input type="date" path="birthdate"/>
		</div>
		<input type="submit" value="Add director" class="btn"/>
	</form:form>
	<!-- Removed anchor tag and moved up to new nav bar -->
</body>
</html>