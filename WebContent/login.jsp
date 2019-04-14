<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/login.css">
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="LoginCheck">
		<div class="message">
			<h3 style="color: red">${message}</h3>
			<h3 style="color: blue">${succesMessage}</h3>
		</div>
		<div>
			<table class="center">
				<tr>
					<td>User Name</td>
					<td><input type="text" name="user"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="login"></td>
					<td><input type="submit" name="submit" value="Register"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>