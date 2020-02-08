package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.utils.InputValidation;
import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
import it.contrader.service.UserService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<UserDTO> service = new UserService();
		List<UserDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<UserDTO> service = new UserService();
		String mode = request.getParameter("mode");
		UserDTO dto;
		int id;
		boolean ans;
		String errore = new String("");
		boolean datiErrati=false;
		if (request.getAttribute("messaggio") != null) {
			request.removeAttribute("messaggio");
		}
		
		switch (mode.toUpperCase()) {

		case "USERLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "READ":
			if (InputValidation.intValidation(request.getParameter("id").toString()) == "ok") {
				id = Integer.parseInt(request.getParameter("id").trim());
				dto = service.read(id);
				request.setAttribute("dto", dto);
				if (request.getParameter("update") == null) {
					getServletContext().getRequestDispatcher("/user/readuser.jsp").forward(request, response);
				}			
				else getServletContext().getRequestDispatcher("/user/updateuser.jsp").forward(request, response);
				break;
			} else getServletContext().getRequestDispatcher("/user/updateuser.jsp").forward(request, response);
	
		case "INSERT":
			String username = request.getParameter("username").toString().trim();
			if (username.isEmpty()) {
				errore = errore + "Campo username vuoto <br>";
				datiErrati = true;
			}
			String password = request.getParameter("password").toString().trim();
			if (password.isEmpty()) {
				errore = errore + "Campo password vuoto <br>";
				datiErrati = true;
			}
			String usertype = request.getParameter("usertype").toString().trim();
			if (usertype.isEmpty()) {
				errore = errore + "Campo tipo utente vuoto <br>";
				datiErrati = true;
			} else if (usertype!="user" && usertype!="admin") {
				errore = errore + "Tipologia utente non riconosciuta <br>";
				datiErrati = true;
			}
			String name = request.getParameter("name").toString().trim();
			if (name.isEmpty()) {
				errore = errore + "Campo nome vuoto <br>";
				datiErrati = true;
			}
			String email = request.getParameter("email").toString().trim();
			if (email.isEmpty()) {
				errore = errore + "Campo email vuoto <br>";
				datiErrati = true;
			}
			if (datiErrati) {
				request.setAttribute("messaggio", errore);
				getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			} else {
				dto = new UserDTO (username,password,usertype,name,email);
				ans = service.insert(dto);
				request.setAttribute("ans", ans);
				updateList(request);
				boolean newuser = Boolean.parseBoolean(request.getParameter("newuser"));
				if (newuser) {
					getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				}
				else {
					getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
				}
			}
			break;
			
		case "INSERTUSER":
			username = request.getParameter("register_username").toString().trim();
			password = request.getParameter("register_password").toString().trim();
			//usertype = "user";
			//request.getParameter("usertype").toString();
			name = request.getParameter("name").toString().trim();
			email = request.getParameter("email").toString().trim();
			if (username.isEmpty()) {
				datiErrati = true;
				errore = errore + "Campo username vuoto <br>";
			}
			if (password.isEmpty()) {
				datiErrati = true;
				errore = errore + "Campo password vuoto <br>";
			}
			if (name.isEmpty()) {
				datiErrati = true;
				errore = errore + "Campo nome vuoto <br>";
			}
			if (email.isEmpty()) {
				datiErrati = true;
				errore = errore + "Campo email vuoto <br>";
			}
			if (datiErrati) {
				request.setAttribute("messaggioCreazione", errore);
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				dto = new UserDTO (username,password,"user",name,email);
				ans = service.insert(dto);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			break;
			
		case "UPDATE":
			username = request.getParameter("username").toString().trim();
			if (username.isEmpty()) {
				errore = errore + "Campo username vuoto <br>";
				datiErrati = true;
			}
			password = request.getParameter("password").toString().trim();
			if (password.isEmpty()) {
				errore = errore + "Campo password vuoto <br>";
				datiErrati = true;
			}
			usertype = request.getParameter("usertype").toString().trim();
			if (usertype.isEmpty()) {
				errore = errore + "Campo tipo utente vuoto <br>";
				datiErrati = true;
			} else if (usertype.toLowerCase().equals("user")) {
				if (usertype.toLowerCase().equals("admin")) {
					errore = errore + "Tipologia utente non riconosciuta <br>";
					datiErrati = true;
				}
			}
			name = request.getParameter("name").toString().trim();
			if (name.isEmpty()) {
				errore = errore + "Campo nome vuoto <br>";
				datiErrati = true;
			}
			email = request.getParameter("email").toString().trim();
			if (email.isEmpty()) {
				errore = errore + "Campo email vuoto <br>";
				datiErrati = true;
			}
			if (datiErrati) {
				request.setAttribute("messaggio", errore);
				updateList(request);
				if (InputValidation.intValidation(request.getParameter("id").toString()) == "ok") {
					id = Integer.parseInt(request.getParameter("id").trim());
					request.setAttribute("messaggio", errore);
					getServletContext().getRequestDispatcher("/UserServlet?mode=read&update=true&id="+id).forward(request, response);
				} else {
					getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
				}
			} else {
				if (InputValidation.intValidation(request.getParameter("id").toString()) == "ok") {
					id = Integer.parseInt(request.getParameter("id").trim());
					dto = new UserDTO (id, username,password,usertype,name,email);
					ans = service.update(dto);
					request.setAttribute("ans", ans);
					updateList(request);
					boolean newuser = Boolean.parseBoolean(request.getParameter("newuser"));
					if (newuser) {
						getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
					}
					else {
						getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
					}
				} else {
					updateList(request);
					getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
				}
			}
			break;
			/*username = request.getParameter("username");
			password = request.getParameter("password");
			usertype = request.getParameter("usertype");
			name = request.getParameter("name");
			email = request.getParameter("email");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new UserDTO (id,username, password, usertype, name, email);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;*/

		case "DELETE":
			if (InputValidation.intValidation(request.getParameter("id").toString()) == "ok") {
				id = Integer.parseInt(request.getParameter("id").trim());
				ans = service.delete(id);
				request.setAttribute("ans", ans);
				updateList(request);
			}
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;
		}
	}
}