package it.contrader.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import it.contrader.dto.PlayerDTO;

import it.contrader.dto.UserDTO;

import it.contrader.service.PlayerService;

import it.contrader.service.Service;

public class PlayerUserServlet extends HttpServlet {
	boolean t=false;
	public void updateList(HttpServletRequest request) {
		Service<PlayerDTO> service = new PlayerService();
		List<PlayerDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String dd=request.getRemoteUser();
		 request.setAttribute("tip", dd);
		

		
		Service<PlayerDTO> service = new PlayerService();
		String mode = request.getParameter("mode");
		PlayerDTO dto;
		int id=0;
		boolean ans;
		
		
		 String player_name = null; 
		 String player_surname = null;
		 int age = 0; 
		 int actualMarketValue = 0;
		 int previousMarketValue = 0;
		 String position = null;
		 String team = null;
		
		switch (mode.toUpperCase()) {
		
		
		case "UPDATEID" :
			PlayerDTO newDto= new PlayerDTO(); 
			dto = service.read(newDto.getId());
			System.out.println(dto);
			request.setAttribute("dto", dto);
			
		case "PLAYERLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/player/playerusermanager.jsp").forward(request, response);
			break;
			
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/player/readplayeruser.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/player/updateplayer.jsp").forward(request, response);
			
			break;
			
			
	
		
		

		
		
		}
	}
}	