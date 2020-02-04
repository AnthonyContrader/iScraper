<%@page import="it.contrader.dto.PlayerDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.SearchDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Player</title>
</head>
<body>
	<%@include file="/utilities/header.jsp"%>
	<%@include file="/utilities/navbar.jsp"%>
	<br>

	<div class="main">
		

		
<%
			PlayerDTO player = (PlayerDTO) request.getAttribute("dto");
		%>

		<table>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Eta</th>
				<th>Valore Attuale</th>
				<th>Valore Precedente</th>
				<th>Posizione</th>
				<th>Squadra</th>

			</tr>
			<tr>
				<td><%=player.getName()%></td>
				<td><%=player.getSurname()%></td>
				<td><%=player.getActualMarketValue()%></td>
				<td><%=player.getPreviousMarketValue()%></td>
				<td><%=player.getPosition()%></td>
				<td><%=player.getTeam()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../css/footer.jsp"%>
</body>
</html>