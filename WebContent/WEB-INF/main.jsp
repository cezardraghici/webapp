<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="user.UserLog"%>
<!DOCTYPE html>
<html>
<head>
<% UserLog user = (UserLog)request.getAttribute("user"); %>
<link rel="stylesheet" href="css/main.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="MainCheck">
		<div class="top">
			<table>
				<tr>
					<td class="left" >Logged in as : <%out.print(user.getUser()); %>
					<input type="hidden" name="user" value="<%out.print(user.getUser()); %>">
					</td>
					<td ><input type="submit" name="submit"
						value="Log out" class="right"></td>
				</tr>
			</table>
		</div>
		<div class="down">
			<table class="rest">
				<tr>
					<td><input type="submit" name="submit"
						value="Account Selection" class="button"></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="Clients View"
						class="button"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>