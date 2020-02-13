<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SearchDTO"
    import="it.contrader.model.User" import="it.contrader.model.Player"%>
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
	
		<%SearchDTO s = (SearchDTO) request.getSession().getAttribute("dto"); %>
		
		<form id="floatleft" action="/search/update" method="post">
			<p>${messaggio}</p>
			<div class="row">
				<div class="col-25">
					<label for="date">Data</label>
				</div>
				<div class="col-75">
					<input type="date" id="date" name="search_date" value=<%=s.getSearch_date()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="index">Indice</label>
				</div>
				<div class="col-75">
					<input type="text" id="index" name="index" value=<%=s.getPlayer_index()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Valore</label>
				</div>
				<div class="col-75">
					<input type="text" id="value" name="value" value=<%=s.getValue()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-75">
					<label for="type">Utente</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="user" value=<%=s.getUser().getId()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-75">
					<label for="type">Giocatore</label>
				</div>
				<div class="col-75">
					<input type="text" id="player" name="player" value=<%=s.getPlayer().getId()%>>
				</div>
			</div>
			<input type="hidden" name="id" value =<%=s.getId()%>>
			<button type="submit">Edit</button>
		</form>
	</div>
	<br>
	<%@ include file="../utilities/footer.jsp"%>
</body>
</html>