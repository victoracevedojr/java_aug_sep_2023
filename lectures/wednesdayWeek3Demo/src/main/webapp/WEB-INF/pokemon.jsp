<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pokemon page</title>
</head>
<body>
	<h1>Our favorite Pokemon is <c:out value="${ favoritePokemon }" />!</h1>
</body>
</html>