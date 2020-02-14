<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.TeamDTO"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title> Statistiche </title>
</head>
<body>
	<%@ include file="../utilities/header.jsp"%>
	<%@ include file="../utilities/usernavbar.jsp"%>
	
	<div class="main">
	<% 
	@SuppressWarnings("unchecked")
		List<TeamDTO> list = (List<TeamDTO>) request.getSession().getAttribute("list");
	%>
	<br>
		<table>
		<tr>
			<th> ID </th>
			<th> Nome </th>
			<th> Valore di Mercato </th>
			<th> Indice </th>
		</tr>
		
		<% for ( TeamDTO t : list ) { %>
		<tr>
			<td> <a href="team/read?id=<%=t.getId()%>"> <%=t.getId()%> </a></td>
			<td> <%=t.getName()%> </td>
			<td> <%=t.getMarket_value()%> </td>
			<td> <%=t.getTeam_index()%> </td>
			
		</tr>
		<% } %>
		</table>
		
				<form id="floatright" action="/team/readbyname" method="get">
			<p>${messaggio}</p>
			<div class="row">
				<div class="col-25">
					<label for="name">Cerca per nome</label>
				</div>
				<div class="col-75">
					<input type="text" id="name" name="name"
						placeholder="Nome squadra">
				</div>
			</div>
			<button type="submit">Inserisci</button>
		</form>
	<br>
	</div>
	<%@ include file="../utilities/footer.jsp"%>


</body>
</html>