package it.contrader.servlets;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

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
	String usertype = new String("");
	
	public SearchServlet() {
		usertype = new String("");
	}
	
	public void updateList(HttpServletRequest request) {
		Service<SearchDTO> service = new SearchService();
		List<SearchDTO> listDTO = service.getAll();
		try {
			usertype = request.getSession().getAttribute("utente").toString();
		} catch (NullPointerException e) {
			getServletContext().getRequestDispatcher("/index.jsp");
		}
		if (usertype.isEmpty()) getServletContext().getRequestDispatcher("/index.jsp");
		switch (usertype/*sessionUser.getUsertype()*/) {
		
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
		//SimpleDateFormat format = new SimpleDateFormat("dMyyyy");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		Date search_date = new Date(0);
		int value = 0, index = 0, user = 0;
		short player = 0;
		String messaggio = new String("");
		String errore = new String("");
		boolean datiErrati=false;
		if (request.getAttribute("messaggio") != null) {
			request.removeAttribute("messaggio");
		}
		//sessionUser = (UserDTO)request.getSession().getAttribute("user");
		//try {
		//	request.setAttribute("userId", sessionUser.getId());
		//} catch (NullPointerException e) {
		//	getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		//}
		
		
		switch (mode.toUpperCase()) {
		
		case "SEARCHLIST":
	 		updateList(request);
	 		try {
				usertype = request.getSession().getAttribute("utente").toString();
			} catch (NullPointerException e) {
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			switch (usertype/*request.getSession().getAttribute("utente").toString()/*sessionUser.getUsertype()*/) {
			
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
			try {
				usertype = request.getSession().getAttribute("utente").toString();
			} catch (NullPointerException e) {
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			switch (usertype/*request.getSession().getAttribute("utente").toString()/*sessionUser.getUsertype()*/) {
			
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
			try {
				usertype = request.getSession().getAttribute("utente").toString();
			} catch (NullPointerException e) {
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			switch (usertype/*request.getSession().getAttribute("utente").toString()/*sessionUser.getUsertype()*/) {
			
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
			messaggio = InputValidation.intValidation(request.getParameter("player_value"));
			errore = new String("");
			datiErrati = false;
			if (messaggio.equals("ok")) {
				value = Integer.parseInt(request.getParameter("player_value"));
			} else {
				datiErrati = true;
				errore = errore+ "Valore giocatore: " + messaggio + "<br>";
			}
			messaggio = InputValidation.intValidation(request.getParameter("player_index"));
			if (messaggio.equals("ok")) {
				index = Integer.parseInt(request.getParameter("player_index"));
			} else {
				datiErrati = true;
				errore = errore + "Indice giocatore: " + messaggio + "<br>";
			}
			messaggio = InputValidation.intValidation(request.getParameter("user_id"));
			if (messaggio.equals("ok")) {
				user = Integer.parseInt(request.getParameter("user_id"));
			} else {
				datiErrati = true;
				errore = errore + "Id Utente: " + messaggio + "<br>";
			}
			messaggio = InputValidation.shortValidation(request.getParameter("player_id"));
			if (messaggio.equals("ok")) {
				player = Short.parseShort(request.getParameter("player_id"));
			} else {
				datiErrati = true;
				errore = errore + "Id Giocatore: " + messaggio + "<br>";
			}
			if(datiErrati) {
				request.setAttribute("messaggio", errore);
				try {
					usertype = request.getSession().getAttribute("utente").toString();
				} catch (NullPointerException e) {
					getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				}
				switch (usertype/*request.getSession().getAttribute("utente").toString()*/) {
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
			} else {
				dto = new SearchDTO(search_date, value, index, user, player);
				ans = service.insert(dto);
				request.setAttribute("ans", ans);
				try {
					usertype = request.getSession().getAttribute("utente").toString();
				} catch (NullPointerException e) {
					getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				}
				switch (usertype/*request.getSession().getAttribute("utente").toString()/*sessionUser.getUsertype()*/) {
				
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
			}

		break;
		
		case "UPDATE":
			try {
				usertype = request.getSession().getAttribute("utente").toString();
			} catch (NullPointerException e) {
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			switch (usertype/*request.getSession().getAttribute("utente").toString()/*sessionUser.getUsertype()*/) {
			
			case "ADMIN":
				messaggio = InputValidation.intValidation(request.getParameter("player_value"));
				errore = new String("");
				datiErrati = false;
				if (messaggio.equals("ok")) {
					value = Integer.parseInt(request.getParameter("player_value"));
				} else {
					datiErrati = true;
					errore = errore+ "Valore giocatore: " + messaggio + "<br>";
				}
				messaggio = InputValidation.intValidation(request.getParameter("player_index"));
				if (messaggio.equals("ok")) {
					index = Integer.parseInt(request.getParameter("player_index"));
				} else {
					datiErrati = true;
					errore = errore + "Indice giocatore: " + messaggio + "<br>";
				}
				messaggio = InputValidation.shortValidation(request.getParameter("player_id"));
				if (messaggio.equals("ok")) {
					player = Short.parseShort(request.getParameter("player_id"));
				} else {
					datiErrati = true;
					errore = errore + "Id Giocatore: " + messaggio + "<br>";
				}
				id = Integer.parseInt(request.getParameter("id"));
				if (datiErrati) {
					request.setAttribute("messaggio", errore);
					try {
						usertype = request.getSession().getAttribute("utente").toString();
					} catch (NullPointerException e) {
						getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
					}
					switch (usertype/*request.getSession().getAttribute("utente").toString()*/) {
					
					case "ADMIN":
						//updateList(request);
						getServletContext().getRequestDispatcher("/SearchServlet?mode=read&update=true&id="+id).forward(request, response);
						break;
						
					default:
						getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
						break;
					}
				} else {
					dto = new SearchDTO(id, search_date, value, index, user, player);
					ans = service.update(dto);
					request.setAttribute("ans", ans);
					updateList(request);
					getServletContext().getRequestDispatcher("/search/searchmanager.jsp").forward(request, response);
				}
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
			try {
				usertype = request.getSession().getAttribute("utente").toString();
			} catch (NullPointerException e) {
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			switch (usertype/*request.getSession().getAttribute("utente").toString()/*sessionUser.getUsertype()*/) {
			
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