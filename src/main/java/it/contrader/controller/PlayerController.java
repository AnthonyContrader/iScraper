package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.converter.UserConverter;

import it.contrader.dto.PlayerDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.PlayerService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Controller
@RequestMapping("/player")

public class PlayerController {

	private final PlayerService playerService;
	
	private HttpSession session;
	private int id;
	
	
	@Autowired
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	private void visualPlayer(HttpServletRequest request) {
		UserDTO userDTO = (UserDTO) this.session.getAttribute("utente");
		List<PlayerDTO> allPlayers = this.playerService.getAll();
		request.setAttribute("allClientDTO", allPlayers);
	}

//	@RequestMapping(value = "/playerManagement", method = RequestMethod.GET)
//	public String clientManagement(HttpServletRequest request) {
//		visualPlayer(request);
//		return "client/manageClient";
//	}
//
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.playerService.deletePlayerById(id);
		visualPlayer(request);
		return "player/playermanager";

	}
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "player/playermanager";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		
		String playerName = request.getParameter("player_name").toString();
		String playerSurname = request.getParameter("player_surname").toString();
		int age= Integer.parseInt(request.getParameter("age"));
		int actual_value=Integer.parseInt(request.getParameter("actual_value"));
		int previous_value=Integer.parseInt(request.getParameter("previous_value"));
		String position = request.getParameter("position").toString();
		String team = request.getParameter("team").toString();
		
		PlayerDTO playerDTO = new PlayerDTO();
		playerDTO.setPlayer_name(playerName);
		playerDTO.setPlayer_surname(playerSurname);
		playerDTO.setAge(age);
		playerDTO.setActualMarketValue(actual_value);
		playerDTO.setPreviousMarketValue(previous_value);
		playerDTO.setPosition(position);
		playerDTO.setTeam(team);
		
		
		
		
		
		playerService.insertPlayer(playerDTO);
		visualPlayer(request);
		 

		return "player/playermanager";
	}


	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		PlayerDTO playerUpdate = new PlayerDTO();

		playerUpdate = this.playerService.getPlayerDTObyId(id);
		request.setAttribute("playerUpdate", playerUpdate);
		return "player/updateplayer";
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		
		Integer idUpdate = Integer.parseInt(request.getParameter("id"));
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		
		String playerName = request.getParameter("player_name").toString();
		String playerSurname = request.getParameter("player_surname").toString();
		int age= Integer.parseInt(request.getParameter("age"));
		int actual_value=Integer.parseInt(request.getParameter("actual_value"));
		int previous_value=Integer.parseInt(request.getParameter("previous_value"));
		String position = request.getParameter("position").toString();
		String team = request.getParameter("team").toString();
		
		PlayerDTO playerDTO = new PlayerDTO();
		playerDTO.setPlayer_name(playerName);
		playerDTO.setPlayer_surname(playerSurname);
		playerDTO.setAge(age);
		playerDTO.setActualMarketValue(actual_value);
		playerDTO.setPreviousMarketValue(previous_value);
		playerDTO.setPosition(position);
		playerDTO.setTeam(team);
		playerDTO.setId(idUpdate);
		
		
		
		
		
		
		
		playerService.updatePlayer(playerDTO);
		visualPlayer(request);
		
		return "client/manageClient";
	}
	
}
