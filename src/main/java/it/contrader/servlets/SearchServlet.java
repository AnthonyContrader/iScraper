package it.contrader.servlets;

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
import it.contrader.utils.InputValidation;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//UserDTO sessionUser;
	
	public SearchServlet() {}
	
	public void updateList(HttpServletRequest request) {
		Service<SearchDTO> service = new SearchService();
		List<SearchDTO> listDTO = service.getAll();
		
		switch (request.getSession().getAttribute("utente").toString()/*sessionUser.getUsertype()*/) {
		
		case "ADMIN":
			request.setAttribute("list", listDTO);
			break;
		
		case "USER":
			SearchUserDTO userDTO;
			List<SearchUserDTO> listUserDTO = new ArrayList<>();
			for (SearchDTO element : listDTO) {	
				if (element.getUser()==Integer.parseInt(request.getSession().getAttribute("userId").toString())/*sessionUser.getId()*/) {
					userDTO = new SearchUserDTO();
					userDTO.setID(element.getID());
					userDTO.setDate(element.getDate());
					userDTO.setIndex(element.getIndex());
					userDTO.setValue(element.getValue());
					userDTO.setPlayer(element.getPlayer());
					listUserDTO.add(userDTO);
				}
			}
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
		Date search_date = new Date(0);
		int value = 0, index = 0, user = 0;
		short player = 0;
		//sessionUser = (UserDTO)request.getSession().getAttribute("user");
		//try {
		//	request.setAttribute("userId", sessionUser.getId());
		//} catch (NullPointerException e) {
		//	getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		//}
		
		
		switch (mode.toUpperCase()) {
		
		case "SEARCHLIST":
	 		updateList(request);
			switch (request.getSession().getAttribute("utente").toString()/*sessionUser.getUsertype()*/) {
			
			case "ADMIN":
				getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
				break;
				
			case "USER":
				getServletContext().getRequestDispatcher("/search/searchusermanager.jsp").forward(request, response);
				break;
				
			default:
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			}
			break;
			
		case "READ":
			updateList(request);
			id = Integer.parseInt(request.getParameter("id"));
			switch (request.getSession().getAttribute("utente").toString()/*sessionUser.getUsertype()*/) {
			
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
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			}
			break;
		
		case "INSERT":
			switch (request.getSession().getAttribute("utente").toString()/*sessionUser.getUsertype()*/) {
			
			case "ADMIN":
				try {
					search_date = new Date(format2.parse(request.getParameter("search_date")).getTime());
				} catch (Exception e) {
					updateList(request);
					getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
				}
				break;
				
			case "USER":
				try {
					search_date = new Date(format2.parse(request.getParameter("search_date")).getTime());
				} catch (Exception e) {
					updateList(request);
					getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
				}	
				break;
				
			default:
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			}
			String messaggio = InputValidation.intValidation(request.getParameter("player_value"), "/search/searchmanager.jsp");
			String errore = new String("");
			if (messaggio.equals("ok")) {
				value = Integer.parseInt(request.getParameter("player_value"));
			} else {
				errore = errore + messaggio + "\n";
				//request.setAttribute("messaggio", messaggio);
				//updateList(request);
				//getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
			}
			try {
				index = Integer.parseInt(request.getParameter("player_index"));
			} catch (Exception e) {
				updateList(request);
				getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
			}
			try {
				user = Integer.parseInt(request.getParameter("user_id"));
			} catch (Exception e) {
				updateList(request);
				getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
			}
			try {
				player = Short.parseShort(request.getParameter("player_id"));
			} catch (Exception e) {
				updateList(request);
				getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
			}
			dto = new SearchDTO(search_date, value, index, user, player);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			switch (request.getSession().getAttribute("utente").toString()/*sessionUser.getUsertype()*/) {
			
			case "ADMIN":
				updateList(request);
				getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
				break;
				
			case "USER":
				updateList(request);
				getServletContext().getRequestDispatcher("/search/searchusermanager.jsp").forward(request, response);
				break;
				
			default:
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			}

		break;
		
		case "UPDATE":
			switch (request.getSession().getAttribute("utente").toString()/*sessionUser.getUsertype()*/) {
			
			case "ADMIN":
				try {
					search_date = new Date(format.parse(request.getParameter("search_date")).getTime());
				} catch (Exception e) {
					updateList(request);
					getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
				}
				try {
					value = Integer.parseInt(request.getParameter("player_value"));
				} catch(Exception e){
					updateList(request);
					getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
				}
				try {
					index = Integer.parseInt(request.getParameter("player_index"));
				} catch(Exception e) {
					updateList(request);
					getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
				}
				try {
					user = Integer.parseInt(request.getParameter("user_id"));
				} catch(Exception e) {
					updateList(request);
					getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
				}
				try {
					player = Short.parseShort(request.getParameter("player_id"));
				} catch (Exception e) {
					updateList(request);
					getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
				}
				id = Integer.parseInt(request.getParameter("id"));
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
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			}
			break;
		
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			switch (request.getSession().getAttribute("utente").toString()/*sessionUser.getUsertype()*/) {
			
			case "ADMIN":
				ans = service.delete(id);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
				break;
			
			case "USER":
				dto = service.read(id);
				//if (dto.getUser()!=sessionUser.getId())
				if(dto.getUser()!=Integer.parseInt(request.getSession().getAttribute("userId").toString()))
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
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			}
		}
	}
}	