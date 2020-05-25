<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="clientInfo.DiaryInfo"%>
      <%@page import="java.util.*"%>
      <%@page import="client.Client"%>
    <%@page import="user.UserLog"%>
      
	
<%
	ArrayList<DiaryInfo> di =  (ArrayList<DiaryInfo>) request.getAttribute("di");
	Client customer = (Client) request.getAttribute("customer");
	UserLog user = (UserLog) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/clientInfo.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<form action="ClientDiary" method="post">
<input type="hidden" name="CIC" value="<%out.print(customer.getId_client());%>">
<input type="hidden" name="user" value="<%out.print(user.getUser());%>">

<table id="dataTable" class="table2">
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

</form>
</html>