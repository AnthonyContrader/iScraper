package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.LoginDTO;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.PlayerService;
import it.contrader.service.UserService;

@RestController
@RequestMapping("/player")
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController{
	
	@Autowired
	private PlayerService playerService;



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
