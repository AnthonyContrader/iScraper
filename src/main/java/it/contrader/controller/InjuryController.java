package it.contrader.controller;

import it.contrader.dto.InjuryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.InjuryService;

import java.sql.Date;
import java.util.List;

public class InjuryController implements Controller {

	private static String sub_package = "injury.";
	private InjuryService injuryService;
	
	public InjuryController() {
		this.injuryService=new InjuryService();
	}
	
	private int id;
	private int severity;
	private String description;
	private int duration;
	private Date date;
	private int player_id;
	
	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		switch(mode) {
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			severity = Integer.parseInt(request.get("severity").toString());
			InjuryDTO injuryDTO = injuryService.read(id);
			request.put("injury", injuryDTO);
			MainDispatcher.getInstance().callView(sub_package+"InjuryRead", request);
			break;
		
		case "INSERT":
			id = Integer.parseInt(request.get("id").toString());
			severity = Integer.parseInt(request.get("severity").toString());
			description = request.get("description").toString();
			duration = Integer.parseInt(request.get("duration").toString());
			date = Date.valueOf((request.get("date").toString()));
			player_id = Integer.parseInt(request.get("player_id").toString());
			
			InjuryDTO injuryToInsert = new InjuryDTO(id,severity,description,duration,date,player_id);
			injuryService.insert(injuryToInsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "InjuryInsert", request);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());;
			injuryService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "InjuryDelete", request);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			severity = Integer.parseInt(request.get("severity").toString());
			description = request.get("description").toString();
			duration = Integer.parseInt(request.get("duration").toString());
			date = Date.valueOf((request.get("date").toString()));
			player_id = Integer.parseInt(request.get("player_id").toString());
			
			InjuryDTO injuryToUpdate = new InjuryDTO(id,severity,description,duration,date,player_id);
			injuryService.update(injuryToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "InjuryUpdate", request);
			break;
			
		case "INJURYLIST":
			List<InjuryDTO> dto = injuryService.getAll();
			request.put("Injuries", dto);
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
