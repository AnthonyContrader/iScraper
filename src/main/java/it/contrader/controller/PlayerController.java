package it.contrader.controller;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.Matchers.longThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.converter.SearchConverter;
import it.contrader.converter.TeamConverter;
import it.contrader.dao.PlayerRepository;
import it.contrader.dao.SearchRepository;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.StatsboxDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.PlayerService;
import it.contrader.service.TeamService;
import it.contrader.service.UserService;

@RestController
@RequestMapping("/player")
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController extends AbstractController<PlayerDTO>{
	
	//private TeamService teamService;
	@Autowired
	private PlayerService playerService;
	@Autowired
	private PlayerController converter;
	@Autowired
	private PlayerRepository repository;


	@Autowired
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}
	
//	@RequestMapping(value="/getall" , method= RequestMethod.GET)
//	public List<PlayerDTO> showPlayer() {		
//		return (List<PlayerDTO>) playerService.getAll();
//	}
//
//	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
//	public void delete(@RequestParam(value = "id") long id) {
//		this.playerService.delete(id);
//	}
//
//	@RequestMapping(value = "/update", method = RequestMethod.PUT)
//		public void update(@RequestBody PlayerDTO playerDTO) {
//
//			playerService.update(playerDTO);
//	}
//	
//	@RequestMapping(value = "/insert", method = RequestMethod.POST)
//	public void insert(@RequestBody PlayerDTO playerDTO) {
//		playerService.insert(playerDTO);
//	}
	@RequestMapping(value="/findPlayer" , method= RequestMethod.GET)
	public PlayerDTO findPlayer(@RequestParam(value="id") int id) {		
		return playerService.read(id);

	}
//	public List<PlayerDTO> findByName(String name){
//		
//		
//		List<PlayerDTO>listaDtos=(List<PlayerDTO>) service.getAll();
//	List<PlayerDTO> newList=new ArrayList<PlayerDTO>();
//	for(PlayerDTO playerDTO:listaDtos) {
//		if(playerDTO.getPlayer_name().equals(name)) {
//			newList.add(playerDTO);
//		}
//		
//	}
//		
//	return newList;
//	
//}

	@RequestMapping(value="/findByName" , method= RequestMethod.GET)
	public List<PlayerDTO> findByName(@RequestParam(value="name") String name) {	
		List<PlayerDTO>listaDtos=(List<PlayerDTO>) playerService.getAll();
		List<PlayerDTO> newList=new ArrayList<PlayerDTO>();
		if(name.equals("")|| name.equals(null)){
			return listaDtos;
		}
		for(PlayerDTO playerDTO:listaDtos) {
			if(playerDTO.getPlayer_name().equals(name)) {
				newList.add(playerDTO);
			}
			
		}
		if(newList.size()==0) {
			return listaDtos;
		}
		
		return newList;

	}

	@RequestMapping(value="/orderByValue" , method= RequestMethod.GET)
	public List<PlayerDTO> orderByValue() {	
		List<PlayerDTO>listaDtos=(List<PlayerDTO>) playerService.getAll();
		List<PlayerDTO> newList=new ArrayList<PlayerDTO>();
		for(PlayerDTO playerDTO:listaDtos) {
			
				newList.add(playerDTO);
			}
		 Collections.sort(newList, new Comparator<PlayerDTO>() {
		        @Override public int compare(PlayerDTO p1, PlayerDTO p2) {
		            return p1.getActualMarketValue() - p2.getActualMarketValue(); // Ascending
		        }

		    });
		
		return newList;

	}
	
	@RequestMapping(value="/order",  method= RequestMethod.GET)
	public List<PlayerDTO> order(@RequestParam("nome") String nome) {
		
		List<PlayerDTO>listaDtos=(List<PlayerDTO>) playerService.getAll();
		List<PlayerDTO> newList=new ArrayList<PlayerDTO>();
		switch (nome.toUpperCase()) {
		case "VALORE ATTUALE":
			
			for(PlayerDTO playerDTO:listaDtos) {
				
					newList.add(playerDTO);
				}
			 Collections.sort(newList, new Comparator<PlayerDTO>() {
			        @Override public int compare(PlayerDTO p1, PlayerDTO p2) {
			            return p1.getActualMarketValue() - p2.getActualMarketValue(); // Ascending
			        }

			    });
			
			
			break;
			
		case "VALORE PRECEDENTE":
			
			for(PlayerDTO playerDTO:listaDtos) {
				
					newList.add(playerDTO);
				}
			 Collections.sort(newList, new Comparator<PlayerDTO>() {
			        @Override public int compare(PlayerDTO p1, PlayerDTO p2) {
			            return p1.getPreviousMarketValue() - p2.getPreviousMarketValue(); // Ascending
			        }

			    });
			 
				break;
				
				
			case "ETA":
			
			for(PlayerDTO playerDTO:listaDtos) {
				
					newList.add(playerDTO);
				}
			 Collections.sort(newList, new Comparator<PlayerDTO>() {
			        @Override public int compare(PlayerDTO p1, PlayerDTO p2) {
			            return p1.getAge() - p2.getAge(); // Ascending
			        }

			    });
			 
				break;
			case "SQUADRA":
				
				for(PlayerDTO playerDTO:listaDtos) {
					
						newList.add(playerDTO);
					}
				 Collections.sort(newList, new Comparator<PlayerDTO>() {
				        @Override public int compare(PlayerDTO p1, PlayerDTO p2) {
				            return p1.getTeam().getName().compareTo(p2.getTeam().getName()); // Ascending
				        }

				    });
				 
					break;
			case "ID":
				
				for(PlayerDTO playerDTO:listaDtos) {
					
						newList.add(playerDTO);
					}
				 Collections.sort(newList, new Comparator<PlayerDTO>() {
				        @Override public int compare(PlayerDTO p1, PlayerDTO p2) {
				            return (int) (p1.getId() - p2.getId()); // Ascending
				        }

				    });
				 
					break;
					
		
		}return newList;
	}
	
}
