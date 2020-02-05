<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.StatsboxDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Statsbox</title>
</head>
<body>
	<%@ include file="../utilities/header.jsp"%>
	<div class="navbar">
		<a href="homeadmin.jsp">Home</a> <a class="active"
			href="UserServlet?mode=userlist">Users</a> <a href="LogoutServlet"
			id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<br>
		<% StatsboxDTO d = (StatsboxDTO) request.getAttribute("dto");%>
		<table class="statsbox">
		<tr>
			<th> ID </th>
			<th> ID Giocatore </th>
			<th> Stagione </th>
			<th> Presenze </th>
			<th> Contribuzioni/90min </th>
			<th> %Tiri </th>
			<th> Passaggi Chiave/90min </th>
			<th> %Passaggi</th>
			<th> Dribbling/90min </th>
			<th> Falli Subiti/90min </th>
			<th> Falli Commessi /90min </th>
			<th> Tackles/90min </th>
			<th> %Tackles </th>
			<th> Chiusure/90min </th>
		</tr>
		
		<tr>
			<td> <%=d.getId() %> </td>
			<td> <%=d.getPlayerId() %> </td>
			<td> <%=d.getSeason() %> </td>
			<td> <%=d.getCaps() %> </td>
			<td> <%=d.getContributions() %> </td>
			<td> <%=d.getShotsper() %> </td>
			<td> <%=d.getKeypass() %></td>
			<td> <%=d.getPassprec() %></td>
			<td> <%=d.getDribbling() %> </td>
			<td> <%=d.getFoulssub() %> </td>
			<td> <%=d.getFoulscomm() %> </td>
			<td> <%=d.getTackles() %></td>
			<td> <%=d.getTacklesper() %> </td>
			<td> <%=d.getBreaks() %> </td>
			
		</tr>
		</table>

	</div>

	<%@ include file="../utilities/footer.jsp"%>
</body>
</html>