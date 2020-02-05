<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SearchDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Search</title>
</head>
<body>
	<%@ include file="../utilities/header.jsp"%>
	<%@ include file="../utilities/navbar.jsp"%>
	<br>
	<div class="main">
	
		<%SearchDTO s = (SearchDTO) request.getAttribute("dto"); %>
		
		<form id="floatleft" action="SearchServlet?mode=update&id=<%=s.getID()%>" method="post">
			<div class="row">
				<div class="col-25">
					<label for="date">Data</label>
				</div>
				<div class="col-75">
					<input type="text" id="date" name="search_date" value=<%=s.getDate()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="index">Indice</label>
				</div>
				<div class="col-75">
					<input type="text" id="index" name="player_index" value=<%=s.getIndex()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Valore</label>
				</div>
				<div class="col-75">
					<input type="text" id="value" name="player_value" value=<%=s.getValue()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-75">
					<label for="type">Utente</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="user_id" value=<%=s.getUser()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-75">
					<label for="type">Giocatore</label>
				</div>
				<div class="col-75">
					<input type="text" id="player" name="player_id" value=<%=s.getPlayer()%>>
				</div>
			</div>
			<button type="submit">Edit</button>
		</form>
	</div>
	<br>
	<%@ include file="../utilities/footer.jsp"%>
</body>
</html>