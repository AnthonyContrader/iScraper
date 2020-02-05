<%@page import="it.contrader.dto.PlayerDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/player.css" rel="stylesheet">
<title>Player User Manager</title>
</head>
<body>
<br>
	<%@include file="/utilities/header.jsp"%>
	<%@include file="/utilities/usernavbar.jsp"%>
	
	<div class="main">
		<%
			List<PlayerDTO> list = (List<PlayerDTO>) request.getAttribute("list");
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
			<%
				for (PlayerDTO s : list) {
			%>
			<tr>
				<td> <a href=PlayerServlet?mode=read&id=<%=s.getId()%>> <%=s.getId()%> </a></td>
				<td><%=s.getName()%></td>
				<td><%=s.getSurname()%></td>
				<td><%=s.getAge()%></td>
				<td><%=s.getActualMarketValue()%></td>
				<td><%=s.getPreviousMarketValue()%></td>
				<td><%=s.getPosition()%></td>
				<td><%=s.getTeam()%></td>
				

			</tr>
			<%
				}
			%>
		</table>

<br>
			
		</div>
	<%@ include file="../utilities/footer.jsp"%>
</body>
</html>
