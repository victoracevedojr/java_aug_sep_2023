<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form results</title>
</head>
<body>
	<h1>First name: <c:out value="${ firstName }" /></h1>
	<h1>Last name: <c:out value="${ lastName }" /></h1>
	<h1>Your favorite number: <c:out value="${ favoriteNumber }" /></h1>
	<h1>About yourself: <c:out value="${ info }" /></h1>
</body>
</html>