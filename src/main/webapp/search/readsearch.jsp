<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="it.contrader.dto.SearchDTO"
    import="it.contrader.dto.UserDTO"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Search</title>
</head>
<body>
	<%@ include file="../utilities/header.jsp" %>
	<%@ include file="../utilities/navbar.jsp" %>
	<br>
	
	<div class="main">
		<%UserDTO userDTO = (UserDTO)session.getAttribute("user");%>
		<%SearchDTO s = (SearchDTO) request.getSession().getAttribute("dto");%>
		
		
		<table>
			<tr>
				<th>Date</th>
				<th>Indice</th>
				<th>Valore</th>
				<%if (userDTO.getUsertype().toString()=="ADMIN") {%>
				 	<th>Utente</th>
				<%}%>
				<th>Giocatore</th>
			</tr>
			<tr>
				<td><%=s.getSearch_date()%></td>
				<td><%=s.getPlayer_index()%></td>
				<td><%=s.getValue()%></td>
				<%if (userDTO.getUsertype().toString()=="ADMIN") {%>
					<td><%=s.getUser().getId()%></td>
				<%}%>
				<td><%=s.getPlayer().getId()%></td>
			</tr>
		</table>
		
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>
		
		
	</div>
	
	<%@ include file="../utilities/footer.jsp"%>
</body>
</html>