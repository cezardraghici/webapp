<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="client.Client"%>
<%@page import="java.util.*"%>
<%
	Client customer = (Client) request.getAttribute("customer");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Client Edit</title>
</head>
<body>
	<form action="ClientEdit" method="post">
		<table>
			<tr>
				<th>Current Data</th>
				<th>New Data</th>
			</tr>
			<tr>
				<td>Nume :</td>
				<td>
					<%
						out.print(customer.getNume());
					%>
				</td>
				<td><input type="text" name="nume" placeholder="Nume">
				</td>
			</tr>
			<tr>
				<td>Prenume :</td>
				<td>
					<%
						out.print(customer.getPrenume());
					%>
				</td>
				<td><input type="text" name="prenume" placeholder="Prenume">
				</td>
			</tr>
			<tr>
				<td>Localitate :</td>
				<td>
					<%
						out.print(customer.getLocalitate());
					%>
				</td>
				<td><input type="text" name="localitate"
					placeholder="Localitate"></td>
			</tr>
			<tr>
				<td>Judet :</td>
				<td>
					<%
						out.print(customer.getJudet());
					%>
				</td>
				<td><input type="text" name="judet" placeholder="Judet">
				</td>
			</tr>
			<tr>
				<td>Telefon :</td>
				<td>
					<%
						out.print(customer.getTelefon());
					%>
				</td>
				<td><input type="text" name="telefon" placeholder="Telefon">
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
			<tr>
			<td>
			<input type="hidden" name="CIC" value="<%out.print(customer.getId_client());%>">
			</td>
			</tr>
		</table>
	</form>
</body>
</html>