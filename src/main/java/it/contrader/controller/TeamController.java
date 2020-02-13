package it.contrader.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.TeamDTO;
import it.contrader.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamController {

	 @Autowired 
	 private TeamService teamService;
	 
	 @GetMapping("/getall")
	 private String getall(HttpServletRequest request) {
		 setAll(request);
		 return "teams";
	 }
	 
	 private void setAll(HttpServletRequest request) {
		 request.getSession().setAttribute("list", teamService.getAll());
	 }
	 
	 @PostMapping("/insert")
	 private String insert(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("marketValue") int marketValue, @RequestParam("teamIndex") int teamIndex) {
		 TeamDTO teamDTO = new TeamDTO();
		 teamDTO.setName(name);
		 teamDTO.setMarketValue(marketValue);
		 teamDTO.setTeamIndex(teamIndex);
		 teamService.insert(teamDTO);
		 setAll(request);
		 return ("teams");
	 }
}
