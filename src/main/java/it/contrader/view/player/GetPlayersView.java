package it.contrader.view.player;

import it.contrader.controller.PlayerController;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Player;
import it.contrader.view.View;

import java.util.ArrayList;
import java.util.Scanner;



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
		//System.out.println("Sei sicuro di stampare intera lista? yes per si ");
		ArrayList<Player> lista= new ArrayList<Player>(playerController.getPlayers());
		for(Player player:lista) {
			System.out.println(player);
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
