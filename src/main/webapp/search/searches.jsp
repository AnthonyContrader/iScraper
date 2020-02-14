<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="java.util.List"
    import="java.util.Calendar"
    import="it.contrader.dto.SearchDTO"
    import="it.contrader.dto.UserDTO"
    import="java.text.SimpleDateFormat"
%>
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
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		String formatted = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString();
		%>

		<br>
		<%if (userDTO.getUsertype().toString()=="ADMIN") {%>
		 	<%@ include file="../search/adminsearchpanel.jsp"%>
		 	<%@ include file="../search/insertsearch.jsp"%>
		 <%} else if (userDTO.getUsertype().toString()=="USER") { %>
		 	<%@ include file="../search/usersearchpanel.jsp"%>
		 <%} %>
	</div>
	<br>
	<%@ include file="../utilities/footer.jsp"%>
</body>
</html>