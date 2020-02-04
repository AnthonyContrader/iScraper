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

public class PlayerServlet extends HttpServlet {
	
	public void updateList(HttpServletRequest request) {
		Service<PlayerDTO> service = new PlayerService();
		List<PlayerDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<PlayerDTO> service = new PlayerService();
		String mode = request.getParameter("mode");
		PlayerDTO dto;
		int id;
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
			getServletContext().getRequestDispatcher("/player/playermanager.jsp").forward(request, response);
			break;
			
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/player/readplayer.jsp").forward(request, response);
//			if (request.getParameter("update") == null) {
//				getServletContext().getRequestDispatcher("/player/readplayer.jsp").forward(request, response);
//			} else {
//				getServletContext().getRequestDispatcher("/player/updateplayer.jsp").forward(request, response);
			
			
			break;
		
		case "INSERT":
			
			try {
				player_name = request.getParameter("player_name");
			} catch (Exception e) {}
			try {
				player_surname = request.getParameter("player_surname");
			} catch (Exception e) {}
			try {
				age = Integer.parseInt(request.getParameter("age"));
			} catch (Exception e) {}
			
			try {
				actualMarketValue = Integer.parseInt(request.getParameter("actual_value"));
			} catch (Exception e) {}
			try {
				previousMarketValue = Integer.parseInt(request.getParameter("previous_value"));
			} catch (Exception e) {}
			
			try {
				position = request.getParameter("position"); 
			} catch (Exception e) {}
			try {
				team = request.getParameter("team");
			} catch (Exception e) {}
			
			
			
			dto = new PlayerDTO(player_name,player_surname,age,actualMarketValue,previousMarketValue,position,team);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/player/playermanager.jsp").forward(request, response);
		break;
		
		case "UPDATE":
			try {
				player_name = request.getParameter("player_name");
			} catch (Exception e) {}
			try {
				player_surname = request.getParameter("player_surname");
			} catch (Exception e) {}
			try {
				age = Integer.parseInt(request.getParameter("age"));
			} catch (Exception e) {}
			
			try {
				actualMarketValue = Integer.parseInt(request.getParameter("actual_value"));
			} catch (Exception e) {}
			try {
				previousMarketValue = Integer.parseInt(request.getParameter("previous_value"));
			} catch (Exception e) {}
			
			try {
				position = request.getParameter("position");
			} catch (Exception e) {}
			try {
				team = request.getParameter("team");
			} catch (Exception e) {}
			
			id = Integer.parseInt(request.getParameter("id"));
			dto = new PlayerDTO(id,player_name,player_surname,age,actualMarketValue,previousMarketValue,position,team);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/player/playermanager.jsp").forward(request, response);
		break;
		
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/player/playermanager.jsp").forward(request, response);
		}
	}
}	