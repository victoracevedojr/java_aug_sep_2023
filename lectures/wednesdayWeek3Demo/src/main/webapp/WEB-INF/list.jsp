<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="myStyles.css">
<title>List of Pokemon</title>
</head>
<body>
	<h1 class="red">List of favorite Pokemon:</h1>
	<c:forEach var="thisPokemon" items="${ favPokemon }">
		<p>
			<c:out value="${ thisPokemon }"></c:out>
			<!-- Add " - burnnn!" if Pokemon's name is Charmander -->
			<c:if test="${ thisPokemon.equals('Charmander') }">
				 - burnnn!
			</c:if>
		</p>
	</c:forEach>
</body>
</html>