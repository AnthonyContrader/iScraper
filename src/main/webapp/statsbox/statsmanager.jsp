<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.StatsboxDTO"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title> Statistiche </title>
</head>
<body>
	<%@ include file="../utilities/header.jsp"%>
	<%@ include file="../utilities/navbar.jsp"%>
	
	<div class="main">
	<% 
		List<StatsboxDTO> list = (List<StatsboxDTO>) request.getAttribute("list");
	%>
	<br>
		<table class="statsbox" max-width=104%>
		<tr>
			<th> ID </th>
			<th> ID Giocatore </th>
			<th> Stagione </th>
			<th> Squadra </th>
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
		
		<% for ( StatsboxDTO d : list ) { %>
		<tr>
			<td> <%=d.getId() %> </td>
			<td> <%=d.getPlayerId() %> </td>
			<td> <%=d.getSeason() %> </td>
			<td> <%=d.getTeam() %></td>
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
		<% } %>
		</table>
		
		<form id="floatbottom" class="statsbox" action="StatsboxServlet?mode=insert" method="post">
			<div class="row">
				<div class="col-18">
					<label for="user">Giocatore</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="id" name="player_id"
						placeholder="Id giocatore">
				</div>
				<div class="col-18">
					<label for="pass">Stagione</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="season" name="season"
						placeholder="Stagione">
				</div>
				<div class="col-18">
					<label for="pass">Squadra</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="team" name="team"
						placeholder="Squadra">
				</div>
			</div>
			<div class="row">
				<div class="col-18">
					<label for="pass">Presenze</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="caps" name="caps"
						placeholder="Presenze">
				</div>
				<div class="col-18">
					<label for="type">Contribuzioni (gol e assist)</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="contributions" name="contributions"
						placeholder="Contribuzioni">
				</div>
				<div class="col-18">
					<label for="type">Percentuale tiri</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="shotsper" name="shotsper"
						placeholder="Percentuale tiri">
				</div>
			</div>
			<div class="row">
				<div class="col-18">
					<label for="type">Passaggi chiave</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="keypass" name="keypass"
						placeholder="Passaggi chiave">
				</div>
				<div class="col-18">
					<label for="type">Percentuale passaggi riusciti</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="passprec" name="passprec"
						placeholder="Percentuale passaggi">
				</div>
				<div class="col-18">
					<label for="type">Dribbling</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="dribbling" name="dribbling"
						placeholder="Dribbling">
				</div>
			</div>
			<div class="row">
				<div class="col-18">
					<label for="type">Falli subiti</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="foulssub" name="foulssub"
						placeholder="Falli subiti">
				</div>
				<div class="col-18">
					<label for="type">Falli fatti</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="foulscomm" name="foulscomm"
						placeholder="Falli fatti">
				</div>
				<div class="col-18">
					<label for="type">Tackles</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="tackles" name="tackles"
						placeholder="Tackles">
				</div>
			</div>
			<div class="row">
				<div class="col-18">
					<label for="type">Percentuale Tackles</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="tacklesper" name="tacklesper"
						placeholder="Percentuale Tackles">
				</div>
				<div class="col-18">
					<label for="type">Chiusure</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="breaks" name="breaks"
						placeholder="Chiusure">
				</div>
			</div>
		</form>
</div>


</body>
</html>