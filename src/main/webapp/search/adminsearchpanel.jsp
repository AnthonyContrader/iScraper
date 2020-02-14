		<table>
			<tr>
				<th>Date</th>
				<th>Player's index</th>
				<th>Player's value</th>
				<th>User's id</th>
				<th>Player's id</th>
				<th></th>
				<th></th>
			</tr>
			<%
			for (SearchDTO s : list) {
		%>
			<tr>
				<td><a href="/search/readsearch?id=<%=s.getId()%>"><%=s.getSearch_date()%></a></td>
				<td><%=s.getPlayer_index()%></td>
				<td><%=s.getValue()%></td>
				<td><%=s.getUser().getId()%></td>
				<td><%=s.getPlayer().getId()%></td>
				<td><a href="/search/preupdate?id=<%=s.getId()%>">Edit</a></td>
				<td><a href="/search/delete?id=<%=s.getId()%>">Delete</a>
				</td>
			</tr>
			<%
			}
		%>
		</table>