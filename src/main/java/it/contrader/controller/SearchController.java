package it.contrader.controller;

import java.sql.Date;
import java.util.List;

import it.contrader.dto.SearchDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.SearchService;

public class SearchController implements Controller {
	
	private static String sub_package = "search.";
	
	private SearchService searchService;
	
	public SearchController() {
		this.searchService = new SearchService();
	}
	
	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		long id;
		Date search_date;
		int value, index, user;
		short player;
		
		switch(mode) {
		
		case "READ":
			id = Long.parseLong(request.get("search_id").toString());
			SearchDTO searchDTO = searchService.read(id);
			request.put("search", searchDTO);
			MainDispatcher.getInstance().callView(sub_package + "SearchRead", request);
			break;
		
		case "INSERT":
			search_date = (Date) request.get("search_date");
			value = Integer.parseInt(request.get("player_value").toString());
			index = Integer.parseInt(request.get("player_index").toString());
			user = Integer.parseInt(request.get("user_id").toString());
			player = Short.parseShort(request.get("player_id").toString());
			SearchDTO searchInsert = new SearchDTO(search_date, value, index, user, player);
			searchService.insert(searchInsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SearchInsert", request);
			break;
			
		case "DELETE":
			id = Long.parseLong(request.get("search_id").toString());
			searchService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SearchDelete", request);
			break;
		
		case "UPDATE":
			id = Long.parseLong(request.get("search_id").toString());
			search_date = (Date) request.get("search_date");
			value = Integer.parseInt(request.get("player_value").toString());
			index = Integer.parseInt(request.get("player_index").toString());
			user = Integer.parseInt(request.get("user_id").toString());
			player = Short.parseShort(request.get("player_id").toString());
			SearchDTO searchUpdate = new SearchDTO(id, search_date, value, index, user, player);
			searchService.update(searchUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SearchUpdate", request);
			break;
			
		case "SEARCHLIST":
			List<SearchDTO> searchesDTO = searchService.getAll();
			request.put("searches", searchesDTO);
			MainDispatcher.getInstance().callView("Search", request);
			break;
			
		case "GETCHOICE":
			
			switch(choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "SearchRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "SearchInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "SearchUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "SearchDelete", null);
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
