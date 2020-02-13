<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.PlayerDTO"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<link href="/css/player.css" rel="stylesheet">
<title>Player User</title>
</head>
<body>
<br>
	<%@include file="../utilities/header.jsp"%>
	<%@include file="../utilities/navbar.jsp"%>
	
	<div class="main">
		<%
		@SuppressWarnings("unchecked")
			List<PlayerDTO> list = (List<PlayerDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table id="newone" >
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
			
			<% for (PlayerDTO s : list) {%>
			<tr>
				<td> <a href=read?id=<%=s.getId()%>> <%=s.getId()%></a></td>
			
				<td><%=s.getPlayer_name()%></td>
				<td><%=s.getPlayer_surname()%></td>
				<td><%=s.getAge()%></td>
				<td><%=s.getActualMarketValue()%></td>
				<td><%=s.getPreviousMarketValue()%></td>
				<td><%=s.getPosition()%></td>
				<td><%=s.getTeam().getName()%></td>
				

			</tr>
			<%}%>
		</table>

<br>
			
		</div>
	<%@ include file="../utilities/footer1.jsp"%>
</body>
</html>
