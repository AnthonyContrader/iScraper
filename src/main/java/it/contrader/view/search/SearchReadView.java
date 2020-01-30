package it.contrader.view.search;

import it.contrader.controller.Request;
import it.contrader.dto.SearchDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SearchReadView extends AbstractView{
	
	private long id;
	private Request request;
	private final String mode = "READ";
	
	public SearchReadView() {}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			SearchDTO search = (SearchDTO) request.get("search");
			System.out.println(search);
			MainDispatcher.getInstance().callView("Search", null);
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'id della ricerca: ");
		id = Long.parseLong(getInput());
	}
	
	@Override
	public void submit() {
		request =  new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Search", "doControl", request);
	}
}
