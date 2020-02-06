package it.contrader.servlets;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import it.contrader.dto.UserDTO;
import it.contrader.dto.SearchDTO;
import it.contrader.dto.SearchUserDTO;
import it.contrader.service.SearchUserService;
import it.contrader.service.SearchService;
import it.contrader.service.Service;
import java.sql.Date;
import java.text.SimpleDateFormat;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDTO sessionUser;
	
	public SearchServlet() {}
	
	public void updateList(HttpServletRequest request) {
		Service<SearchDTO> service = new SearchService();
		List<SearchDTO> listDTO = service.getAll();
		
		switch (sessionUser.getUsertype()) {
		
		case "ADMIN":
			request.setAttribute("list", listDTO);
			break;
		
		case "USER":
			SearchUserDTO userDTO = new SearchUserDTO();
			List<SearchUserDTO> listUserDTO = new ArrayList<>();
			listDTO.forEach(element -> {
				if (element.getUser()==sessionUser.getId()) {
					userDTO.setID(element.getID());
					userDTO.setDate(element.getDate());
					userDTO.setIndex(element.getIndex());
					userDTO.setValue(element.getValue());
					userDTO.setPlayer(element.getPlayer());
					listUserDTO.add(userDTO);
				}
			});
			request.setAttribute("list", listUserDTO);
			break;
			
		default:
			break;
		}
		
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<SearchDTO> service = new SearchService();
		Service<SearchUserDTO> userService = new SearchUserService();
		String mode = request.getParameter("mode");
		SearchDTO dto;
		SearchUserDTO userDTO;
		int id;
		boolean ans;
		SimpleDateFormat format = new SimpleDateFormat("dMyyyy");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		Date search_date = new Date(Calendar.getInstance().getTimeInMillis());
		int value, index, user;
		short player;
		sessionUser = (UserDTO)request.getSession().getAttribute("user");
		
		
		switch (mode.toUpperCase()) {
		
		case "SEARCHLIST":
			updateList(request);
			request.setAttribute("sessionUser", sessionUser.getId());
			switch (sessionUser.getUsertype()) {
			
			case "ADMIN":
				getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
				break;
				
			case "USER":
				getServletContext().getRequestDispatcher("/search/searchusermanager.jsp").forward(request, response);
				break;
				
			default:
				//LogoutServlet
				break;
			}
			break;
			
		case "READ":
			updateList(request);
			id = Integer.parseInt(request.getParameter("id"));
			switch (sessionUser.getUsertype()) {
			
			case "ADMIN":
				dto = service.read(id);
				request.setAttribute("dto", dto);
				if (request.getParameter("update") == null) {
					getServletContext().getRequestDispatcher("/search/readsearch.jsp").forward(request, response);
				} else {
					getServletContext().getRequestDispatcher("/search/updatesearch.jsp").forward(request, response);
				}
				break;
				
			case "USER":
				userDTO = userService.read(id);
				request.setAttribute("dto", userDTO);
				getServletContext().getRequestDispatcher("/search/readusersearch.jsp").forward(request, response);
				break;
				
			default:
				//LogoutServlet
				break;
			}
			break;
		
		case "INSERT":
			try {
				String test = format2.parse(request.getParameter("search_date").toString()).toString();
				search_date = new Date(format2.parse(request.getParameter("search_date")).getTime());
			} catch (Exception e) {}
			try {
				value = Integer.parseInt(request.getParameter("player_value"));
			} catch (Exception e) {value=0;}
			try {
				index = Integer.parseInt(request.getParameter("player_index"));
			} catch (Exception e) {index=0;}
			try {
				user = Integer.parseInt(request.getParameter("user_id"));
			} catch (Exception e) {user=0;}
			try {
				player = Short.parseShort(request.getParameter("player_id"));
			} catch (Exception e) {player=0;}
			dto = new SearchDTO(search_date, value, index, user, player);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			switch (sessionUser.getUsertype()) {
			
			case "ADMIN":
				getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
				break;
				
			case "USER":
				getServletContext().getRequestDispatcher("/search/searchusermanager.jsp").forward(request, response);
				break;
				
			default:
				//logout
				break;
			}
		break;
		
		case "UPDATE":
			switch (sessionUser.getUsertype()) {
			
			case "ADMIN":
				try {
					search_date = new Date(format.parse(request.getParameter("search_date")).getTime());
				} catch (Exception e) {}
				try {
					value = Integer.parseInt(request.getParameter("player_value"));
				} catch(Exception e){value=0;}
				try {
					index = Integer.parseInt(request.getParameter("player_index"));
				} catch(Exception e) {index=0;}
				try {
					user = Integer.parseInt(request.getParameter("user_id"));
				} catch(Exception e) {user=0;}
				try {
					player = Short.parseShort(request.getParameter("player_id"));
				} catch (Exception e) {player=0;}
				try {
					id = Integer.parseInt(request.getParameter("id"));
				} catch (Exception e) {id=0;}
				dto = new SearchDTO(id, search_date, value, index, user, player);
				ans = service.update(dto);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
				break;
				
			case "USER":
				getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
				break;
				
			default:
				//logout
				break;
			}
			break;
		
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			switch (sessionUser.getUsertype()) {
			
			case "ADMIN":
				ans = service.delete(id);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
				break;
			
			case "USER":
				dto = service.read(id);
				if (dto.getUser()!=sessionUser.getId())
				{
					getServletContext().getRequestDispatcher("/search/searchusermanager.jsp").forward(request, response);
				} else {
					ans =  service.delete(id);
					request.setAttribute("ans", ans);
					updateList(request);
					getServletContext().getRequestDispatcher("/search/searchusermanager.jsp").forward(request, response);
				}
				break;
			
			default:
				//logout
				break;
			}
		}
	}
}	