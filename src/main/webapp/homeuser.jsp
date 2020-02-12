
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Homepage for User">
<meta name="author" content="Vittorio Valent">
<title>IScraper</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/vittoriostyle.css" rel="stylesheet">

</head>
<body>
	<%@include file="utilities/header.jsp"%>
	<%@include file="utilities/usernavbar.jsp"%>


	

	<div class="main">
		<h1>Welcome, ${user.getUsername()}!</h1>
		<h2>IScraper è l'innovativa web-app a supporto di allenatori, società ed appassionati di Serie A. Sfruttando la tecnica dello scraping, sarà possibile ottenere una previsione realistica dell'andamento della prossima stagione, per qualsiasi giocatore tesserato per il campionato di Serie A. Le nostre previsioni sono create raccogliendo i dati personali delle stagioni passate del giocatore, incrociandoli con i profili di tutti i giocatori simili transistati dal nostro campionato negli ultimi 20 anni. Non ci credete? Metteteci alla prova!</h2>
		<br>
		<h3>GET STARTED</h3>
	</div>


	<%@ include file="utilities/footer.jsp"%>

</body>
</html>