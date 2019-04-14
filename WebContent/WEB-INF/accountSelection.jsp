<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="user.UserLog"%>
<% UserLog user = (UserLog) request.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/accountSelection.css">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="AccountCheck">
		<div class="top">
			<table>
				<tr>
					<td class="left">Logged in as : <%out.print(user.getUser());%>
					<input type="hidden" name="user" value="<%out.print(user.getUser()); %>">
					</td>
					<td><input type="submit" name="submit" value="Main" class="right"></td>
					<td class="button2"><input type="submit" name="submit"
						value="Log out" class="right"></td>
				</tr>
			</table>
		</div>
		<div class="down">
			<table class="center">
				<tr>
					<td><h3 style="color:red">${errorCICFound}</h3></td>
				</tr>
				<tr>
					<td>CIC</td>
					<td><input type="text" name="cic"></td>
				</tr>
				<tr>
					<td>CNP</td>
					<td><input type="text" name="cnp"></td>
				</tr>
				<tr>
					<td><input style="margin-left:200%;" type="submit" name="submit" value="Search"></td>
				</tr>
			</table>
		</div>

	</form>
</body>
</html>