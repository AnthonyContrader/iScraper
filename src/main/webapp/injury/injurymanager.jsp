<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.InjuryDTO"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title> Infortuni </title>
</head>
<body>
	<%@ include file="../utilities/header.jsp"%>
	<%@ include file="../utilities/navbar.jsp"%>
	
	<div class="main">
	<% 
		@SuppressWarnings("unchecked")
		List<InjuryDTO> list = (List<InjuryDTO>) request.getAttribute("list");
	%>
	<br>
		<table>
		<tr>
			<th colspan=2> Modifica/Rimuovi </th>
			<th> ID </th>
			<th> Gravità </th>
			<th> Descrizione </th>
			<th> Data </th>
			<th> ID Giocatore </th>
		</tr>
		
		<% for ( InjuryDTO i : list ) { %>
		<tr>
			<td> <a href=InjuryServlet?mode=read&update=true&id=<%=i.getId()%>> <input type=button class="statstable" value="NEW"></a></td>
			<td> <a href=InjuryServlet?mode=delete&id=<%=i.getId()%>> <input type=button class="statstable" value="X"></a></td>
			<td> <a href=InjuryServlet?mode=read&id=<%=i.getId()%>> <%=i.getId()%> </a></td>
			<td> <%=i.getSeverity()%> </td>
			<td> <%=i.getDescription()%> </td>
			<td> <%=i.getDate()%> </td>
			<td> <%=i.getPlayer_id()%> </td>
			
		</tr>
		<% } %>
		</table>
		
		<form id="floatright" action="InjuryServlet?mode=insert" method="post">
			<div class="row">
					<input type="text" id="severity" name="severity"
						placeholder="Gravità">
			</div>
			<div class="row">
					<input type="text" id="description" name="description"
						placeholder="Descrizione">
			</div>
			<div class="row">
					<input type="text" id="duration" name="duration"
						placeholder="Durata in giorni">
			</div>
			<div class="row">
				<input type="text" id="date" name="date"
						placeholder="Data">
			</div>
			<div class="row">
				<input type="text" id="player_id" name="player_id"
						placeholder="ID Giocatore">
			</div>
			<button type="submit">Inserisci</button>
		</form>
	</div>
	<br>
	<%@ include file="../utilities/footer.jsp"%>


</body>
</html>