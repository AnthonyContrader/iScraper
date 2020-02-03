package it.contrader.view.search;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

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
		String str;
		try {
			System.out.println("Inserisci l'id della ricerca: ");
			id = Long.parseLong(getInput());
			System.out.println("Inserisci la data della ricerca (giorno/mese/anno): ");
			try {
				SimpleDateFormat format = new SimpleDateFormat("dMyyyy");
				format.setTimeZone(TimeZone.getTimeZone("UTC"));
				java.util.Date parsed = format.parse(getInput());
				search_date = new Date(parsed.getTime());
			} catch (Exception e) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				format.setTimeZone(TimeZone.getTimeZone("UTC"));
				java.util.Date parsed = format.parse("2020-02-21");
				search_date = new Date(parsed.getTime());
			} //Cercare eccezione specifica
			System.out.println("Inserisci il valore del giocatore: ");
			str=getInput();
			if (str.isEmpty() || str == null) {
				value = 0;
			} else {
				value = Integer.parseInt(str);
			}
			System.out.println("Inserisci l'indice del giocatore: ");
			str=getInput();
			if (str.isEmpty() || str == null) {
				index = 0;
			} else {
				index = Integer.parseInt(str);
			}
			System.out.println("Inserisci l'id dell'utente che ha effettuato la ricerca: ");
			str=getInput();
			if (str.isEmpty() || str == null) {
				user = 0;
			} else {
				user = Integer.parseInt(str);
			}
			System.out.println("Inserisci l'id del giocatore su cui si è effettuata la ricerca: ");
			str=getInput();
			if (str.isEmpty() || str == null) {
				value = 0;
			} else {
				player = Short.parseShort(str);
			}
		} catch (Exception e) {}
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("search_id", id);
		request.put("search_date", search_date);
		request.put("player_value", value);
		request.put("player_index", index);
		request.put("user_id", user);
		request.put("player_id", player);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Search", "doControl", request);
	}
}