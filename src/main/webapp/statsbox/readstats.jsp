<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.StatsboxDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Statistiche - Lettura</title>
</head>
<body>
	<%@ include file="../utilities/header.jsp"%>
	<%@ include file="../utilities/navbar.jsp" %>
	<br>

	<div class="main">
		<br>
		<% StatsboxDTO d = (StatsboxDTO) request.getSession().getAttribute("dto");%>
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
			<td> <%=d.getPlayer().getId() %> </td>
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