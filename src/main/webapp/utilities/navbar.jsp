<div class="navbar">

 	<a href="/homeadmin.jsp">Home</a> 
 	<a href="/user/getall">Utenti</a> 
	<a href="/player/getall">Giocatori</a>
	<a href="TeamServlet?mode=teamList">Squadre</a>
	<a href="/statsbox/getall"> Statistiche</a>
	<a href="InjuryServlet?mode=injuryList"> Infortuni</a>
	<a href="/search/getall">Ricerche</a>
	<a href="/homeuser.jsp" style="float: right; "id="user1">You are logged in as:  ${user.getUsername()}</a>
	<a href="/user/logout" id="logout">Logout</a>
</div>

