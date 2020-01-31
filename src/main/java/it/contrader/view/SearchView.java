package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.dto.SearchDTO;
import it.contrader.main.MainDispatcher;

import java.util.List;

public class SearchView extends AbstractView{
	private Request request;
	private String choice;
	
	public SearchView() {}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Gestione utenti\n");
			System.out.println("id\nData\nValore\nIndice\nUtente\nGiocatore");
			@SuppressWarnings("unchecked")
			List<SearchDTO> searches = (List<SearchDTO>) request.get("searches");
			for (SearchDTO s: searches) System.out.println(s);
			System.out.println();
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		choice=getInput();
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Search", "doControl", request);
	}
}
