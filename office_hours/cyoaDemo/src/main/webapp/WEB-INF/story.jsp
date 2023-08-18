<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choose Your Own Adventure!</title>
</head>
<body>
	<h1><c:out value="${ message }"></c:out></h1>
	<p><a href="/play/${ leftLink }"><c:out value="${ leftLink }"/></a></p>
	<p><a href="/play/${ rightLink }"><c:out value="${ rightLink }"/></a></p>
</body>
</html>