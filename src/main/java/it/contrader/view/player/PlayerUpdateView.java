package it.contrader.view.player;

import java.util.Scanner;

import it.contrader.controller.PlayerController;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Player;
import it.contrader.view.View;

public class PlayerUpdateView implements View {

	private PlayerController playerController;
	private Request request;

	public PlayerUpdateView() {
		this.playerController = new PlayerController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int playerIdToUpdate;
		String player_name, player_surname, position;
		int age, actualValue, previousValue;
		/*
		 * List<User> users; Integer usersId; String password; users =
		 * usersController.getAllUsers();
		 */
		System.out.println("\n----- Seleziona player da modificate  -----\n");
		// System.out.println();
		// users.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		Player player = new Player();

		System.out.println("Digita l'Id dell'player da modificare:");
		try {
			playerIdToUpdate = Integer.parseInt(getInput());
			if (playerIdToUpdate != 0) {
				 player.setId(playerIdToUpdate);

				System.out.println("Digita il nuovo nome:");
				player_name = getInput();
				if (!player_name.equals(""))
					player.setName(player_name);

				System.out.println("Digita il nuovo cognome:");
				player_surname = getInput();
				if (!player_surname.equals(""))
					player.setSurname(player_name);

				System.out.println("Digita la nuova eta:");
				age = Integer.parseInt(getInput());
				if (age != 0)
					player.setAge(age);

				System.out.println("Digita il nuovo valore actuale di mercato:");
				actualValue = Integer.parseInt(getInput());
				if (actualValue != 0)
					player.setActualMarketValue(actualValue);

				System.out.println("Digita il nuovo valore precedente di mercato:");
				previousValue = Integer.parseInt(getInput());
				if (previousValue != 0)
					player.setPreviousMarketValue(previousValue);

				System.out.println("Digita la nuova posizione: ");
				position = getInput();
				if (!position.equals(""))
					player.setPosition(position);
				System.out.println(player);
				playerController.updatePlayer(player);
				

			}
		} catch (Exception e) {
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
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Player", "doControl", request);
	}

}
