package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import it.contrader.dto.StatsboxDTO;
import it.contrader.dto.TeamDTO;
//import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
//import it.contrader.service.StatsboxService;
import it.contrader.service.TeamService;
import it.contrader.utils.InputValidation;

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
		//UserDTO utente = (UserDTO) request.getSession().getAttribute("user");
		/*-- Non sono riuscito a farlo funzionare senza usare una try catch,
		 * se riuscite a scoprire come verificare che si può richiamare
		 * l'attributo utente senza crashare se il valore è null fatemelo sapere
		 * Simone
		 */
		String utente = new String("");
		try {
			utente = new String(request.getSession().getAttribute("utente").toString().toUpperCase());
		} catch (NullPointerException e) {
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		TeamDTO dto;
		int id;
		String name = new String("");
		int market_value = 0;
		int index = 0;
		boolean ans;
		boolean datiErrati = false;
		String errore = new String("");
		if (request.getAttribute("messaggio") != null) {
			request.removeAttribute("messaggio");
		}
		
		switch (mode.toUpperCase()) {

		case "TEAMLIST":
			updateList(request);
			//if (utente.getUsertype().toUpperCase().equals("ADMIN")) {
			if (utente.equals("ADMIN")) {
				getServletContext().getRequestDispatcher("/teams/teammanager.jsp").forward(request, response);
			}
			//else if (utente.getUsertype().toUpperCase().equals("USER")) {
			else if (utente.equals("USER")) {
				getServletContext().getRequestDispatcher("/teams/readallteams.jsp").forward(request, response);
			} else
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/teams/readteams.jsp").forward(request, response);
			}			
			else getServletContext().getRequestDispatcher("/teams/updateteams.jsp").forward(request, response);			
			break;

		case "INSERT":
			try {
				name = request.getParameter("name").trim();
				if ("".equals(name)) {
					datiErrati = true;
					errore = errore + "Campo nome vuoto <br>";
				}
				if ("ok".equals(InputValidation.intValidation(request.getParameter("market_value").trim()))) {
					market_value = Integer.parseInt(request.getParameter("market_value"));	
				} else {
					datiErrati = true;
					errore = errore + "Valore nel campo valore di mercato non valido <br>";
				}
				if ("ok".equals(InputValidation.intValidation(request.getParameter("index").trim()))) {
					index = Integer.parseInt(request.getParameter("index"));
				} else {
					datiErrati = true;
					errore = errore + "Valore nel campo indice non valido <br>";
				}
				if (datiErrati) {
					updateList(request);
					request.setAttribute("messaggio", errore);
					getServletContext().getRequestDispatcher("/teams/teammanager.jsp").forward(request, response);
				} else {
					dto = new TeamDTO (name, market_value, index);
					ans = service.insert(dto);
					request.setAttribute("ans", ans);
					updateList(request);
					getServletContext().getRequestDispatcher("/teams/teammanager.jsp").forward(request, response);
				}
			} catch (NullPointerException e) {
				updateList(request);
				getServletContext().getRequestDispatcher("/teams/teammanager.jsp");
			}
			break;
			
		case "UPDATE":
			if (request.getAttribute("messaggio_update") != null) {
				request.removeAttribute("messaggio_update");
			}
			try {
				name = request.getParameter("name").trim();
				if ("".equals(name)) {
					datiErrati = true;
					errore = errore + "Campo nome vuoto <br>";
				}
				if ("ok".equals(InputValidation.intValidation(request.getParameter("market_value").trim()))) {
					market_value = Integer.parseInt(request.getParameter("market_value"));	
				} else {
					datiErrati = true;
					errore = errore + "Valore nel campo valore di mercato non valido <br>";
				}
				if ("ok".equals(InputValidation.intValidation(request.getParameter("index").trim()))) {
					index = Integer.parseInt(request.getParameter("index"));
				} else {
					datiErrati = true;
					errore = errore + "Valore nel campo indice non valido <br>";
				}
				if (datiErrati) {
					id = Integer.parseInt(request.getParameter("id"));
					updateList(request);
					request.setAttribute("messaggio_update", errore);
					getServletContext().getRequestDispatcher("/TeamServlet?mode=read&update=true&id="+id).forward(request, response);
				} else {
					id = Integer.parseInt(request.getParameter("id"));
					dto = new TeamDTO (id, name, market_value, index);
					ans = service.update(dto);
					updateList(request);
					getServletContext().getRequestDispatcher("/teams/teammanager.jsp").forward(request, response);
				}
			} catch (NullPointerException e) {
				try {
					id = Integer.parseInt(request.getParameter("id"));
					updateList(request);
					getServletContext().getRequestDispatcher("/TeamServlet?mode=read&update=true&id="+id).forward(request, response);	
				} catch (NullPointerException er) {
					getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				}
			}
			break;

		case "DELETE":
			try {
				id = Integer.parseInt(request.getParameter("id"));
				ans = service.delete(id);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/teams/teammanager.jsp").forward(request, response);
			} catch (NullPointerException e) {
				updateList(request);
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			break;
		}
	}
}