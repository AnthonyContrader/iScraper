package it.contrader.view.search;

import java.sql.Date;
import java.text.SimpleDateFormat;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SearchUpdateView extends AbstractView{
	Request request;
	private long id;
	private Date search_date;
	private int value, index, user;
	private short player;
	private final String mode = "UPDATE";
	
	public SearchUpdateView() {}
	
	@Override
	public void showResults(Request request) {
		if(request!=null) {
			System.out.println("Modifica andata a buon fine. \n");
			MainDispatcher.getInstance().callView("Search", null);
		}
	}
	
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci l'id della ricerca: ");
			id = Long.parseLong(getInput());
			System.out.println("Inserisci la data della ricerca: ");
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				java.util.Date parsed = format.parse(getInput());
				search_date = new Date(parsed.getTime());
			} catch (Exception e) {} //Cercare eccezione specifica
			System.out.println("Inserisci il valore del giocatore: ");
			value = Integer.parseInt(getInput());
			System.out.println("Inserisci l'indice del giocatore: ");
			index = Integer.parseInt(getInput());
			System.out.println("Inserisci l'id dell'utente che ha effettuato la ricerca: ");
			user = Integer.parseInt(getInput());
			System.out.println("Inserisci l'id del giocatore su cui si è effettuata la ricerca: ");
			player = Short.parseShort(getInput());
		} catch (Exception e) {}
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("ID", id);
		request.put("search_date", search_date);
		request.put("player_value", value);
		request.put("player_index", index);
		request.put("user_id", user);
		request.put("player_id", player);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Search", "doControl", request);
	}
}