package it.contrader.view.injury;

import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.InjuryController;
import it.contrader.controller.PlayerController;
import it.contrader.controller.Request;
import it.contrader.dto.InjuryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class InjuryReadView implements View{
	private int playerId;
	
	private Request request;
	private final String mode = "READ";

	public InjuryReadView() {
	}

	/**
	 * Se la request � null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo � vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			InjuryDTO injury = (InjuryDTO) request.get("injury");
			System.out.println("PlayerID\tStagione\tSquadra\tPresenze\tContribuzioni\tPercentuale Tiri\tPassChiave\tPrecisionePass\tDribbling\tFalliSub\tFalliComm\tTackles\tTackles%\tbreaks");
			System.out.println("----------------------------------------------------\n");
			System.out.println(injury);
			MainDispatcher.getInstance().callView("Injury", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del giocatore:");
		playerId = Integer.parseInt(getInput());
		
	}
	public String getInput() {
		 Scanner scanner = new Scanner(System.in) ;
			return scanner.nextLine().trim();
		
		 
	}
	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("playerId", playerId);
	
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Injury", "doControl", request);
	}

}