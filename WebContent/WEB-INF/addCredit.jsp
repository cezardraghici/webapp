<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="client.Client"%>
<%@page import="java.util.*"%>
<%@page import="user.UserLog"%>
<%@page import="credit.Credit"%>
<%
	Client clientD = (Client) request.getAttribute("clientD");
	UserLog user = (UserLog) request.getAttribute("user");
	ArrayList<Credit> scd = (ArrayList<Credit>) request.getAttribute("scd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="AddCredit">
		<input type="hidden" name="user"
			value="<%out.print(user.getUser());%>">
		<div>
			<div class="top">
				<table>
					<tr>
						<td>Nume :</td>
						<td style="width: 300px; text-align: center;">
							<%
								out.print(clientD.getFirstname() + " " + clientD.getLastname());
							%>
						</td>
					</tr>
					<tr>

						<td>CIC :</td>
						<td style="width: 300px; text-align: center;"><input
							type="hidden" name="CIC"
							value="<%out.print(clientD.getId_client());%>"> <%
 	out.print(clientD.getId_client());
 %></td>
					</tr>
					<tr>
						<td>CNP :</td>
						<td style="width: 300px; text-align: center;">
							<%
								out.print(clientD.getCNP());
							%>
						</td>
					</tr>
					<tr style="height: 20px;">
					</tr>

				</table>
			</div>
			<div class="down" style="border-top: 1px solid balck">
				<table>
					<tr>
						<td>Suma :</td>
						<td>2000 lei <input type="text" name="suma">
							125.000 lei
						</td>
						<td style="width: 300px; text-align: right">Procent Dobanda :
						</td>
						<td><input type="hidden" name="dobanda" value="9.5">
							9.5%</td>
					</tr>
					<tr>
						<td>Perioada :</td>
						<td>1 luna <input type="text" name="perioada"> 60
							luni
						</td>
						<td>
							<%
								
							%>
						</td>
					</tr>
					<tr>
						<td>Data Scadentei :</td>
						<td><input type="date" name="scadenta"></td>
						<td>
							<%
								
							%>
						</td>
					</tr>
					<tr>
						<td><input type="submit" name="submit"
							value="Calculeaza rata"></td>
						<td><input type="submit" name="submit" value="Submit">
						</td>
					</tr>
				</table>
			</div>
			
		</div>
	</form>
</body>
</html>