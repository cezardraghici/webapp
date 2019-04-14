<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/register.css">
<body>
	<form method="post" action="RegisterCheck">
		<div class="message">
			<h3>${errorMessage}</h3>
			<h3>${userError}</h3>
		</div>
		<div>
			<table class="center">

				<tr>
					<td>User Name</td>
					<td><input type="text" name="user" placeholder="User Name"
						required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"
						placeholder="Password" required></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName"
						placeholder="First Name" required></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" placeholder="Last Name"
						required></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" placeholder="Email"
						required></td>
				</tr>
				<tr>
					<td>Adress</td>
					<td><input type="text" name="adress" placeholder="Adress"
						required></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="tel" name="phone" placeholder="Phone"
						required></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="Register"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>