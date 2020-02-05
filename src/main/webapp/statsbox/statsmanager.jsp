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
		<table class="statsbox">
		<tr>
			<th> ID </th>
			<th> ID Giocatore </th>
			<th> Stagione </th>
			<th> Presenze </th>
			<th> Contribuzioni/90min </th>
			<th> %Tiri </th>
			<th> Passaggi Chiave/90min </th>
			<th> %Passaggi</th>
			<th> Dribbling/90min </th>
			<th> Falli Subiti/90min </th>
			<th> Falli Commessi/90min </th>
			<th> Tackles/90min </th>
			<th> %Tackles </th>
			<th> Chiusure/90min </th>
		</tr>
		
		<% for ( StatsboxDTO d : list ) { %>
		<tr>
			<td> <a href=StatsboxServlet?mode=read&id=<%=d.getId()%>> <%=d.getId() %> </a></td>
			<td> <a href=PlayerServlet?mode=read&id=<%=d.getPlayerId()%>> <%=d.getPlayerId() %> </a></td>
			<td> <%=d.getSeason() %> </td>
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
					<input class="statsbox" type="text" id="player_id" name="player_id"
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
					<label for="pass">Presenze</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="caps" name="caps"
						placeholder="Presenze">
				</div>
			</div>
			<div class="row">
				<div class="col-18">
					<label for="type">Contribuzioni</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="contributions" name="contributions"
						placeholder="Contribuzioni">
				</div>
				<div class="col-18">
					<label for="type">%Tiri</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="shotsper" name="shotsper"
						placeholder="Percentuale tiri">
				</div>
				<div class="col-18">
					<label for="type">Passaggi chiave</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="keypass" name="keypass"
						placeholder="Passaggi chiave">
				</div>
			</div>
			<div class="row">
				<div class="col-18">
					<label for="type">%Passaggi</label>
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
				<div class="col-18">
					<label for="type">Falli subiti</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="foulssub" name="foulssub"
						placeholder="Falli subiti">
				</div>
			</div>
			<div class="row">
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
				<div class="col-18">
					<label for="type">%Tackles</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="tacklesper" name="tacklesper"
						placeholder="Percentuale Tackles">
				</div>
			</div>
			<div class="row">
				<div class="col-18">
					<label for="type">Chiusure</label>
				</div>
				<div class="col-12">
					<input class="statsbox" type="text" id="breaks" name="breaks"
						placeholder="Chiusure">
				</div>
				<div class="col-18">
				</div>
				<div class="col-12">
				</div>
				<div class="col-18">
				</div>
				<div>
					<button type="submit" class="statsbox" >Inserisci</button>
				</div>
			</div>
		</form>
</div>


</body>
</html>