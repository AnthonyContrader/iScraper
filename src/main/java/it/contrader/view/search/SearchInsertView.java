package it.contrader.view.search;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class SearchInsertView extends AbstractView{
	private Request request;
	private Date search_date;
	private int value, index, user;
	private short player;
	private final String mode = "INSERT";
	
	public SearchInsertView() {}
	
	@Override
	public void showResults(Request request) {
		if(request!=null) {
			System.out.println("Inserimento andato a buon fine. \n");
			MainDispatcher.getInstance().callView("Search", null);			
		}
	}
	
	@Override
	public void showOptions() {
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
		System.out.println("Inserisci l'id del giocatore su cui si � effettuata la ricerca: ");
		player = Short.parseShort(getInput());
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("search_date", search_date);
		request.put("player_value", value);
		request.put("player_index", index);
		request.put("user_id", user);
		request.put("player_id", player);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Search", "doControl", request);
	}
}