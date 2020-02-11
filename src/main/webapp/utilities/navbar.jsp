<div class="navbar">

 	<a href="/homeadmin.jsp">Home</a> 
 	<a href="/user/getall">Utenti</a> 
	<a href="PlayerServlet?mode=playerList">Giocatori</a>
	<a href="TeamServlet?mode=teamList">Squadre</a>
	<a href="/statsbox/getall"> Statistiche</a>
	<a href="InjuryServlet?mode=injuryList"> Infortuni</a>
	<a href="SearchServlet?mode=searchlist">Ricerche</a>
	<a href="homeuser.jsp" style="float: right;"id="user1">You are logged in as:  ${user.getUsername()}</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>

