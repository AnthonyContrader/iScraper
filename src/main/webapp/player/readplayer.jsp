<%@page import="it.contrader.dto.PlayerDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.PlayerDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Player</title>
</head>
<body>
	<%@include file="/utilities/header.jsp"%>
	<%@include file="/utilities/navbar.jsp"%>
	<br>

	<div class="main">
		

		
<%
			PlayerDTO player = (PlayerDTO) request.getSession().getAttribute("dto");
		%>

		<table id="newone">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Eta</th>
				<th>Valore Attuale</th>
				<th>Valore Precedente</th>
				<th>Posizione</th>
				<th>Squadra</th>

			</tr>
			<tr>
				<td><%=player.getId()%></td>
				<td><%=player.getPlayer_name()%></td>
				<td><%=player.getPlayer_surname()%></td>
				<td><%=player.getAge()%></td>
				<td><%=player.getActualMarketValue()%></td>
				<td><%=player.getPreviousMarketValue()%></td>
				<td><%=player.getPosition()%></td>
				<td><%=player.getTeam().getName()%></td>
				
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="../utilities/footer.jsp"%>
</body>
</html>