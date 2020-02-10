<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.InjuryDTO"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title> Infortuni - Lettura </title>
</head>
<body>
	<%@ include file="../utilities/header.jsp"%>
	<%@ include file="../utilities/usernavbar.jsp"%>
	
	<div class="main">
	<% 
	@SuppressWarnings("unchecked")
		List<InjuryDTO> list = (List<InjuryDTO>) request.getAttribute("list");
	%>
	<br>
		<table>
		<tr>
			<th> ID </th>
			<th> Gravità </th>
			<th> Descrizione </th>
			<th> Data </th>
			<th> ID Giocatore </th>
		</tr>
		
		<% for ( InjuryDTO i : list ) { %>
		<tr>
			<td> <a href=InjuryServlet?mode=read&id=<%=i.getId()%>> <%=i.getId()%> </a></td>
			<td> <%=i.getSeverity()%> </td>
			<td> <%=i.getDescription()%> </td>
			<td> <%=i.getDate()%> </td>
			<td> <%=i.getPlayer_id()%> </td>
			
		</tr>
		<% } %>
		</table>
		<br>
	</div>
	<%@ include file="../utilities/footer.jsp"%>


</body>
</html>