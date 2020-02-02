package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.dto.InjuryDTO;
import it.contrader.main.MainDispatcher;

import java.util.List;


public class InjuryView extends AbstractView {
	
	private Request request;
	private String choice;
	
	public InjuryView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if(request!=null) {
			System.out.println("\n------------------- Infortuni ----------------\n");
			System.out.println("id\tseverity\tdescription\tduration\tdate\tplayer_id");
			System.out.println("----------------------------------------------------\n");
			
		@SuppressWarnings("unchecked")
			List<InjuryDTO> injuries = (List<InjuryDTO>) request.get("injuries");
			for(InjuryDTO s: injuries)
				System.out.println(s);
			System.out.println();
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		
		this.choice=getInput();
		
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Injury","doControl",this.request);
	}

}
