package it.contrader.view.player;

import java.util.Scanner;

import it.contrader.controller.PlayerController;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Player;
import it.contrader.view.View;

public class PlayerUpdateView implements View {

	 int player_id;
	 String player_name;
	 String player_surname;
	 int age;
	 int actualValue;
	 int previousValue;
	 String position;
	 private final String mode = "UPDATE";
	
	
	
	
//	private PlayerController playerController;
	private Request request;

	

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Aggiornamento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Player", null);
		}
	}

	@Override
	public void showOptions() {
		
		/*
		 * List<User> users; Integer usersId; String password; users =
		 * usersController.getAllUsers();
		 */
		System.out.println("\n----- Seleziona player da modificate  -----\n");
		// System.out.println();
		// users.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		
		
		try {
			System.out.println("Digita l'Id dell'player da modificare:");
			player_id = Integer.parseInt(getInput());
			
		
				System.out.println("Digita il nuovo nome:");
				player_name = getInput();
				

				System.out.println("Digita il nuovo cognome:");
				player_surname = getInput();
				

				System.out.println("Digita la nuova eta:");
				age = Integer.parseInt(getInput());
				

				System.out.println("Digita il nuovo valore actuale di mercato:");
				actualValue = Integer.parseInt(getInput());
				

				System.out.println("Digita il nuovo valore precedente di mercato:");
				previousValue = Integer.parseInt(getInput());
				
				System.out.println("Digita la nuova posizione: ");
				position = getInput();
				
				//System.out.println(player);
			
				

			
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Hai inserito un valore errato");
		}

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
		request.put("actualValue", actualValue);
		request.put("previousValue", previousValue);
		request.put("position", position);
		
		
		request.put("mode", mode);
	//	request.put("choice", "");
		MainDispatcher.getInstance().callAction("Player", "doControl", request);
	}

}
