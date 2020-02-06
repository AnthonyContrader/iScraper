package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import it.contrader.dto.StatsboxDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
import it.contrader.service.StatsboxService;

public class StatsboxServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	public StatsboxServlet() {
		
	}
	
	public void updateList (HttpServletRequest request) {
		Service<StatsboxDTO> service = new StatsboxService();
		List<StatsboxDTO> listDTO = new ArrayList<StatsboxDTO>();
		listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Service<StatsboxDTO> service = new StatsboxService();
		String mode = request.getParameter("mode");
		StatsboxDTO dto;
		UserDTO utente = (UserDTO) request.getSession().getAttribute("user");
		int id;
		int player_id;
		int season;
		int caps;
		float contributions;
		float shotsper;
		float keypass;
		float passprec;
		float dribbling;
		float foulssub;
		float foulscomm;
		float tackles;
		float tacklesper;
		float breaks;
		boolean ans;
		
		switch (mode.toUpperCase()) {

		case "STATSBOXLIST": 
			updateList(request);
			if (utente.getUsertype().toUpperCase().equals("ADMIN")) {
				getServletContext().getRequestDispatcher("/statsbox/statsmanager.jsp").forward(request, response);
			}
			else if (utente.getUsertype().toUpperCase().equals("USER")) {
				getServletContext().getRequestDispatcher("/statsbox/readallstats.jsp").forward(request, response);
			}
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/statsbox/readstats.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/statsbox/updatestats.jsp").forward(request, response);
			
			break;

		case "INSERT":
			player_id = Integer.parseInt(request.getParameter("player_id"));
			season = Integer.parseInt(request.getParameter("season"));
			caps = Integer.parseInt(request.getParameter("caps"));;
			contributions = Float.parseFloat(request.getParameter("contributions"));
			shotsper = Float.parseFloat(request.getParameter("shotsper"));
			keypass = Float.parseFloat(request.getParameter("keypass"));
			passprec = Float.parseFloat(request.getParameter("passprec"));
			dribbling = Float.parseFloat(request.getParameter("dribbling"));;
			foulssub = Float.parseFloat(request.getParameter("foulssub"));
			foulscomm = Float.parseFloat(request.getParameter("foulscomm"));
			tackles = Float.parseFloat(request.getParameter("tackles"));
			tacklesper = Float.parseFloat(request.getParameter("tacklesper"));
			breaks = Float.parseFloat(request.getParameter("breaks"));
			dto = new StatsboxDTO (player_id, season, caps, contributions, shotsper, keypass, passprec, dribbling, foulssub, foulscomm, tackles, tacklesper, breaks);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/statsbox/statsmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			player_id = Integer.parseInt(request.getParameter("player_id"));
			season = Integer.parseInt(request.getParameter("season"));
			caps = Integer.parseInt(request.getParameter("caps"));;
			contributions = Float.parseFloat(request.getParameter("contributions"));
			shotsper = Float.parseFloat(request.getParameter("shotsper"));
			keypass = Float.parseFloat(request.getParameter("keypass"));
			passprec = Float.parseFloat(request.getParameter("passprec"));
			dribbling = Float.parseFloat(request.getParameter("dribbling"));;
			foulssub = Float.parseFloat(request.getParameter("foulssub"));
			foulscomm = Float.parseFloat(request.getParameter("foulscomm"));
			tackles = Float.parseFloat(request.getParameter("tackles"));
			tacklesper = Float.parseFloat(request.getParameter("tacklesper"));
			breaks = Float.parseFloat(request.getParameter("breaks"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new StatsboxDTO (id, player_id, season, caps, contributions, shotsper, keypass, passprec, dribbling, foulssub, foulscomm, tackles, tacklesper, breaks);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/statsbox/statsmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/statsbox/statsmanager.jsp").forward(request, response);
			break;
		}
	}
	

}
