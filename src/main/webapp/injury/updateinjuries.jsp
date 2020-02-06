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
	<% InjuryDTO i = (InjuryDTO) request.getAttribute("dto"); %>
	
	<br>
		<form id="floatright" action="InjuryServlet?mode=update&id=<%=i.getId() %>" method="post">
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