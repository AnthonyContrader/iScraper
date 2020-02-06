package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.InjuryDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
import it.contrader.service.InjuryService;

public class InjuryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	public InjuryServlet() {
		
	}
	
	public void updateList (HttpServletRequest request) {
		Service<InjuryDTO> service = new InjuryService();
		List<InjuryDTO> listDTO = new ArrayList<InjuryDTO>();
		listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Service<InjuryDTO> service = new InjuryService();
		String mode = request.getParameter("mode");
		InjuryDTO dto;
		UserDTO utente = (UserDTO) request.getSession().getAttribute("user");
		int id;
		int severity;
		String description;
		int duration;
		String date;
		int player_id;
		boolean ans;
		
		switch (mode.toUpperCase()) {

		case "INJURYLIST": 
			updateList(request);
			if (utente.getUsertype().toUpperCase().equals("ADMIN")) {
				getServletContext().getRequestDispatcher("/injury/injurymanager.jsp").forward(request, response);
			}
			else if (utente.getUsertype().toUpperCase().equals("USER")) {
				getServletContext().getRequestDispatcher("/injury/readallinjuries.jsp").forward(request, response);
			}
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/injury/readinjuries.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/injury/updateinjuries.jsp").forward(request, response);
			
			break;

		case "INSERT":
			severity = Integer.parseInt(request.getParameter("severity"));
			description = request.getParameter("description");
			duration = Integer.parseInt(request.getParameter("duration"));
			date = request.getParameter("date");
			player_id = Integer.parseInt(request.getParameter("player_id"));
			dto = new InjuryDTO (severity, description, duration, date, player_id);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/injury/injurymanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			severity = Integer.parseInt(request.getParameter("severity"));
			description = request.getParameter("description");
			duration = Integer.parseInt(request.getParameter("duration"));
			date = request.getParameter("date");
			player_id = Integer.parseInt(request.getParameter("player_id"));
			dto = new InjuryDTO (severity, description, duration, date, player_id);
			id = Integer.parseInt(request.getParameter("id"));
			dto = new InjuryDTO (id, severity, description, duration, date, player_id);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/injury/injurymanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/injury/injurymanager.jsp").forward(request, response);
			break;
		}
	}
	

}
