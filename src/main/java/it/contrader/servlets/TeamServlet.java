package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.StatsboxDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.service.Service;
import it.contrader.service.StatsboxService;
import it.contrader.service.TeamService;

public class TeamServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public TeamServlet() {
		
	}
	
	public void updateList (HttpServletRequest request) {
		Service<TeamDTO> service = new TeamService();
		List<TeamDTO> listDTO = new ArrayList<TeamDTO>();
		listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Service<TeamDTO> service = new TeamService();
		String mode = request.getParameter("mode");
		TeamDTO dto;
		int id;
		String name;
		int market_value;
		int index;
		boolean ans;
		
		switch (mode.toUpperCase()) {

		case "TEAMLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/teams/teammanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/teams/readteams.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/teams/teammanager.jsp").forward(request, response);
			
			break;

		case "INSERT":
			name = request.getParameter("name");
			
			market_value = Integer.parseInt(request.getParameter("market_value"));
			index = Integer.parseInt(request.getParameter("index"));
			dto = new TeamDTO (name, market_value, index);
			ans = service.insert(dto);
			System.out.println("\n\n\n"+ans+"\n\n\n");
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/teams/teammanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name = request.getAttribute("name").toString();
			market_value = Integer.parseInt(request.getAttribute("market_value").toString());
			index = Integer.parseInt(request.getAttribute("index").toString());
			id = Integer.parseInt(request.getParameter("id"));
			dto = new TeamDTO (name, market_value, index);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/teams/teammanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/teams/teammanager.jsp").forward(request, response);
			break;
		}
	}
	

}
