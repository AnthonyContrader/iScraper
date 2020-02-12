<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.PlayerDTO"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Player Manager</title>
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
				<td> <a href=player/read&id=<%=s.getId()%>> <%=s.getId()%></a></td>
			
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
			
		<form id="floatleft" action="player/insert" method="post">
		
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
				</div>
			</div>
			<div class="row">

				<div class="col-25">

					<label for="type">Valoare precedente</label>
				</div>
				<div class="col-75">
					<input type="text" id="previous_value" name="previous_value"
						placeholder="inserisci il valore precedente">
				</div>
			</div>


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

			<button type="submit">Insert</button>
		</form>

<br>
<br>
		<form id="floatright" action="player/update" method="post">
	
			<div class="row">
				<div class="col-25">
					<label for="type">ID</label>
				</div>
				<div class="col-75">
					<input type="text" id="id" name="id" placeholder="inserisci il id">
				</div>
			</div>
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
				</div>
			</div>
			<div class="row">

				<div class="col-25">

					<label for="type">Valoare precedente</label>
				</div>
				<div class="col-75">
					<input type="text" id="previous_value" name="previous_value"
						placeholder="inserisci il valore precedente">
				</div>
			</div>


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
		
		
		<form id="floatright" style="margin-top: 5%;
		margin-bottom: 1%;" action="player/delete" method="post">
			
			<div class="row">
				<div class="col-25">
					<label for="date">Player ID</label>
				</div>
				<div class="col-75">
					<input type="text" id="id" name="id" placeholder="inserisci il id">
				</div>
			</div>
			
			<button type="submit">Cancela</button>
		</form>
	</div>
	<br>
	<%@ include file="../utilities/footer.jsp"%>
</body>
</html>
