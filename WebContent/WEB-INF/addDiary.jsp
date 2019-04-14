<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="client.Client"%>
    <%@page import="user.UserLog"%>

<%
	Client customer = (Client) request.getAttribute("customer");
	UserLog user = (UserLog) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddDiary" method="post">
<input type="hidden" name="CIC" value="<%out.print(customer.getId_client());%>">
<input type="hidden" name="user" value="<%out.print(user.getUser());%>">
<select name="actionType">
<option value="CBD">CBD-Contacted debtor</option>
<option value="CBN">CBN-No Answer</option>
<option value="CBO">CBO-Contacted third party</option>
<option value="CBM">CBM-Voice message</option>
<option value="PTP">PTP-Promise to pay</option>
</select>
<br>
<textarea rows="4" cols="50" name="diary"></textarea>
<br>
<input type="submit" name="submit" value="Cancel">
<input type="submit" name="submit" value="Submit">
</form>
</body>
</html>