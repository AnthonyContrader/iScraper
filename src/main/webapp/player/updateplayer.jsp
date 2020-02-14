
<%@page import="java.util.List"%>
<%@page import="it.contrader.dto.PlayerDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SearchDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Player</title>
</head>
<body>
	<%@include file="/utilities/header.jsp"%>
	<%@include file="/utilities/navbar.jsp"%>
	<br>
	<div class="main">
	
		<%
		@SuppressWarnings("unchecked")
			List<PlayerDTO> list = (List<PlayerDTO>) request.getAttribute("list");
		%>

		<br>

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
			<%
				for (PlayerDTO s : list) {
			%>
			<tr>

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
			<form id="floatright" action="PlayerServlet?mode=update" method="post">
			<div class="row">
				<div class="col-25">
					<label for="date">Nome</label>
				</div>
				<div class="col-75">
					<input type="text" id="player_name" name="player_name"
						placeholder="inserisci il nome">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="index">Cognome</label>
				</div>
				<div class="col-75">
					<input type="text" id="player_surname" name="player_surname"
						placeholder="inserisci il cognome">
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-25">
					<label for="type">Eta</label>
				</div>
				<div class="col-75">
					<input type="text" id="eta" name="age"
						placeholder="inserisci l'eta del giocatore">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="type">Valoare attuale</label>
				</div>
			<div class="col-75">
					<input type="text" id="actual_value" name="actual_value"
						placeholder="inserisci il valore attuale">
				</div></div>
				<div class="row">
				
			<div class="col-25">
			
					<label for="type">Valoare attuale</label>
				</div>
				<div class="col-75">
					<input type="text" id="previous_value" name="previous_value"
						placeholder="inserisci il valore precedente">
				</div></div>
				
				
			<div class="row">
				<div class="col-25">
					<label for="type">Posizione</label>
				</div>
				<div class="col-75">
					<input type="text" id="position" name="position"
						placeholder="inserisci la posizione">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="type">Squadra</label>
				</div>
				<div class="col-75">
					<input type="text" id="team" name="team"
						placeholder="inserisci la squadra">
				</div>
			</div>
			
			<button type="submit">Edit</button>
		</form>
		
		
	</div>
	<br>
	<%@ include file="../utilities/footer.jsp"%>
</body>
</html>