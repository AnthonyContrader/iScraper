package it.contrader.view.injury;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class InjuryUpdateView extends AbstractView{

	private Request request;

	private int id;
	private int severity;
	private String description;
	private int duration;
	private String date;
	private int player_id;
	private final String mode = "UPDATE";

	public InjuryUpdateView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode update del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Aggiornamento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Injury", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci id infortunio:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci gravità infortunio:");
			severity = Integer.parseInt(getInput());
			System.out.println("Inserisci durata:");
			duration = Integer.parseInt(getInput());
			System.out.println("Inserisci descrizione:");
			description = getInput();
			System.out.println("Inserisci data:");
			date = getInput();
			System.out.println("Inserisci id giocatore:");
			player_id = Integer.parseInt(getInput());
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("severity", severity);
		request.put("duration", duration);
		request.put("description", description);
		request.put("date", date);
		request.put("player_id", player_id);
		
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Injury", "doControl", request);
	}

}
