<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="client.Client"%>
<%@page import="client.ClientData"%>
<%@page import="java.util.*"%>
<%@page import="user.UserLog"%>
<%
	UserLog user = (UserLog) request.getAttribute("user");
	Client customer = (Client) request.getAttribute("customer");
	ArrayList<ClientData> clientD = (ArrayList<ClientData>) request.getAttribute("clientD");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/clientInfo.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ClientInfo" method="post">
		<div class="top">
			<table>
				<tr>
					<td style="color:white">Logged in as : <%out.print(user.getUser());%>
					<input type="hidden" name="user" value="<%out.print(user.getUser()); %>"></td>
					<td><input type="submit" name="submit" value="Log out"></td>
				</tr>
			</table>
		</div>
		<div class="down">
			<div class="splitLeft">
				<div>
				<input type="submit" name="submit" value="Add Diary" style="width:100%;height:50px"><br>
				<input type="submit" name="submit" value="Client Diary" style="width:100%;height:50px"><br>
				</div>
			</div>
			<div class="splitRight">
				<div class="up">
					<table class="table1">
						<tr style="font-weight: bold">
							<td
								style="height: 40px; width: 10x; background-color: white; color: black">
								<%
									out.print(customer.getFirstname() + " " + customer.getLastname());
								%>
							</td>
						</tr>

						<tr>
							<td style="text-align: right; font-weight: bold; width: 50px">
								Localitate:</td>
							<td>
								<%
									out.print(customer.getCity());
								%>
							</td>
							<td style="text-align: right; font-weight: bold; width: 500px">
								Expunere:</td>
							<td>
								<%
									out.print(customer.getExp() + " RON");
								%>
							</td>
						</tr>
						<tr>
							<td style="text-align: right; font-weight: bold">Judet:</td>
							<td>
								<%
									out.print(customer.getRegion());
								%>
							</td>
							<td style="text-align: right; font-weight: bold">
								Delinquency:</td>
							<td>
								<%
									out.print(customer.getDlq() + " RON");
								%>
							</td>
						</tr>

						<tr>
							<td>
						<tr>
							<td style="text-align: right; font-weight: bold">Id Client:
							</td>
							<td>
							<input type="hidden" name="CIC" value="<%out.print(customer.getId_client());%>">
								<%
									out.print(customer.getId_client());
								%>
							</td>
							<td style="text-align: right; font-weight: bold">DPD:</td>
							<td>
								<%
									out.print(customer.getDpd());
								%>
							</td>
						</tr>

						<tr>
							<td style="text-align: right; font-weight: bold">CNP:</td>
							<td>
								<%
									out.print(customer.getCNP());
								%>
							</td>
						</tr>

						<tr>
							<td style="text-align: right; font-weight: bold">Phone :</td>
							<td>
								<%
									out.print(customer.getPhone());
								%>
							</td>
						</tr>
					</table>
				</div>
				<div class="dw">
				
					<table id="dataTable" class="table2">
						<tr>
							<th>No.</th>
							<th style="border-left: 1px solid white;">Product</th>
							<th style="border-left: 1px solid white;">Poduct ID</th>
							<th style="border-left: 1px solid white;">Date Opened</th>
							<th style="border-left: 1px solid white;">Limit</th>
							<th style="border-left: 1px solid white;">Dpd</th>
							<th style="border-left: 1px solid white;">Dlq</th>
							<th style="border-left: 1px solid white;">Currency</th>
						</tr>
						<%
							for (ClientData cd : clientD) {
						%>
						<tr>
							<td style="border: 1px solid black; border-collapse: collapse;">
								<%
									out.print(cd.getNo());
								%>
							</td>
							<td style="border: 1px solid black; border-collapse: collapse;">
								<%
									out.print(cd.getLoan_type());
								%>
							</td>
							<td style="border: 1px solid black; border-collapse: collapse;">
								<%
									out.print(cd.getId_loan());
								%>
							</td>
							<td style="border: 1px solid black; border-collapse: collapse;">
								<%
									out.print(cd.getGrant_date());
								%>
							</td>
							<td style="border: 1px solid black; border-collapse: collapse;">
								<%
									out.print(cd.getLoan_amount());
								%>
							</td>
							<td style="border: 1px solid black; border-collapse: collapse;">
								<%
									out.print(cd.getDpd());
								%>
							</td>
							<td style="border: 1px solid black; border-collapse: collapse;">
								<input type="submit" name="submit"
								value=<%out.print(cd.getDlq());%>
								style="border-style: none; color: blue"></input>

							</td>
							<td style="border: 1px solid black; border-collapse: collapse;">
								<%
									out.print(cd.getCurrency());
								%>
							</td>
						</tr>
						<%
							}
						%>
					</table>
					
				</div>
			</div>
		</div>
	</form>
</body>
</html>