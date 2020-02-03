package it.contrader.service;

import it.contrader.converter.UserConverter;
import it.contrader.dao.LoginDAO;
import it.contrader.dto.UserDTO;

public class LoginService {

	private LoginDAO loginDAO;
	private UserConverter converter;
	/**
	 * Costruttore della classe, crea un oggetto di tipo LoginDAO per poter chiamare il metodo del DAO
	 */
	public LoginService() {
		this.loginDAO = new LoginDAO();
		this.converter = new UserConverter();
	}

	/**
	 * Chiama il metodo del DAO e ottiene una stringa (lo usertype)
	 */
	public UserDTO login(String username, String password) {
		
		return converter.toDTO(loginDAO.login(username, password));
	}	
}