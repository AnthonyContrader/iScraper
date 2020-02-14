		<table>
			<tr>
				<%if (user.getUsertype().toString()=="ADMIN") {%>
					<th colspan=2> Modifica/Rimuovi </th>
				<%}%>
				<th> ID </th>
				<th> Gravità </th>
				<th> Descrizione </th>
				<th> Data </th>
				<th> Durata </th>
				<th> ID Giocatore </th>
			</tr>
			
			<% for ( InjuryDTO i : list ) { %>
				<tr>
					<%if (user.getUsertype().toString()=="ADMIN") {%>
						<td> <a href="/injury/preupdate?id=<%=i.getId()%>"> <input type=button class="statstable" value="NEW"></a></td>
						<td> <a href="/injury/delete?id=<%=i.getId()%>"> <input type=button class="statstable" value="X"></a></td>
					<%}%>
					<td> <a href="/injury/readinjury?id=<%=i.getId()%>"> <%=i.getId()%> </a></td>
					<td> <%=i.getSeverity()%> </td>
					<td> <%=i.getDescription()%> </td>
					<td> <%=i.getDate()%> </td>
					<td> <%=i.getDuration() %> </td>
					<td> <%=i.getPlayer().getId()%> </td>
				</tr>
			<% } %>
		</table>
	