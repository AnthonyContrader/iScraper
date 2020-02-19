package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.PlayerDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.service.PlayerService;
import it.contrader.service.TeamService;

@RestController
@RequestMapping("/team")
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {
	
	
		@Autowired
		private TeamService teamService;



		@Autowired
		public TeamController(TeamService teamService) {
			this.teamService = teamService;
		}
		
		@RequestMapping(value="/getall" , method= RequestMethod.GET)
		public List<TeamDTO> showTeam() {		
			return (List<TeamDTO>) teamService.getAll();
		}

		@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
		public void delete(@RequestParam(value = "id") long id) {
			this.teamService.delete(id);
		}

		@RequestMapping(value = "/update", method = RequestMethod.PUT)
			public void update(@RequestBody TeamDTO teamDTO) {
				teamService.update(teamDTO);
		}
		
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public void insert(@RequestBody TeamDTO teamDTO) {
			teamService.insert(teamDTO);
		}
		@RequestMapping(value="/findTeam" , method= RequestMethod.GET)
		public TeamDTO findTeam(@RequestParam(value="id") int id) {		
			return teamService.read(id);
		}
		@RequestMapping(value="/findTeambyName" , method= RequestMethod.GET)
		public TeamDTO findTeambyName(@RequestParam(value="name") String name) {		
			return teamService.findByName(name);
		}
		
	}