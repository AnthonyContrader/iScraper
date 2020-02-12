package it.contrader.controller;



import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.converter.PlayerConverter;
import it.contrader.converter.TeamConverter;
import it.contrader.dto.PlayerDTO;
import it.contrader.model.Player;
import it.contrader.model.Team;
import it.contrader.service.PlayerService;
import it.contrader.service.TeamService;



@Controller
@RequestMapping("/player")


public class PlayerController {
	
	@Autowired
	private  PlayerService playerService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private TeamConverter teamConverter;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "player/playermanager";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		playerService.delete(id);
		setAll(request);
		return "player/playermanager";
	}

	

	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("team_id") int team_id,@RequestParam("player_name") String player_name, @RequestParam("player_surname") String player_surname, @RequestParam("age") int age, @RequestParam("actual_value") int actual_value, @RequestParam("previous_value") int previous_value, @RequestParam("position") String position, @RequestParam("team") Team team) {

		PlayerDTO dto = new PlayerDTO();
		dto.setId(id);
		dto.setPlayer_name(player_name);
		dto.setPlayer_surname(player_surname);
		dto.setAge(age);
		dto.setActualMarketValue(actual_value);
		dto.setPreviousMarketValue(previous_value);
		dto.setPosition(position);
		Team team1 = teamConverter.toEntity(teamService.read(team_id));
		dto.setTeam(team1);
		dto.setTeam(team);
		setAll(request);
		return "player/playermanager";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("team_id") int team_id,@RequestParam("player_name") String player_name, @RequestParam("player_surname") String player_surname, @RequestParam("age") int age, @RequestParam("actual_value") int actual_value, @RequestParam("previous_value") int previous_value, @RequestParam("position") String position, @RequestParam("team") Team team) {
		PlayerDTO dto = new PlayerDTO();
		dto.setId(id);
		Team team1 = teamConverter.toEntity(teamService.read(team_id));
		dto.setTeam(team1);
		dto.setPlayer_name(player_name);
		dto.setPlayer_surname(player_surname);
		dto.setAge(age);
		dto.setActualMarketValue(actual_value);
		dto.setPreviousMarketValue(previous_value);
		dto.setPosition(position);
		dto.setTeam(team);
		setAll(request);
		return "playermanager";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", playerService.read(id));
		return "readplayer";
	}
	

	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", playerService.getAll());
	}
}
