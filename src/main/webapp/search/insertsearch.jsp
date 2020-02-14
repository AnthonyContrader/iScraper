		<form id="floatright" action="/search/insert" method="post">
			<p> ${messaggio} </p>
			<div class="row">
				<div class="col-25">
					<label for="date">Date</label>
				</div>
				<div class="col-75">
					<input type="date" id="date" name="search_date"
						placeholder="inserisci la data della ricerca" value="<%=formatted%>" required>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="index">Indice</label>
				</div>
				<div class="col-75">
					<input type="text" id="index" name="index"
						placeholder="inserisci l'indice del giocatore">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Valore</label>
				</div>
				<div class="col-75">
					<input type="text" id="value" name="value"
						placeholder="inserisci il valore del giocatore">
				</div>
			</div>
			<div class="row">
				<div class="col-75">
					<label for="type">Utente</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="user"
						placeholder="inserisci l'id dell'utente" value="<%=userDTO.getId()%>">
				</div>
			</div>
			<div class="row">
				<div class="col-75">
					<label for="type">Giocatore</label>
				</div>
				<div class="col-75">
					<input type="text" id="player" name="player"
						placeholder="inserisci l'id del giocatore">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>