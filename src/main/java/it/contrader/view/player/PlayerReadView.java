package it.contrader.view.player;

import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.PlayerController;
import it.contrader.controller.Request;
import it.contrader.view.View;

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
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
		
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		
	}
	
	

}
