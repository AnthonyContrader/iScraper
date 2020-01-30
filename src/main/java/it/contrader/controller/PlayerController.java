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
	
	
	public  PlayerController() {
		// TODO Auto-generated constructor stub
		this.playerService=new PlayerService();
				
			
	}
	
	public List<Player> getPlayers(){
		return this.playerService.getAllPlayers();
	}
	
	public boolean insertPlayer(Player player) {
		return this.playerService.insertPlayer(player);
	}
	
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
		
//		case "INSERT":
//			playerId = Integer.parseInt(request.get("playerId").toString());
//			season = Integer.parseInt(request.get("season").toString());
//			team = request.get("team").toString();
//			caps = Integer.parseInt(request.get("caps").toString());
//			contributions = Float.parseFloat(request.get("contributions").toString());
//			shotsper = Float.parseFloat(request.get("shotsper").toString());
//			keypass = Float.parseFloat(request.get("keypass").toString());
//			passprec = Float.parseFloat(request.get("passprec").toString());
//			dribbling = Float.parseFloat(request.get("dribbling").toString());
//			foulssub = Float.parseFloat(request.get("foulssub").toString());
//			foulscomm = Float.parseFloat(request.get("foulscomm").toString());
//			tackles = Float.parseFloat(request.get("tackles").toString());
//			tacklesper = Float.parseFloat(request.get("tacklesper").toString());
//			breaks = Float.parseFloat(request.get("breaks").toString());
//			
//			//costruisce l'oggetto user da inserire
//			StatsboxDTO statstoinsert = new StatsboxDTO(playerId, season, team, caps, contributions, shotsper, keypass, passprec, dribbling, foulssub, foulscomm, tackles, tacklesper, breaks);
//			//invoca il service
//			statsboxService.insert(statstoinsert);
//			request = new Request();
//			request.put("mode", "mode");
//			//Rimanda alla view con la risposta
//			MainDispatcher.getInstance().callView(sub_package + "StatsboxInsert", request);
//			break;

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

