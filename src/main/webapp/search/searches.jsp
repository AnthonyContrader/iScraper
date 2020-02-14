<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="java.util.Calendar"
    import="it.contrader.dto.SearchDTO" import="it.contrader.dto.UserDTO"
    import="java.text.SimpleDateFormat"%>
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
		@SuppressWarnings("unchecked")
		List<SearchDTO> list = (List<SearchDTO>) request.getSession().getAttribute("list");
		//@SuppressWarnings("unchecked")
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
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
				<td><a href="/search/readsearch?id=<%=s.getId()%>"><%=s.getSearch_date()%></a></td>
				<td><%=s.getPlayer_index()%></td>
				<td><%=s.getValue()%></td>
				<td><%=s.getUser().getId()%></td>
				<td><%=s.getPlayer().getId()%></td>
				<td><a href="/search/preupdate?id=<%=s.getId()%>">Edit</a></td>
				<td><a href="/search/delete?id=<%=s.getId()%>">Delete</a>
				</td>
			</tr>
			<%
			}
		%>
		</table>



		<form id="floatright" action="/search/insert" method="post">
			<p> ${messaggio} </p>
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
					<input type="text" id="index" name="index"
						placeholder="inserisci l'indice del giocatore">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Valore</label>
				</div>
				<div class="col-75">
					<input type="text" id="value" name="value"
						placeholder="inserisci il valore del giocatore">
				</div>
			</div>
			<div class="row">
				<div class="col-75">
					<label for="type">Utente</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="user"
						placeholder="inserisci l'id dell'utente" value="<%=userDTO.getId()%>">
				</div>
			</div>
			<div class="row">
				<div class="col-75">
					<label for="type">Giocatore</label>
				</div>
				<div class="col-75">
					<input type="text" id="player" name="player"
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