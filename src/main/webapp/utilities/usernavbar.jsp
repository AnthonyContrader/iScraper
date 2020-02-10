<div class="navbar">

 	<a href="homeuser.jsp">Home</a> 
 	
	
	<a href="PlayerServlet?mode=playerList">Giocatori</a>
	<a href="TeamServlet?mode=teamList">Squadre</a>
	<a href="StatsboxServlet?mode=statsboxList"> Statistiche</a>
	<a href="InjuryServlet?mode=injuryList"> Infortuni</a>
	<a href="SearchServlet?mode=searchlist">Ricerche</a>
	<a href="homeuser.jsp" style="float: right;"id="user1">You are logged in as:  ${user.getUsername()}</a>
	
	
	<a href="LogoutServlet" id="logout">Logout</a>
</div>