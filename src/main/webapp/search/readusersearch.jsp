<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SearchUserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Search</title>
</head>
<body>
	<%@ include file="../utilities/header.jsp" %>
	<%@ include file="../utilities/usernavbar.jsp" %>
	<br>
	
	<div class="main">
		<%SearchUserDTO s = (SearchUserDTO) request.getAttribute("dto");%>
		
		
		<table>
			<tr>
				<th>Date</th>
				<th>Indice</th>
				<th>Valore</th>
				<th>Giocatore</th>
			</tr>
			<tr>
				<td><%=s.getDate()%></td>
				<td><%=s.getIndex()%></td>
				<td><%=s.getValue()%></td>
				<td><%=s.getPlayer()%></td>
			</tr>
		</table>
		
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>
		
		
	</div>
	
	<%@ include file="../utilities/footer.jsp"%>
</body>
</html>