<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.SearchUserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Search Manager</title>
</head>
<body>
	<%@ include file="../utilities/header.jsp"%>
	<%@ include file="../utilities/usernavbar.jsp" %>
	<div class="main">
		<%List<SearchUserDTO> list = (List<SearchUserDTO>) request.getAttribute("list");%>

		<br>

		<table>
			<tr>
				<th>Date</th>
				<th>Player's index</th>
				<th>Player's value</th>
				<th>Player's id</th>
				<th></th>
				<th></th>
			</tr>
			<%for (SearchUserDTO s : list) {%>
			<tr>
				<td><a href=SearchServlet?mode=read&id=<%=s.getID()%>><%=s.getDate()%></a></td>
				<td><%=s.getIndex()%></td>
				<td><%=s.getValue()%></td>
				<td><%=s.getPlayer()%></td>
				<td><a href=SearchServlet?mode=delete&id=<%=s.getID()%>>Delete</a></td>
			</tr>
			<%}%>
		</table>
	</div>
	<br>
	<%@ include file="../utilities/footer.jsp"%>
</body>
</html>