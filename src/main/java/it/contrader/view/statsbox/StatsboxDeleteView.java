package it.contrader.view.statsbox;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class StatsboxDeleteView extends AbstractView {
	private Request request;
	private String season;

	private int id;
	private final String mode = "DELETE";

	public StatsboxDeleteView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Statsbox", null);
		}
	}

	/**
	 * Chiede all'utente di inserire l'id dell'utente da cancellare
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci id del giocatore:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci stagione di interesse:");
			season = getInput();

	}

	/**
	 * impacchetta la request con l'id dell'utente da cancellare
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("season", season);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Statsbox", "doControl", request);
	}


}
