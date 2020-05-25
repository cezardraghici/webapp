<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="client.Client"%>
<%@page import="user.UserLog"%>
<%@page import="java.util.*"%>

<%
	UserLog user = (UserLog) request.getAttribute("user");
	ArrayList<Client> list = (ArrayList<Client>) request.getAttribute("customers");
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/clientView.css">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="ClientView">
		<div class="topn">
			<table>
				<tr>
					<td>Logged in as : <%
						out.print(user.getUser());
					%> <input type="hidden" name="user"
						value="<%out.print(user.getUser());%>"></td>
					<td><input type="submit" name="submit" value="Log out"></td>
				</tr>
			</table>
		</div>

		<div class="splitn leftn">

			<input type="submit" name="submit" value="Add Client"
				style="width: 100%; height: 50px"><br> <input
				type="submit" name="submit" value="Remove Client"
				style="width: 100%; height: 50px"><br> <input
				type="submit" name="submit" value="Edit Client"
				style="width: 100%; height: 50px"><br> <input
				type="submit" name="submit" value="Add Credit"
				style="width: 100%; height: 50px"><br> <input
				type="submit" name="submit" value="Add Payment"
				style="width: 100%; height: 50px"><br>


		</div>

		<div class="splitn rightn">
			<div class="tbl">
			<table>
			<tr><th style="color: red">${message}</th></tr></table>
			<table >
				<tr style="border-bottom-style: groove;">
					<th style="width: 10%">CIC</th>
					<th style="width: 15%; border-left-style: groove">Nume</th>
					<th style="width: 15%; border-left-style: groove">Prenume</th>
					<th style="width: 15%; border-left-style: groove">CNP</th>
					<th style="width: 15%; border-left-style: groove">Localitate</th>
					<th style="width: 15%; border-left-style: groove">Judet</th>
					<th style="width: 15%; border-left-style: groove">Telefon</th>
				</tr>
			</table>
			
				<%for (Client customer : list) {%>
			
			<table>

				<tr>
					<td style="width: 10%"><input type="radio" name="CIC"
						value="<%out.print(customer.getId_client());%>"> <%
 	out.print(customer.getId_client());
 %>
					</td>
					<td style="width: 15%; border-left-style: groove">
						<%
							out.print(customer.getFirstname());
						%>
					</td>
					<td style="width: 15%; border-left-style: groove">
						<%
							out.print(customer.getLastname());
						%>
					</td>
					<td style="width: 15%; border-left-style: groove">
						<%
							out.print(customer.getCNP());
						%>
					</td>
					<td style="width: 15%; border-left-style: groove">
						<%
							out.print(customer.getCity());
						%>
					</td>
					<td style="width: 15%; border-left-style: groove">
						<%
							out.print(customer.getRegion());
						%>
					</td>
					<td style="width: 15%; border-left-style: groove">
						<%
							out.print(customer.getPhone());
						%>
					</td>
				</tr>
			</table>
			<%
				}
			%>
			</div>
		</div>


	</form>
</body>
</html>