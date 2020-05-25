<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="clientInfo.DiaryInfo"%>
<%@page import="client.Client"%>
<%@page import="client.ClientData"%>
<%@page import="java.util.*"%>
<%@page import="user.UserLog"%>
<%
	UserLog user = (UserLog) request.getAttribute("user");
Client customer = (Client) request.getAttribute("customer");
ArrayList<ClientData> clientD = (ArrayList<ClientData>) request.getAttribute("clientD");
ArrayList<DiaryInfo> di =  (ArrayList<DiaryInfo>) request.getAttribute("di");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/clientInfo.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ClientDiary" method="post">
		<input type="hidden" name="CIC" value="<%out.print(customer.getId_client());%>">
		<input type="hidden" name="user" value="<%out.print(user.getUser());%>">
		<div class="top">
			<table>
				<tr>
					<td style="color: white">Logged in as : <%
						out.print(user.getUser());
					%>
						<input type="hidden" name="user"
						value="<%out.print(user.getUser());%>"></td>
					<td><input type="submit" name="submit" value="Log out"></td>
				</tr>
			</table>
		</div>
		<div class="down">
			<div class="splitLeft">
				<div>
					<input type="submit" name="submit" value="Add Diary"
						style="width: 100%; height: 50px"><br> <input
						type="submit" name="submit" value="Client Diary"
						style="width: 100%; height: 50px"><br>
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
							<td><input type="hidden" name="CIC"
								value="<%out.print(customer.getId_client());%>"> <%
 	out.print(customer.getId_client());
 %></td>
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
					<table >
						<tr>
							<th>No.</th>
							<th style="border-left: 1px solid white;">User</th>
							<th style="border-left: 1px solid white;">Action Type</th>
							<th style="border-left: 1px solid white;">Action Description</th>
							<th style="border-left: 1px solid white;">Date of Action</th>
							<th style="border-left: 1px solid white;">Time of Action</th>
						</tr>
						<%
							for (DiaryInfo d : di) {
						%>
						
						<tr>
							
							<td style="border: 1px solid black; border-collapse: collapse;width:10px;">
								<input type="hidden" name="CIC" value="<%out.print(d.getCIC());%>">
								<%
									out.print(d.getNo());
								%>
							</td>
							<td style="border: 1px solid black; border-collapse: collapse;width:60px;">
								<%
									out.print(d.getUser());
								%>
								<input type="hidden" name="user" value="<%out.print(d.getUser());%>">
							</td>
							<td style="border: 1px solid black; border-collapse: collapse;width:100px;">
								<%
									out.print(d.getAction());
								%>
							</td>
							<td style="border: 1px solid black; border-collapse: collapse;width:600px;">
								<%
									out.print(d.getActiondes());
								%>
							</td>
							<td style="border: 1px solid black; border-collapse: collapse;width:100px;">
								<%
									out.print(d.getDate());
								%>
							</td>
							<td style="border: 1px solid black; border-collapse: collapse;width:140px;">
								<%
									out.print(d.getTime());
								%>
							</td>
							
						</tr>
						<%
							}
						%>
					</table><br>
					<input type="submit" name="submit" value="Back">
				</div>
			</div>
		</div>
	</form>
</body>
</html>