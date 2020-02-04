package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import it.contrader.dto.PlayerDTO;
import it.contrader.dto.UserDTO;

import it.contrader.service.PlayerService;

public class PlayerServlet extends HttpServlet {
//	private int player_id;
//	private String player_name;
//	private String player_surname;
//	private int age;
//	 int actualMarketValue;
//	 int previousMarketValue;
//	 private String position;
	 
	private PlayerService playerService = new PlayerService();
	private List<PlayerDTO> allPlayers = new ArrayList<PlayerDTO>();
	private List<PlayerDTO> filteredPlayers = new ArrayList<PlayerDTO>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		final UserDTO userLogged = (UserDTO) session.getAttribute("usertype");


		switch (scelta) {

//		case "ClientManager":
//			showAllClient(request, response);
//			break;
//
//		case "insertRedirect":
//			response.sendRedirect("client/insertClient.jsp");
//			break;

		case "insert":
			// final int userId = Integer.parseInt(request.getParameter("user_id"));
			final String playerName = request.getParameter("player_name");
			// UserDTO userInsert = new UserDTO("","","");

			// userInsert.setId(userId);
			final PlayerDTO playerInsert = new PlayerDTO();
			playerService.insert(playerInsert);
			showAllPlayers(request, response);
			break;

//		case "updateRedirect":
//			int id = Integer.parseInt(request.getParameter("id"));
//			ClientDTO clientUpdate = new ClientDTO(new UserDTO("", "", ""), "");
//			clientUpdate.setId(id);
//
//			clientUpdate = this.clientServiceDTO.readClient(clientUpdate);
//			request.setAttribute("clientUpdate", clientUpdate);
//			getServletContext().getRequestDispatcher("/client/updateClient.jsp").forward(request, response);
//
//			break;

		case "update":
			final Integer playerIdUpdate = Integer.parseInt(request.getParameter("player_id"));
			
			// final Integer userIdUpdate =
			// Integer.parseInt(request.getParameter("user_id"));
			final String playerNameUpdate = request.getParameter("player_name");
			final String playerSurnameUpdate=request.getParameter("player_surname");
			final Integer playerAgeUpdate=Integer.parseInt(request.getParameter("age"));
			final int actualValueUpdate=Integer.parseInt(request.getParameter("actual_value"));
			final int previousValueUpdate=Integer.parseInt(request.getParameter("previous_value"));
			final String playerPositionUpdate= request.getParameter("position");
			final String playerTeamUpdate= request.getParameter("team");
			
			
			
			
			
			final PlayerDTO playerDTO = new PlayerDTO();
			playerDTO.setId(playerIdUpdate);
			playerDTO.setName(playerNameUpdate);
			playerDTO.setSurname(playerSurnameUpdate);
			playerDTO.setAge(playerAgeUpdate);
			playerDTO.setActualMarketValue(actualValueUpdate);
			playerDTO.setPreviousMarketValue(previousValueUpdate);
			playerDTO.setPosition(playerPositionUpdate);
			playerDTO.setTeam(playerTeamUpdate);
			
			
			playerService.update(playerDTO);
			showAllPlayers(request, response);
			break;

		case "delete":
			final Integer playerIdDelete = Integer.parseInt(request.getParameter("id"));

			final PlayerDTO playerdelete = new PlayerDTO();
			playerdelete.setId(playerIdDelete);
			playerService.deletePlayer(playerIdDelete);
			showAllPlayers(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeAdmin.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}
	
	// Show all client for user logged
	private void showAllPlayers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allPlayers.clear();
		filteredPlayers.clear();
		allPlayers = this.playerService.getAll();
		HttpSession session = request.getSession(true);
	//	UserDTO userLogged=(UserDTO) session.getAttribute("utente");
		
		for (PlayerDTO playerDTO:allPlayers) {
//			if (clientDTO.getUserDTO().getId()==userLogged.getId())
				filteredPlayers.add(playerDTO);
		}
			
		request.setAttribute("allClient", filteredPlayers);
		getServletContext().getRequestDispatcher("/client/managePlayer.jsp").forward(request, response);
	}
}