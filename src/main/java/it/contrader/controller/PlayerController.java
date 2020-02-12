package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.PlayerDTO;

import it.contrader.model.Team;
import it.contrader.service.PlayerService;



@Controller
@RequestMapping("/player")

public class PlayerController {

	private final PlayerService playerService;
	
	
	
	
	@Autowired
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		playerService.delete(id);
		setAll(request);
		return "player/playermanager";
	}


	
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "player/playermanager";
	}
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("player_name") String player_name, @RequestParam("player_surname") String player_surname, @RequestParam("age") int age, @RequestParam("actual_value") int actual_value, @RequestParam("previous_value") int previous_value, @RequestParam("position") String position, @RequestParam("team") Team team) {
		PlayerDTO dto = new PlayerDTO();
		dto.setId(id);
		dto.setPlayer_name(player_name);
		dto.setPlayer_surname(player_surname);
		dto.setAge(age);
		dto.setActualMarketValue(actual_value);
		dto.setPreviousMarketValue(previous_value);
		dto.setPosition(position);
		dto.setTeam(team);
		setAll(request);
		return "player/playermanager";
	}
	
	

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", playerService.read(id));
		return "updateplayer";
	}

	
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("player_name") String player_name, @RequestParam("player_surname") String player_surname, @RequestParam("age") int age, @RequestParam("actual_value") int actual_value, @RequestParam("previous_value") int previous_value, @RequestParam("position") String position, @RequestParam("team") Team team) {

		PlayerDTO dto = new PlayerDTO();
		dto.setId(id);
		dto.setPlayer_name(player_name);
		dto.setPlayer_surname(player_surname);
		dto.setAge(age);
		dto.setActualMarketValue(actual_value);
		dto.setPreviousMarketValue(previous_value);
		dto.setPosition(position);
		dto.setTeam(team);
		setAll(request);
		return "player/playermanager";
	}
	
	
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", playerService.getAll());
	}
}
