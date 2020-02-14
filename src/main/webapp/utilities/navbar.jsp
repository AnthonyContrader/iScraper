<%@page import="it.contrader.dto.UserDTO"%>
<div class="navbar">

 	<a href="/homeadmin.jsp">Home</a> 
 	<!--  CODICE TEMPORANEO PER FORNIRE UN OGGETTO USER ALLA NAVBAR -->
 	<% it.contrader.dto.UserDTO navbarUser = (it.contrader.dto.UserDTO) request.getSession().getAttribute("user"); %>
 	<% if (navbarUser.getUsertype().toString()=="ADMIN") { %>
	 	<a href="/user/getall">Utenti</a>
	<%} %>
	<a href="/player/getall">Giocatori</a>
	<a href="/team/getall">Squadre</a>
	<a href="/statsbox/getall"> Statistiche</a>
	<a href="/injury/getall"> Infortuni</a>
	<a href="/search/getall">Ricerche</a>
	<a href="/homeuser.jsp" style="float: right; "id="user1">You are logged in as:  ${user.getUsername()}</a>
	<a href="/user/logout" id="logout">Logout</a>
</div>

