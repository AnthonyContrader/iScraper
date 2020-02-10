package it.contrader.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.contrader.dto.UserDTO;
import it.contrader.service.LoginService;


/*
 * Login Servlet
 */
public class LoginServlet extends HttpServlet { 
	// UID della servlet
	private static final long serialVersionUID = 1L;

	/** 
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * 
	 * Metodo che gestisce le request che arrivano dalla JSP.
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession session = request.getSession();
		session.setAttribute("utente", null); 
 
		
		
		LoginService service = new LoginService();
		if (request.getAttribute("messaggio") != null) {
			request.removeAttribute("messaggio");
		}
		boolean datiErrati = false;
		String errore = new String("");
		
		if (request != null) {
			String username = request.getParameter("username").toString().trim();
			if (username.isEmpty()) {
				datiErrati = true;
				errore = errore + "Campo username vuoto <br>";
			}
			String password = request.getParameter("password").toString().trim();
			if (password.isEmpty()) {
				datiErrati = true;
				errore = errore + "Campo password vuoto <br>";
			}
			if (datiErrati) {
				request.setAttribute("messaggio", errore);
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else {
				//come nei vecchi controller, invoca il service
				UserDTO dto = service.login(username, password);
				try {
					
					if (dto != null) {
						//se il login ha funzionato, salva l'utente nella sessione
						session.setAttribute("utente", dto.getUsertype().toString());
						session.setAttribute("userId", dto.getId());
						session.setAttribute("user", dto);
					}
						else
						//altrimenti torna alla pagina di login
						getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
					
					//esegue una switch case in base allo usertype per il reindirizzamento
					switch (dto.getUsertype().toUpperCase()) {
					case "ADMIN":
						//questo metodo reindirizza alla JSP tramite URL con una request e una response
						getServletContext().getRequestDispatcher("/homeadmin.jsp").forward(request, response);
						break;
						
					case "USER":
						getServletContext().getRequestDispatcher("/homeuser.jsp").forward(request, response);
						break;
						
					default:
						//di default rimanda al login
						getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
						break;
					}
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
