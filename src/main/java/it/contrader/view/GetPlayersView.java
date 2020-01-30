package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.PlayerController;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class GetPlayersView implements View {

	private PlayerController playerController;
	private Request request;
	
	public  GetPlayersView() {
	
		this.playerController = new PlayerController();
	}
	
	
	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("Sei sicuro di stampare intera lista? yes per si ");
		
		
		
		String response = getInput();

		if (response != null && response.equals("yes")) {
			System.out.println(playerController.getPlayers().toString());
			
		} else {
			System.out.println("Valore inserito errato");
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
