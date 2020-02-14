<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.InjuryDTO" 
	import="it.contrader.dto.PlayerDTO"
	import="it.contrader.dto.UserDTO"
	%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title> Infortuni </title>
</head>
<body>
	<%@ include file="../utilities/header.jsp"%>
	<%@ include file="../utilities/navbar.jsp"%>
	
	<div class="main">
		<% 
			@SuppressWarnings("unchecked")
			List<InjuryDTO> list = (List<InjuryDTO>) request.getSession().getAttribute("list");
			UserDTO user = (UserDTO) request.getSession().getAttribute("user");
		%>
		<%@ include file="../injury/injuriespanel.jsp"%>
		<br>
		<%if (user.getUsertype().toString()=="ADMIN") {%>
			<%@ include file="../injury/insertinjury.jsp"%>
		<%}%>
	</div>
	<br>
	<%@ include file="../utilities/footer.jsp"%>


</body>
</html>