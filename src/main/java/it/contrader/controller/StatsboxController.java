package it.contrader.controller;

import java.util.List;

import it.contrader.dto.StatsboxDTO;

import it.contrader.main.MainDispatcher;
import it.contrader.service.StatsboxService;


public class StatsboxController implements Controller{
private static String sub_package = "statsbox.";
	
	private StatsboxService statsboxService;
	
	public StatsboxController() {
		this.statsboxService = new StatsboxService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		 int playerId;
		 String season;
		 String team;
		 int caps; //questo campo indica le presenze in questa stagione in campionato
		 float contributions; //questo campo indica le contribuzioni (gol o assist, che valgono rispettivamente 1 e 0.5) per 90 minuti di quel giocatore
		 float shotsper; //questo campo indica la percentuale di tiri in porta su tiri totali del giocatore, su 90 minuti
		 float keypass; //questo campo indica i passaggi chiave effettuati, su 90 minuti
		 float passprec; //questo campo indica la precisione dei passaggi (passaggi riusciti/passaggi effettuati)
		 float dribbling; //questo campo indica il numero di dribbling riusciti per partita
		 float foulssub; //falli subiti a partita
		 float foulscomm; //falli fatti a partita
		 float tackles; //contrasti effettuati a partita
		 float tacklesper; //percentuale di contrasti riusciti a partita
		 float breaks; 

		switch (mode) {
		
		
		case "READ":
			playerId = Integer.parseInt(request.get("playerId").toString());
			season = request.get("season").toString();
			StatsboxDTO statsboxDTO = statsboxService.read(playerId, season);
			request.put("statsbox", statsboxDTO);
			MainDispatcher.getInstance().callView(sub_package + "StatsboxRead", request);
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			playerId = Integer.parseInt(request.get("playerId").toString());
			season = request.get("season").toString();
			team = request.get("team").toString();
			caps = Integer.parseInt(request.get("caps").toString());
			contributions = Float.parseFloat(request.get("contributions").toString());
			shotsper = Float.parseFloat(request.get("shotsper").toString());
			keypass = Float.parseFloat(request.get("keypass").toString());
			passprec = Float.parseFloat(request.get("passprec").toString());
			dribbling = Float.parseFloat(request.get("dribbling").toString());
			foulssub = Float.parseFloat(request.get("foulssub").toString());
			foulscomm = Float.parseFloat(request.get("foulscomm").toString());
			tackles = Float.parseFloat(request.get("tackles").toString());
			tacklesper = Float.parseFloat(request.get("tacklesper").toString());
			breaks = Float.parseFloat(request.get("breaks").toString());
			
			//costruisce l'oggetto user da inserire
			StatsboxDTO statstoinsert = new StatsboxDTO(playerId, season, team, caps, contributions, shotsper, keypass, passprec, dribbling, foulssub, foulscomm, tackles, tacklesper, breaks);
			//invoca il service
			statsboxService.insert(statstoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "StatsboxInsert", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			playerId = Integer.parseInt(request.get("playerId").toString());
			season = request.get("season").toString();
			//Qui chiama il service
			statsboxService.delete(playerId, season);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "StatsboxDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			playerId = Integer.parseInt(request.get("playerId").toString());
			season = request.get("season").toString();
			team = request.get("team").toString();
			caps = Integer.parseInt(request.get("caps").toString());
			contributions = Float.parseFloat(request.get("contributions").toString());
			shotsper = Float.parseFloat(request.get("shotsper").toString());
			keypass = Float.parseFloat(request.get("keypass").toString());
			passprec = Float.parseFloat(request.get("passprec").toString());
			dribbling = Float.parseFloat(request.get("dribbling").toString());
			foulssub = Float.parseFloat(request.get("foulssub").toString());
			foulscomm = Float.parseFloat(request.get("foulscomm").toString());
			tackles = Float.parseFloat(request.get("tackles").toString());
			tacklesper = Float.parseFloat(request.get("tacklesper").toString());
			breaks = Float.parseFloat(request.get("breaks").toString());
			StatsboxDTO statstoupdate = new StatsboxDTO(playerId, season, team, caps, contributions, shotsper, keypass, passprec, dribbling, foulssub, foulscomm, tackles, tacklesper, breaks);
			
			statsboxService.update(statstoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "StatsboxUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "STATSBOXLIST":
			List<StatsboxDTO> statsDTO = statsboxService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("statsbox", statsDTO);
			MainDispatcher.getInstance().callView("Statsbox", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "StatsboxRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "StatsboxInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "StatsboxUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "StatsboxDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
