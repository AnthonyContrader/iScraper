package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.StatsboxDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Vittorio
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class StatsboxView extends AbstractView {

	private Request request;
	private String choice;

	public StatsboxView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Statistiche ----------------\n");
			System.out.println("PlayerID\tStagione\tSquadra\tPresenze\tContribuzioni\tPercentuale Tiri\tPassChiave\tDribbling\tFalliSub\tFalliComm\tTackles\tTackles%");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<StatsboxDTO> statsboxes = (List<StatsboxDTO>) request.get("statsbox");
			for (StatsboxDTO s: statsboxes)
				System.out.println(s);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo UserController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Statsbox", "doControl", this.request);
	}

}
