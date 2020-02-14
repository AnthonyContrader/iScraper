package it.contrader.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.contrader.dto.TeamDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User.Usertype;
import it.contrader.service.TeamService;


@Controller
@RequestMapping("/team")
public class TeamController {
	
		@Autowired
		private TeamService teamService;

		@GetMapping("/getall")
		public String getAll(HttpServletRequest request) {
			
			setAll(request);
		UserDTO userDTO=(UserDTO) request.getSession().getAttribute("user");
		
		if (userDTO.getUsertype().equals(Usertype.ADMIN)){
			return "team/teammanager";
		} else {
			return "team/readallteams";
		}
			
		}
		
		@GetMapping("/delete")
		public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
			teamService.delete(id);
			setAll(request);
			return "team/teammanager";
		}

		@GetMapping("/preupdate")
		public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
			
			request.getSession().setAttribute("dto", teamService.read(id));
			return "team/updateteams";
		}

		
		@PostMapping("/update")
		public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,@RequestParam("market_value") int market_value, @RequestParam("team_index") int team_index) {
			TeamDTO dto = new TeamDTO();
			dto.setId(id);
			dto.setName(name);;
			dto.setMarket_value(market_value);
			dto.setTeam_index(team_index);
			teamService.update(dto);
			
			setAll(request);
			return "team/teammanager";
		}
		
		@PostMapping("/insert")
		public String insert(HttpServletRequest request, @RequestParam("name") String name,@RequestParam("market_value") int market_value, @RequestParam("team_index") int team_index) {
			TeamDTO dto = new TeamDTO();
			
			dto.setName(name);
			dto.setMarket_value(market_value);
			dto.setTeam_index(team_index);
			teamService.insert(dto);
			setAll(request);
			return "team/teammanager";
		}
		
		@GetMapping("/read")
		public String read(HttpServletRequest request, @RequestParam("id") Long id) {
			request.getSession().setAttribute("dto", teamService.read(id));
			return "team/readteams";
		}
		
		@GetMapping("/readbyname")
		public String read(HttpServletRequest request, @RequestParam("name") String name) {
			request.getSession().setAttribute("dto", teamService.findByName(name));
			return "team/readteams";
		}
		

		
		private void setAll(HttpServletRequest request) {
			request.getSession().setAttribute("list", teamService.getAll());
		}
	}
