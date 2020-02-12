<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.StatsboxDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Statsbox</title>
</head>
<body>
	<%@ include file="../utilities/header.jsp"%>
	<%@ include file="../utilities/navbar.jsp" %>
	<br>
	<div class="main">

		<%StatsboxDTO s = (StatsboxDTO) request.getAttribute("dto");%>


		<form id="floatbottom" class="statsbox" action="/statsbox/update?id=<%=s.getId()%>" method="post">
			<div class="row">
				<div class="col-19">
					<label for="user">Giocatore</label>
				</div>
				<div class="col-14">
					<input class="statsbox" type="text" id="player_id" name="player_id"
						value=<%s.getPlayerId(); %>>
				</div>
				<div class="col-19">
					<label for="pass">Stagione</label>
				</div>
				<div class="col-14">
					<input class="statsbox" type="text" id="season" name="season"
						value=<%s.getSeason(); %>>
				</div>
				<div class="col-19">
					<label for="pass">Presenze</label>
				</div>
				<div class="col-14">
					<input class="statsbox" type="text" id="caps" name="caps"
						value=<%s.getCaps(); %>>
				</div>
			</div>
			<div class="row">
				<div class="col-19">
					<label for="type">Contribuzioni</label>
				</div>
				<div class="col-14">
					<input class="statsbox" type="text" id="contributions" name="contributions"
						value=<%s.getContributions(); %>>
				</div>
				<div class="col-19">
					<label for="type">%Tiri</label>
				</div>
				<div class="col-14">
					<input class="statsbox" type="text" id="shotsper" name="shotsper"
						value=<%s.getShotsper(); %>>
				</div>
				<div class="col-19">
					<label for="type">Passaggi chiave</label>
				</div>
				<div class="col-14">
					<input class="statsbox" type="text" id="keypass" name="keypass"
						value=<%s.getKeypass(); %>>
				</div>
			</div>
			<div class="row">
				<div class="col-19">
					<label for="type">%Passaggi</label>
				</div>
				<div class="col-14">
					<input class="statsbox" type="text" id="passprec" name="passprec"
						value=<%s.getPassprec(); %>>
				</div>
				<div class="col-19">
					<label for="type">Dribbling</label>
				</div>
				<div class="col-14">
					<input class="statsbox" type="text" id="dribbling" name="dribbling"
						value=<%s.getDribbling(); %>>
				</div>
				<div class="col-19">
					<label for="type">Falli subiti</label>
				</div>
				<div class="col-14">
					<input class="statsbox" type="text" id="foulssub" name="foulssub"
						value=<%s.getFoulssub(); %>>
				</div>
			</div>
			<div class="row">
				<div class="col-19">
					<label for="type">Falli fatti</label>
				</div>
				<div class="col-14">
					<input class="statsbox" type="text" id="foulscomm" name="foulscomm"
						value=<%s.getFoulscomm(); %>>
				</div>
				<div class="col-19">
					<label for="type">Tackles</label>
				</div>
				<div class="col-14">
					<input class="statsbox" type="text" id="tackles" name="tackles"
						value=<%s.getTackles(); %>>
				</div>
				<div class="col-19">
					<label for="type">%Tackles</label>
				</div>
				<div class="col-14">
					<input class="statsbox" type="text" id="tacklesper" name="tacklesper"
						value=<%s.getTacklesper(); %>>
				</div>
			</div>
			<div class="row">
				<div class="col-19">
					<label for="type">Chiusure</label>
				</div>
				<div class="col-14">
					<input class="statsbox" type="text" id="breaks" name="breaks"
						value=<%s.getBreaks(); %>>
				</div>
				<div class="col-66">
					<button type="submit" >Modifica</button>
				</div>
			</div>
		</form>


	</div>
	<br>
	<%@ include file="../utilities/footer.jsp"%>
</body>
</html>