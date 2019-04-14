<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="client.Client"%>
<%
	Client customer = (Client) request.getAttribute("customer");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="AddCredit">
		<div>
			<div class="top">
				<table>
					<tr>
						<td style="width: 300px; text-align: center;">
							<%
								out.print(customer.getNume() + " " + customer.getPrenume());
							%>
						</td>
					</tr>
					<tr>
						<td>CIC :</td>
						<td><input type="hidden" name="CIC"
							value="<%out.print(customer.getId_client());%>">
							<%
								out.print(customer.getId_client());
							%></td>
					</tr>
					<tr>
						<td>CNP :</td>
						<td>
							<%
								out.print(customer.getCNP());
							%>
						</td>
					</tr>

				</table>
			</div>
			<div class="down" style="border-top: 1px solid balck">
				<table>
					<tr>
						<td>
							
								Suma : 
						
						</td>
						<td>
						20.000 <input type="text" name="suma"> 125.000
						</td>
						<td style="width:300px;text-align:right">Procent Dobanda :
						</td>
						<td>
							<input type="hidden" name="dobanda" value="9.5"> 9.5%
						</td>
					</tr>
					<tr>
						<td>Perioada : <select>
								<option value="1">1 an</option>
								<option value="2">2 ani</option>
								<option value="3">3 ani</option>
								<option value="4">4 ani</option>
								<option value="5">5 ani</option>
						</select>
						</td>
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
			<div>
			<table>
			<tr>
			<td>
			
			</td>
			</tr>
			</table>
			
			</div>
		</div>
	</form>
</body>
</html>