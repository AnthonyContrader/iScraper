<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.TeamDTO"%>
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
		List<TeamDTO> list = (List<TeamDTO>) request.getAttribute("list");
	%>
	<br>
	
	<% TeamDTO t = (TeamDTO) request.getAttribute("dto"); %>
		
		<form action="TeamServlet?mode=update&id=<%=t.getId()%>" method="post">
			<div class="row">
				<div class="col-25">
					<label for="name">Nome</label>
				</div>
				<div class="col-75">
					<input type="text" id="name" name="name"
						placeholder="Nome squadra">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="market_value">Valore di mercato</label>
				</div>
				<div class="col-75">
					<input type="text" id="market_value" name="market_value"
						placeholder="Valore di mercato">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="index">Indice</label>
				</div>
				<div class="col-75">
					<input type="text" id="index" name="index"
						placeholder="Indice">
				</div>
			</div>
			<button type="submit">Modifica</button>
		</form>
	</div>
	<br>
	<%@ include file="../utilities/footer.jsp"%>


</body>
</html>