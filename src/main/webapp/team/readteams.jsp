<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.TeamDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Squadre - Lettura</title>
</head>
<body>
	<%@ include file="../utilities/header.jsp"%>
	<%@ include file="../utilities/navbar.jsp" %>
	<br>

	<div class="main">
		<br>
		<% TeamDTO t = (TeamDTO) request.getSession().getAttribute("dto");;%>
		<table>
		<tr>
			<th> ID </th>
			<th> Nome </th>
			<th> Valore di Mercato </th>
			<th> Indice </th>
		</tr>
		
		<tr>
			<td> <%=t.getId()%></td>
			<td> <%=t.getName()%> </td>
			<td> <%=t.getMarket_value()%> </td>
			<td> <%=t.getTeam_index()%> </td>
			
		</tr>
		</table>

	</div>

	<%@ include file="../utilities/footer.jsp"%>
</body>
</html>