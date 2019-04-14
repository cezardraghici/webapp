<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddClient" method="post">
		<div>
			<h3>${succes}</h3>
		</div>
		<div>
			<table style="border-bottom-style: groove;">
				<tr>
					<td>Nume :</td>
					<td><input type="text" name="nume" placeholder="Nume" required></td>
				</tr>
				<tr>
					<td>Prenume :</td>
					<td><input type="text" name="prenume" placeholder="Prenume"
						required></td>
				</tr>
				<tr>
					<td>CNP :</td>
					<td><input type="text" name="CNP" placeholder="CNP" required></td>
				</tr>
				<tr>
					<td>Localitate :</td>
					<td><input type="text" name="localitate"
						placeholder="Localitate" required></td>
				</tr>
				<tr>
					<td>Judet :</td>
					<td><input type="text" name="judet" placeholder="Judet"
						required></td>
				</tr>
				<tr>
					<td>Telefon :</td>
					<td><input type="text" name="telefon" placeholder="Telefon"
						required></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="Submit"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>