<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.TeamDTO"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title> Squadre </title>
</head>
<body>
	<%@ include file="../utilities/header.jsp"%>
	<%@ include file="../utilities/navbar.jsp"%>
	
	<div class="main">
	<% 
	@SuppressWarnings("unchecked")
		List<TeamDTO> list = (List<TeamDTO>) request.getSession().getAttribute("list");
	%>
	<br>
		<table>
		<tr>
			<th colspan=2> Modifica/Rimuovi </th>
			<th> ID </th>
			<th> Nome </th>
			<th> Valore di Mercato </th>
			<th> Indice </th>
		</tr>
		
		<% for ( TeamDTO t : list ) { %>
		<tr>
			<td> <a href=preupdate?id=<%=t.getId()%>> <input type=button class="statstable" value="NEW"></a></td>
			<td> <a href=delete?id=<%=t.getId()%>> <input type=button class="statstable" value="X"></a></td>
			<td> <a href=read?id=<%=t.getId()%>> <%=t.getId()%> </a></td>
			<td> <%=t.getName()%> </td>
			<td> <%=t.getMarket_value()%> </td>
			<td> <%=t.getTeam_index()%> </td>
			
		</tr>
		<% } %>
		</table>
		
		<form id="floatright" action="insert" method="post">
			<p>${messaggio}</p>
			<div class="row">
				<div class="col-25">
					<label for="name">Nome</label>
				</div>
				<div class="col-75">
					<input type="text" id="name" name="name"
						placeholder="Nome squadra">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="market_value">Valore di mercato</label>
				</div>
				<div class="col-75">
					<input type="text" id="market_value" name="market_value"
						placeholder="Valore di mercato">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="index">Indice</label>
				</div>
				<div class="col-75">
					<input type="text" id="team_index" name="team_index"
						placeholder="Indice">
				</div>
			</div>
			<button type="submit">Inserisci</button>
		</form>
	</div>
	<br>
	<%@ include file="../utilities/footer.jsp"%>


</body>
</html>