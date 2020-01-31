package it.contrader.controller;

import it.contrader.dto.PlayerDTO;
import it.contrader.dto.StatsboxDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Player;
import it.contrader.service.PlayerService;

import java.util.List;


public class PlayerController implements Controller{

	private static String sub_package = "player.";
	private PlayerService playerService;
	
	 int player_id;
	 String player_name;
	 String player_surname;
	 int age;
	 int actualMarketValue;
	 int previousMarketValue;
	 private String position;
	 private final String mode = "INSERT";
	
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
		
		
		switch (mode) {
		case "PLAYERLIST":
			List<PlayerDTO> playerDTO = playerService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("player", playerDTO);
			MainDispatcher.getInstance().callView("Player", request);
			break;
		
		case "INSERT":
			player_id = Integer.parseInt(request.get("player_id").toString());
			
			player_name = request.get("player_name").toString();
			player_surname = request.get("player_surname").toString();
			age = Integer.parseInt(request.get("age").toString());
			actualMarketValue = Integer.parseInt(request.get("actualMarketValue").toString());
			previousMarketValue = Integer.parseInt(request.get("previousMarketValue").toString());
			position = request.get("position").toString();
			
			
			//costruisce l'oggetto user da inserire
			PlayerDTO playertoinsert = new PlayerDTO(player_id, player_name, player_surname, age, actualMarketValue, previousMarketValue, position);
			//invoca il service
			playerService.insert(playertoinsert);
			request = new Request();
			request.put("mode", mode);
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "PlayerInsert", request);
			break;

		default:
			break;
		}
		
		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Player", null);
		} else {
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "PlayerRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "PlayerInsert", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "PlayerDelete", null);
				break;
			case "V":
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

