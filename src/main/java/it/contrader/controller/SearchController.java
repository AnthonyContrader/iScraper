package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.SearchDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import it.contrader.model.Player;
import it.contrader.service.SearchService;

@Controller

@RequestMapping("/search")
public class SearchController {

	@Autowired
	private SearchService service;
	
	@GetMapping("/getall")
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
	}
}