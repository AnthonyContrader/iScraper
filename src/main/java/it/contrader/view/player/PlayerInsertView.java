package it.contrader.view.player;

import it.contrader.controller.GestoreEccezzioni;
import it.contrader.controller.PlayerController;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

import java.util.Scanner;

public class PlayerInsertView implements View {

	int player_id;
	String player_name;
	String player_surname;
	int age;
	int actualMarketValue;
	int previousMarketValue;
	String position;
	private final String mode = "INSERT";
	private PlayerController playerController;
	private Request request;

	public PlayerInsertView() {
		this.playerController = new PlayerController();
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Player", null);
		} else {
			
			//System.out.println("Error");
		}

	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci playerID:");
		player_id = Integer.parseInt(getInput());
		System.out.println("Inserisci nome:");
		player_name = getInput();
		System.out.println("Inserisci cognome:");
		player_surname = getInput();
		System.out.println("Inserisci eta:");
		age = Integer.parseInt(getInput());
		System.out.println("Inserisci valore attuale di mercato:");
		actualMarketValue = Integer.parseInt(getInput());
		System.out.println("Inserisci valore precedente:");
		previousMarketValue = Integer.parseInt(getInput());
		System.out.println("Inserisci posizione:");
		position = getInput();

	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("player_id", player_id);
		request.put("player_name", player_name);
		request.put("player_surname", player_surname);
		request.put("age", age);
		request.put("actualMarketValue", actualMarketValue);
		request.put("previousMarketValue", previousMarketValue);
		request.put("position", position);

		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Player", "doControl", request);
	}

}
