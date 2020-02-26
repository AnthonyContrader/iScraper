package it.contrader.controller;

//import java.sql.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.UserDTO;
import it.contrader.dto.SearchDTO;
import it.contrader.service.SearchService;
import it.contrader.service.UserService;

@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "http://localhost:4200")

public class SearchController extends AbstractController<SearchDTO>{

	@Autowired
	private SearchService service;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/getall", method= RequestMethod.GET)
	public List<SearchDTO> getAll() {
		return (List<SearchDTO>) service.getAll();
	}
	
	@RequestMapping(value = "/postall", method= RequestMethod.POST)
	public List<SearchDTO> postAll(@RequestBody UserDTO dto) {
		UserDTO userChecking = userService.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
		List<SearchDTO> searchList = (List<SearchDTO>) service.getAll();
		if (userChecking!=null && userChecking.equals(dto)) {
			switch (dto.getUsertype().toString().toUpperCase()) {
			
			case "ADMIN":
				return searchList;
			
			case "USER":
				List<SearchDTO> sendingList = new ArrayList<SearchDTO>();
				for(SearchDTO s : searchList) {
					if (s.getUser().getId()==dto.getId()) {
						sendingList.add(s);
					}
				}
				return sendingList;
			
			default:
				return null;
			}
		} else return null;
		
	}
	
	/*@RequestMapping(value = "/insert", method= RequestMethod.POST)
	public SearchDTO insert(@RequestBody SearchDTO dto) {/*
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dto.setSearch_date(new Date(format.parse(dto.getSearch_date().toString()).getTime()));
		} catch (ParseException e) {
			return null;
		}
		service.insert(dto);
		return dto;
	}*/
	
	/*@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "search/searches";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") long id) {
		service.delete(id);
		setAll(request);
		return "search/searches";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "search/updatesearch";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") long id, @RequestParam("search_date") Date search_date,
			@RequestParam("value") int value, @RequestParam("index") int player_index, @RequestParam("user") User user,
			@RequestParam("player") Player player) {
		
		SearchDTO dto = new SearchDTO();
		dto.setId(id);
		dto.setSearch_date(search_date);
		dto.setValue(value);
		dto.setPlayer_index(player_index);
		dto.setUser(user);
		dto.setPlayer(player);
		service.update(dto);
		setAll(request);
		return "search/searches";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("search_date") Date search_date, @RequestParam("index") int index,
			@RequestParam("value") int value, @RequestParam("user") User user, @RequestParam("player") Player player) {
		SearchDTO dto = new SearchDTO();
		dto.setSearch_date(search_date);
		dto.setPlayer_index(index);
		dto.setValue(value);
		dto.setUser(user);
		dto.setPlayer(player);
		service.insert(dto);
		setAll(request);
		return "search/searches";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "search/readsearch";
	}
	
	private void setAll(HttpServletRequest request) {
		List<SearchDTO> searchesList = new ArrayList<SearchDTO>((List<SearchDTO>)service.getAll());
		UserDTO user = new UserDTO();
		user = (UserDTO) request.getSession().getAttribute("user");
		switch (user.getUsertype()) {
		
		case ADMIN:
			request.getSession().setAttribute("list", searchesList);
			break;
		
		case USER:
			List<SearchDTO> userSearchesList = new ArrayList<SearchDTO>();
			for(SearchDTO s : searchesList){
				if (s.getUser().getId()==user.getId()) {
					userSearchesList.add(s);
				}
			}
			request.getSession().setAttribute("list", userSearchesList);
			break;
		}
	}*/
}