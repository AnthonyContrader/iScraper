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
	<%@ include file="../utilities/usernavbar.jsp"%>
	
	<div class="main">
	<% 
		List<TeamDTO> list = (List<TeamDTO>) request.getAttribute("list");
	%>
	<br>
		<table>
		<tr>
			<th> ID </th>
			<th> Nome </th>
			<th> Valore di Mercato </th>
			<th> Indice </th>
		</tr>
		
		<% for ( TeamDTO t : list ) { %>
		<tr>
			<td> <a href=TeamServlet?mode=read&id=<%=t.getId()%>> <%=t.getId()%> </a></td>
			<td> <%=t.getName()%> </td>
			<td> <%=t.getMarketValue()%> </td>
			<td> <%=t.getIndex()%> </td>
			
		</tr>
		<% } %>
		</table>
	<br>
	<%@ include file="../utilities/footer.jsp"%>


</body>
</html>