package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;

	@Override
	public void showResults(Request request) {
		System.out.println("Benvenuto in IScraper");

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

		switch (choice) {

		case "g":
			MainDispatcher.getInstance().callAction("Player", "doControl", null);
			break;
		case "i":
			MainDispatcher.getInstance().callAction("Injuries", "doControl", null);
			break;
		case "t":
			MainDispatcher.getInstance().callAction("Teams", "doControl", null);
			break;
		case "s":
			MainDispatcher.getInstance().callAction("Statsbox", "doControl", null);
			break;
			
		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
