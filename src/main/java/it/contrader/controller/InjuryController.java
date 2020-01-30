package it.contrader.controller;

import it.contrader.dto.InjuryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.InjuryService;

import java.util.List;

public class InjuryController implements Controller {

	private static String sub_package = "injury.";
	private InjuryService injuryService;
	
	public InjuryController() {
		this.injuryService=new InjuryService();
	}
	
	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		int playerID;
		String typology;
		int duration;
		int gravityIndex;
		int season;
		
		switch(mode) {
		
		case "READ":
			playerID = Integer.parseInt(request.get("playerID").toString());
			season = Integer.parseInt(request.get("season").toString());
			InjuryDTO injuryDTO = injuryService.read(playerID, season);
			request.put("injury", injuryDTO);
			MainDispatcher.getInstance().callView(sub_package+"InjuryRead", request);
			break;
		
		case "INSERT":
			playerID = Integer.parseInt(request.get("playerID").toString());
			typology = request.get("typology").toString();
			duration = Integer.parseInt(request.get("duration").toString());
			gravityIndex = Integer.parseInt(request.get("gravityIndex").toString());
			season = Integer.parseInt(request.get("season").toString());
			
			InjuryDTO injuryToInsert = new InjuryDTO(playerID,typology,duration,gravityIndex,season);
			injuryService.insert(injuryToInsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "InjuryInsert", request);
			break;
			
		case "DELETE":
			playerID = Integer.parseInt(request.get("playerID").toString());
			season = Integer.parseInt(request.get("season").toString());
			injuryService.delete(playerID, season);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "InjuryDelete", request);
			break;
			
		case "UPDATE":
			playerID = Integer.parseInt(request.get("playerID").toString());
			typology = request.get("typology").toString();
			duration = Integer.parseInt(request.get("duration").toString());
			gravityIndex = Integer.parseInt(request.get("gravityIndex").toString());
			season = Integer.parseInt(request.get("season").toString());
			
			InjuryDTO injuryToUpdate = new InjuryDTO(playerID,typology,duration,gravityIndex,season);
			injuryService.update(injuryToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "InjuryUpdate", request);
			break;
			
		case "INJURYLIST":
			List<InjuryDTO> dto = injuryService.getAll();
			request.put("statsbox", dto);
			MainDispatcher.getInstance().callView("Injury", request);
			break;
			
		case "GETCHOICE":
			
switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "injuryRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "injuryInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "injuryUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "injuryDelete", null);
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
			break;
		}
	}
}
