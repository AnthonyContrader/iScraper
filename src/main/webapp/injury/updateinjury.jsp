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
	<% InjuryDTO i = (InjuryDTO) request.getSession().getAttribute("dto"); %>
	
	<br>
		<form id="floatright" action="update" method="post">
			<div class="row">
					<input type="text" id="severity" name="severity" value=<%=i.getSeverity() %>
						placeholder="Gravità">
			</div>
			<div class="row">
					<input type="text" id="description" name="description" value=<%=i.getDescription() %>
						placeholder="Descrizione">
			</div>
			<div class="row">
					<input type="text" id="duration" name="duration" value=<%=i.getDuration() %>
						placeholder="Durata in giorni">
			</div>
			<div class="row">
				<input type="text" id="date" name="date" value=<%=i.getDate() %>
						placeholder="Data">
			</div>
			<div class="row">
				<input type="text" id="player_id" name="player" value=<%=i.getPlayer().getId() %>
						placeholder="ID Giocatore">
			</div>
			<input type="hidden" name="id" value =<%=i.getId()%>>
			<button type="submit">Inserisci</button>
		</form>
	</div>
	<br>
	<%@ include file="../utilities/footer.jsp"%>


</body>
</html>