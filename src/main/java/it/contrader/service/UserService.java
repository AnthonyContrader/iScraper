package it.contrader.service;

import org.hibernate.loader.custom.Return;
import org.springframework.stereotype.Service;

import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import it.contrader.model.User.Usertype;

/**
 * Estende AbstractService con parametri User e UserDTO. 
 * Implementa il metodo di login ed eredita quelli Abstract. 
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class UserService extends AbstractService<User,UserDTO> {
	
	//ALL crud methods in AbstractService
//	private UserService userService=new UserService();
	//LOGIN method
	public UserDTO findByUsernameAndPassword(String username, String password) {
		return converter.toDTO(((UserRepository)repository).findByUsernameAndPassword(username, password));
	}

//	public UserDTO insert(UserDTO user) {
//		if(user.getUsertype()==null) {
//			user.setUsertype(Usertype.USER);
//		}
//		return userService.insert(user);
//		 
//	}

}
