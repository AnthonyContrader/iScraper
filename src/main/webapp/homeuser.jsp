<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IScraper</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
	<%@include file="utilities/header.jsp"%>
	<%@include file="utilities/usernavbar.jsp"%>


	

	<div class="main">
		<h1>Welcome, ${user.getUsername()!}</h1>
		<h2>IScraper è l'innovativa web-app a supporto di allenatori, società ed appassionati di Serie A. Sfruttando la tecnica dello scraping, sarà possibile ottenere una previsione realistica dell'andamento della prossima stagione, per qualsiasi giocatore tesserato per il campionato di Serie A. Le nostre previsioni sono create raccogliendo i dati personali delle stagioni passate del giocatore, incrociandoli con i profili di tutti i giocatori simili transistati dal nostro campionato negli ultimi 20 anni. Non ci credete? Metteteci alla prova!</h2>
		<br>
		<h3>GET STARTED</h3>
		<form id="floatleft" class="user">
			<div class="row">
				<div class="col-14">
					<label for="player_name"> Nome: </label>
				</div>
				<div class="col-19">
					<input type="text" id="player_name" name="player_name" placeholder="Nome"> 
				</div>
				<div class="col-14">
					<label for="player_name"> Cognome: </label>
				</div>
				<div class="col-19">
					<input type="text" id="player_surname" name="player_surname" placeholder="Cognome"> 
				</div>
				<div class="col-33">
					<button type="submit"> Cerca giocatore</button>
				</div>
			</div>
		</form>
	</div>


	<%@ include file="utilities/footer.jsp"%>

</body>
</html>