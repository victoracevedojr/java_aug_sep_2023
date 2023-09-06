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
    <title>New performer</title>
    <link rel="stylesheet" type="text/css" href="/css/formStyles.css" />
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
	<h1>Let's add a performer (actor/actress)!</h1>
	<form:form modelAttribute="newPerformer" method="POST" action="/performers/new" class="form">
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
		<input type="submit" value="Add performer" class="btn"/>
	</form:form>
</body>
</html>