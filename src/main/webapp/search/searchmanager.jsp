<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="java.util.Calendar"
    import="it.contrader.dto.SearchDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Search Manager</title>
</head>
<body>
	<%@ include file="../utilities/header.jsp"%>
	<%@ include file="../utilities/navbar.jsp" %>
	<div class="main">
		<%
		List<SearchDTO> list = (List<SearchDTO>) request.getAttribute("list");
		String userId = request.getAttribute("userId").toString();
		String formatted = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString();
		%>

		<br>

		<table>
			<tr>
				<th>Date</th>
				<th>Player's index</th>
				<th>Player's value</th>
				<th>User's id</th>
				<th>Player's id</th>
				<th></th>
				<th></th>
			</tr>
			<%
			for (SearchDTO s : list) {
		%>
			<tr>
				<td><a href=SearchServlet?mode=read&id=<%=s.getID()%>><%=s.getDate()%></a></td>
				<td><%=s.getIndex()%></td>
				<td><%=s.getValue()%></td>
				<td><%=s.getUser()%></td>
				<td><%=s.getPlayer()%></td>
				<td><a href=SearchServlet?mode=read&update=true&id=<%=s.getID()%>>Edit</a></td>
				<td><a href=SearchServlet?mode=delete&id=<%=s.getID()%>>Delete</a>
				</td>

			</tr>
			<%
			}
		%>
		</table>



		<form id="floatright" action="SearchServlet?mode=insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="date">Date</label>
				</div>
				<div class="col-75">
					<input type="date" id="date" name="search_date"
						placeholder="inserisci la data della ricerca" value="<%=formatted%>" required>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="index">Indice</label>
				</div>
				<div class="col-75">
					<input type="text" id="index" name="player_index"
						placeholder="inserisci l'indice del giocatore">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Valore</label>
				</div>
				<div class="col-75">
					<input type="text" id="value" name="player_value"
						placeholder="inserisci il valore del giocatore">
				</div>
			</div>
			<div class="row">
				<div class="col-75">
					<label for="type">Utente</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="user_id"
						placeholder="inserisci l'id dell'utente" value="<%=userId%>">
				</div>
			</div>
			<div class="row">
				<div class="col-75">
					<label for="type">Giocatore</label>
				</div>
				<div class="col-75">
					<input type="text" id="player" name="player_id"
						placeholder="inserisci l'id del giocatore">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../utilities/footer.jsp"%>
</body>
</html>