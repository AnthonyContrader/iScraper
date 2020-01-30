package it.contrader.view.statsbox;

import it.contrader.controller.Request;
import it.contrader.dto.StatsboxDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class StatsboxReadView extends AbstractView {

	private int playerId;
	private String season;
	private Request request;
	private final String mode = "READ";

	public StatsboxReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			StatsboxDTO statsbox = (StatsboxDTO) request.get("statsbox");
			System.out.println("PlayerID\tStagione\tSquadra\tPresenze\tContribuzioni\tPercentuale Tiri\tPassChiave\tPrecisionePass\tDribbling\tFalliSub\tFalliComm\tTackles\tTackles%\tbreaks");
			System.out.println("----------------------------------------------------\n");
			System.out.println(statsbox);
			MainDispatcher.getInstance().callView("Statsbox", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del giocatore:");
		playerId = Integer.parseInt(getInput());
		System.out.println("Inserisci la stagione di interesse (scrivi * per tutte le stagioni)");
		season=getInput();
	}

	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("playerId", playerId);
		request.put("season", season);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Statsbox", "doControl", request);
	}

}