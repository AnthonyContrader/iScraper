package it.contrader.view.search;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SearchDeleteView extends AbstractView{
	private Request request;
	private long id;
	private final String mode =  "DELETE";
	
	public SearchDeleteView() {}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine. \n");
			MainDispatcher.getInstance().callView("Search", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'id della ricerca da cancellare: ");
		id = Long.parseLong(getInput());
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("ID", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Search", "doControl", request);
	}
}
