<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First form</title>
</head>
<body>
	<h1>Form page!</h1>
	<form action="/processform" method="POST">
		<div>
			<label>First name:</label>
			<input type="text" name="firstName">
		</div>
		<div>
			<label>Last name:</label>
			<input type="text" name="lastName">
		</div>
		<div>
			<label>Favorite number:</label>
			<input type="number" name="favoriteNumber">
		</div>
		<div>
			<label>Tell us about yourself:</label>
			<textarea name="info"></textarea>
		</div>
		<input type="submit" value="Send form">
	</form>
</body>
</html>