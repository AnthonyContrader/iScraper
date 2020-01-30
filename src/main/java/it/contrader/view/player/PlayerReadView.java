package it.contrader.view.player;

import com.mysql.cj.util.StringUtils;
import it.contrader.controller.PlayerController;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

import java.util.Scanner;

public class PlayerReadView implements View{

	private PlayerController playerController;
	private Request request;
	
	public PlayerReadView() {
		this.playerController = new PlayerController();
	}
	
	
	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showOptions() {
		
		System.out.println("Inserisci l'ID dell'player da visualizare: ");
		String playerId = getInput();
		if (playerId != null && StringUtils.isStrictlyNumeric(playerId)) {
			System.out.println(playerController.readPlayer(Integer.parseInt(playerId)).toString());
			
		} else {
			System.out.println("Valore inserito errato");
		}
	}
	public String getInput() {
		 Scanner scanner = new Scanner(System.in) ;
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
