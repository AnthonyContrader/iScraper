package it.contrader.controller;

import static org.mockito.Matchers.longThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.converter.TeamConverter;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.PlayerService;
import it.contrader.service.TeamService;
import it.contrader.service.UserService;

@RestController
@RequestMapping("/player")
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController{
	private TeamService teamService;
	@Autowired
	private PlayerService playerService;

private TeamConverter teamConverter;

	@Autowired
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	@RequestMapping(value="/getall" , method= RequestMethod.GET)
	public List<PlayerDTO> showPlayer() {		
		return (List<PlayerDTO>) playerService.getAll();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "id") long id) {
		this.playerService.delete(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public void update(@RequestBody PlayerDTO playerDTO) {
		System.out.println(playerDTO.getTeam().getName());
		TeamDTO teamDTO2=teamService.findByName(playerDTO.getTeam().getName());
		Long id2=playerDTO.getTeam().getId();
	teamDTO2.setId(id2);
		playerDTO.setTeam(teamConverter.toEntity(teamDTO2));
		
		System.out.println(playerDTO.getTeam().toString());
			playerService.update(playerDTO);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody PlayerDTO playerDTO) {
		playerService.insert(playerDTO);
	}
	@RequestMapping(value="/findPlayer" , method= RequestMethod.GET)
	public PlayerDTO findPlayer(@RequestParam(value="id") int id) {		
		return playerService.read(id);

	}
}
