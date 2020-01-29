package it.contrader.controller;

import java.util.List;

import it.contrader.main.MainDispatcher;
import it.contrader.model.Player;
import it.contrader.service.PlayerService;


public class PlayerController implements Controller{

	private static String sub_package = "player.";
	private PlayerService playerService;
	private Request request;
	
	
	public  PlayerController() {
		// TODO Auto-generated constructor stub
		this.playerService=new PlayerService();
				
			
	}
	
	public List<Player> getPlayers(){
		return this.playerService.getAllPlayers();
	}
	
//	public boolean insertPlayer(Player player) {
//		return this.playerService.insertPlayer(player);
//	}
	
	public Player readPlayer(int player_id) {
		return this.playerService.readPlayer(player_id);
	}
	
//	public boolean updatePlayer(Player player) {
//		return this.playerService.updatePlayer(player);
//	}
	public boolean deletePlayer(int id) {
		return this.playerService.deletePlayer(id);
		
		
	}
	
	
	
	
	
	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Player", null);
		} else {
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "PlayerRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "PlayerDelete", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "GetPlayers", null);
				break;
			
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}

		
	}
	
}
