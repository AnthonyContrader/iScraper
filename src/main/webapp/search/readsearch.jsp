<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SearchDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Search</title>
</head>
<body>
	<%@ include file="../css/header.jsp" %>
	<div class="navbar">
		<a href="homeadmin.jsp">Home</a> <a
		href="UserServlet?mode=userlist">Users</a> <a class="active"
		href="SearchServlet?mode=searchlist">Searches</a> <a href="LogoutServlet"
		id="logout">Logout</a>
	</div>
	<br>
	
	<div class="main">
		<%SearchDTO s = (SearchDTO) request.getAttribute("dto");%>
		
		
		<table>
			<tr>
				<th>Date</th>
				<th>Indice</th>
				<th>Valore</th>
				<th>Utente</th>
				<th>Giocatore</th>
			</tr>
			<tr>
				<td><%=s.getDate()%></td>
				<td><%=s.getIndex()%></td>
				<td><%=s.getValue()%></td>
				<td><%=s.getUser()%></td>
				<td><%=s.getPlayer()%></td>
			</tr>
		</table>
		
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>
		
		
	</div>
	
	<%@ include file="../css/footer.jsp"%>
</body>
</html>