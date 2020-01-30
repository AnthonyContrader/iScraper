package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;
	private Request request;

	@Override
	public void showResults(Request request) {
		if (request!=null) {
		System.out.println("Benvenuto in IScraper");
		}

	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("Seleziona su che tabella lavorare");
		System.out.println("\n[G]iocatori [I]nfortuni [T]eams [S]tatistiche [E]sci");
		choice = this.getInput();

	}

	@Override
	public void submit() {
		request = new Request();

		switch (choice) {

		case "g":
			this.request.put("mode", "PLAYERLIST");
			MainDispatcher.getInstance().callAction("Players", "doControl", request);
			break;
		case "i":
			this.request.put("mode", "INJURYLIST");
			MainDispatcher.getInstance().callAction("Injuries", "doControl", request);
			break;
		case "t":
			this.request.put("mode", "TEAMLIST");
			MainDispatcher.getInstance().callAction("Teams", "doControl", request);
			break;
		case "s":
			this.request.put("mode", "STATSBOXLIST");
			MainDispatcher.getInstance().callAction("Statsbox", "doControl", request);
			break;
			
		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		default:
			request.put("choice", choice);
			MainDispatcher.getInstance().callAction("Login", "doControl", request);
		}
	}

}
