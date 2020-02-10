package it.contrader.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.PlayerDTO;



import it.contrader.service.PlayerService;

import it.contrader.service.Service;
import it.contrader.utils.InputValidation;

public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID=1;
	
	boolean t=false;
	public void updateList(HttpServletRequest request) {
		Service<PlayerDTO> service = new PlayerService();
		List<PlayerDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final HttpSession session = request.getSession(true);
		//final UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		
		
		
		String dd=request.getRemoteUser();
		request.setAttribute("tip", dd);
		

		
		Service<PlayerDTO> service = new PlayerService();
		String mode = request.getParameter("mode");
		PlayerDTO dto;
		int id=0;
		boolean ans;
		String errore = new String("");
		boolean datiErrati=false;
		
		if (request.getAttribute("messplayer") != null) {
			request.removeAttribute("messplayer");
		}
		if (request.getAttribute("messplayer2") != null) {
			request.removeAttribute("messplayer2");
		}
		if (request.getAttribute("messplayer3") != null) {
			request.removeAttribute("messplayer3");
		}
		 String player_name = null; 
		 String player_surname = null;
		 int age = 0; 
		 int actualMarketValue = 0;
		 int previousMarketValue = 0;
		 String position = null;
		 String team = null;
		
		switch (mode.toUpperCase()) {
		
		
			
		case "PLAYERLIST":
			
			updateList(request);
			if(session.getAttribute("utente").toString().equals("ADMIN")) {
				getServletContext().getRequestDispatcher("/player/playermanager.jsp").forward(request, response);
			}else {
				getServletContext().getRequestDispatcher("/player/playerusermanager.jsp").forward(request, response);
			}
			
			break;
			
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			
			request.setAttribute("dto", dto);
			
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/player/readplayer.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/player/updateplayer.jsp").forward(request, response);
			
			break;
	
	
		case "INSERT":
			if (InputValidation.checkLetters(request.getParameter("player_name").toString()).equals("")) {
				errore = errore + "Campo nome giocatore ha ricevut dati invalidi <br>";
				datiErrati = true;
			}

			try { 
				player_name = request.getParameter("player_name");
			} catch (Exception e) {}
			
			if (InputValidation.checkLetters(request.getParameter("player_surname").toString()).equals("")) {
				errore = errore + "Campo cognome giocatore ha ricevut dati invalidi <br>";
				datiErrati = true;
			}

			try {
				player_surname = request.getParameter("player_surname");
			} catch (Exception e) {}
			
			String newage = request.getParameter("age").toString();
			if (newage.isEmpty()) {
				errore = errore + "Campo Eta Giocatore vuoto <br>";
				datiErrati = true;
			}else if (InputValidation.checkAge(newage).equals("")) {
				errore = errore + "Campo Eta giocatore ha ricevut dati invalidi <br>";
				datiErrati = true;
			}
				
			try {
				age = Integer.parseInt(request.getParameter("age"));
			} catch (Exception e) {}
			
			String string=(request.getParameter("actual_value").toString());
			if(InputValidation.checkLetters(string).equals("ok")){
				errore = errore + "Campo Valore attuale giocatore ha ricevut dati invalidi <br>";
				datiErrati = true;
			}
			if (request.getParameter("actual_value").isEmpty()) {
				errore = errore + "Campo Valore attuale Giocatore vuoto <br>";
				datiErrati = true;
			}
			
			try {
				actualMarketValue = Integer.parseInt(request.getParameter("actual_value"));
			} catch (Exception e) {}
			
			 string=(request.getParameter("previous_value").toString());
			if(InputValidation.checkLetters(string).equals("ok")){
				errore = errore + "Campo Valore precedente giocatore ha ricevut dati invalidi <br>";
				datiErrati = true;
			}
			if (request.getParameter("previous_value").isEmpty()) {
				errore = errore + "Campo Valore Precedente Giocatore vuoto <br>";
				datiErrati = true;
			}
			
			try {
				previousMarketValue = Integer.parseInt(request.getParameter("previous_value"));
			} catch (Exception e) {}
			
			
			if (InputValidation.checkLetters(request.getParameter("position").toString()).equals("")) {
				errore = errore + "Campo Posizione giocatore ha ricevut dati invalidi <br>";
				datiErrati = true;
			}
			try {
				position = request.getParameter("position"); 
			} catch (Exception e) {}
			
			
			if (InputValidation.checkLetters(request.getParameter("team").toString()).equals("")) {
				errore = errore + "Campo Squadra giocatore ha ricevut dati invalidi <br>";
				datiErrati = true;
			}
			try {
				team = request.getParameter("team");
			} catch (Exception e) {}
			
			if (datiErrati) {
				request.setAttribute("messplayer", errore);
				updateList(request);
				getServletContext().getRequestDispatcher("/player/playermanager.jsp").forward(request, response);
			} else {
			
			dto = new PlayerDTO(player_name,player_surname,age,actualMarketValue,previousMarketValue,position,team);
		//System.out.println(dto);
			
			ans = service.insert(dto); 
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/player/playermanager.jsp").forward(request, response);}
		break;
		
		case "UPDATE":
			
			
			updateList(request);
			
			if (InputValidation.checkLetters(request.getParameter("player_name").toString()).equals("")) {
				errore = errore + "Campo nome giocatore ha ricevut dati invalidi <br>";
				datiErrati = true;
			}
			try {
				player_name = request.getParameter("player_name");
			} catch (Exception e) {}
			
			if (InputValidation.checkLetters(request.getParameter("player_surname").toString()).equals("")) {
				errore = errore + "Campo cognome giocatore ha ricevut dati invalidi <br>";
				datiErrati = true;
			}
			try {
				player_surname = request.getParameter("player_surname");
			} catch (Exception e) {}
			 newage = request.getParameter("age").toString();
			if (newage.isEmpty()) {
				errore = errore + "Campo Eta Giocatore vuoto <br>";
				datiErrati = true;
			}else if (InputValidation.checkAge(newage).equals("")) {
				errore = errore + "Campo Eta giocatore ha ricevut dati invalidi <br>";
				datiErrati = true;
			}
			try {
				age = Integer.parseInt(request.getParameter("age"));
			} catch (Exception e) {}
			
			 string=(request.getParameter("actual_value").toString());
			if(InputValidation.checkLetters(string).equals("ok")){
				errore = errore + "Campo Valore attuale giocatore ha ricevut dati invalidi <br>";
				datiErrati = true;
			}
			if (request.getParameter("actual_value").isEmpty()) {
				errore = errore + "Campo Valore attuale Giocatore vuoto <br>";
				datiErrati = true;
			}
			
			try {
				actualMarketValue = Integer.parseInt(request.getParameter("actual_value"));
			} catch (Exception e) {}
			
			 string=(request.getParameter("previous_value").toString());
			if(InputValidation.checkLetters(string).equals("ok")){
				errore = errore + "Campo Valore precedente giocatore ha ricevut dati invalidi <br>";
				datiErrati = true;
			}
			if (request.getParameter("previous_value").isEmpty()) {
				errore = errore + "Campo Valore Precedente Giocatore vuoto <br>";
				datiErrati = true;
			}
			
			try {
				previousMarketValue = Integer.parseInt(request.getParameter("previous_value"));
			} catch (Exception e) {}
			
			
			if (InputValidation.checkLetters(request.getParameter("position").toString()).equals("")) {
				errore = errore + "Campo Posizione giocatore ha ricevut dati invalidi <br>";
				datiErrati = true;
			}
			try {
				position = request.getParameter("position"); 
			} catch (Exception e) {}
			
			
			if (InputValidation.checkLetters(request.getParameter("team").toString()).equals("")) {
				errore = errore + "Campo Squadra giocatore ha ricevut dati invalidi <br>";
				datiErrati = true;
			}
			try {
				team = request.getParameter("team");
			} catch (Exception e) {}
			
			
			int i=0;
			List<PlayerDTO> listDTO = service.getAll();
			for(PlayerDTO player:listDTO){
				if(Integer.parseInt(request.getParameter("id"))==(player.getId())) {
				i++;	
				}
			}
			if(i==0) {
				errore = errore + " ID  Giocatore non trovato <br>";
				datiErrati = true;
			}
			if (request.getParameter("id").isEmpty()) {
				errore = errore + "Campo ID  Giocatore vuoto <br>";
				datiErrati = true;
			}
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (Exception e) {}
			
			if (datiErrati) {
				request.setAttribute("messplayer2", errore);
				updateList(request);
				getServletContext().getRequestDispatcher("/player/playermanager.jsp").forward(request, response);
			} else {
			
			
			
			dto = new PlayerDTO(id,player_name,player_surname,age,actualMarketValue,previousMarketValue,position,team);
			ans = service.update(dto);
			updateList(request);
			//String username = request.getParameter("username").toString();
			getServletContext().getRequestDispatcher("/player/playermanager.jsp").forward(request, response);}
		break;
		
		case "DELETE":
			
		
//			try {
//				player_name = request.getParameter("player_name");
//			} catch (Exception e) {}
//			try {
//				player_surname = request.getParameter("player_surname");
//			} catch (Exception e) {}
//			try {
//				age = Integer.parseInt(request.getParameter("age"));
//			} catch (Exception e) {}
//			
//			try {
//				actualMarketValue = Integer.parseInt(request.getParameter("actual_value"));
//			} catch (Exception e) {}
//			try {
//				previousMarketValue = Integer.parseInt(request.getParameter("previous_value"));
//			} catch (Exception e) {}
//			
//			try {
//				position = request.getParameter("position");
//			} catch (Exception e) {}
//			try {
//				team = request.getParameter("team");
//			} catch (Exception e) {}
			
			 i=0;
			 listDTO = service.getAll();
			for(PlayerDTO player:listDTO){
				if(Integer.parseInt(request.getParameter("id"))==(player.getId())) {
				i++;	
				}
			}
			if(i==0) {
				errore = errore + " ID  Giocatore non trovato <br>";
				datiErrati = true;
			}
			
			if (request.getParameter("id").isEmpty()) {
				errore = errore + "Campo ID  Giocatore vuoto <br>";
				datiErrati = true;
			}
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (Exception e) {}
			
			if (datiErrati) {
				request.setAttribute("messplayer3", errore);
				updateList(request);
				getServletContext().getRequestDispatcher("/player/playermanager.jsp").forward(request, response);
			} else {
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/player/playermanager.jsp").forward(request, response);}
		}
	}
}	