package it.contrader.servlets;

import java.util.Calendar;
//import java.util.GregorianCalendar;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import it.contrader.dto.SearchDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.SearchService;
import it.contrader.service.Service;
import java.sql.Date;
import java.text.SimpleDateFormat;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public SearchServlet() {}
	
	public void updateList(HttpServletRequest request) {
		Service<SearchDTO> service = new SearchService();
		List<SearchDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<SearchDTO> service = new SearchService();
		String mode = request.getParameter("mode");
		SearchDTO dto;
		int id;
		boolean ans;
		SimpleDateFormat format = new SimpleDateFormat("dMyyyy");
		Date search_date = new Date(Calendar.getInstance().getTimeInMillis());
		int value = 0, index = 0, user = 0;
		short player = 0;
		
		switch (mode.toUpperCase()) {
		
		case "SEARCHLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
			break;
			
		case "READ":
			updateList(request);
			id = Integer.parseInt(request.getParameter("search_id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			if (request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/search/readsearch.jsp").forward(request, response);
			} else {
				getServletContext().getRequestDispatcher("/search/updatesearch.jsp").forward(request, response);
			}
			break;
		
		case "INSERT":
			try {
				search_date = new Date(format.parse(request.getParameter("search_date")).getTime());
			} catch (Exception e) {}
			try {
				value = Integer.parseInt(request.getParameter("player_value"));
			} catch (Exception e) {}
			try {
				index = Integer.parseInt(request.getParameter("player_index"));
			} catch (Exception e) {}
			try {
				user = Integer.parseInt(request.getParameter("user_id"));
			} catch (Exception e) {}
			try {
				player = Short.parseShort(request.getParameter("player_id"));
			} catch (Exception e) {}
			dto = new SearchDTO(search_date, value, index, user, player);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
		break;
		
		case "UPDATE":
			try {
				search_date = new Date(format.parse(request.getParameter("search_date")).getTime());
			} catch (Exception e) {}
			try {
				value = Integer.parseInt(request.getParameter("player_value"));
			} catch (Exception e) {}
			try {
				index = Integer.parseInt(request.getParameter("player_index"));
			} catch (Exception e) {}
			try {
				user = Integer.parseInt(request.getParameter("user_id"));
			} catch (Exception e) {}
			try {
				player = Short.parseShort(request.getParameter("player_id"));
			} catch (Exception e) {}
			id = Integer.parseInt(request.getParameter("id"));
			dto = new SearchDTO(search_date, value, index, user, player);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			/*String inputString;
			inputString = request.getParameter("search_date");
			try {
				search_date = new Date(format.parse(request.getParameter("search_date")).getTime());
			} catch (Exception e) {}
			if (!inputString.isEmpty() && inputString != null && (inputString.chars().allMatch( Character::isDigit))) {
				try {
					value = Integer.parseInt(request.getParameter("player_value"));
				} catch (Exception e) {}
			} else { value = 0; }
			if (!inputString.isEmpty() && inputString != null && (inputString.chars().allMatch( Character::isDigit))) {
					try {
					index = Integer.parseInt(request.getParameter("player_index"));
				} catch (Exception e) {}
			} else { index = 0; }
			if (!inputString.isEmpty() && inputString != null && (inputString.chars().allMatch( Character::isDigit))) {
				try {
					user = Integer.parseInt(request.getParameter("user_id"));
				} catch (Exception e) {}
			} else { user = 0; }
			if (!inputString.isEmpty() && inputString != null && (inputString.chars().allMatch( Character::isDigit))) {
				try {
					player = Short.parseShort(request.getParameter("player_id"));
				} catch (Exception e) {}
			} else { player = 0; }
			id = Integer.parseInt(request.getParameter("search_id"));
			dto = new SearchDTO(id, search_date, value, index, user, player);
			ans = service.insert(dto);
			updateList(request);*/
			getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
		break;
		
		case "DELETE":
			id = Integer.parseInt(request.getParameter("search_id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
		}
	}
}	