package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.UserDTO;

import it.contrader.model.User;
import it.contrader.model.User.Usertype;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class UserConverter extends AbstractConverter<User,UserDTO> {
	Usertype usertype;
	@Override
	public User toEntity(UserDTO userDTO) {
		User user = null;
		if(userDTO.getUsertype()==null) {
			
			userDTO.setUsertype(usertype.USER);
		}
		if (userDTO != null) {
			user = new User(userDTO.getId(),userDTO.getUsername(),userDTO.getPassword(),userDTO.getUsertype(), userDTO.getName(), userDTO.getEmail());			
		}
		return user;
	}

	@Override
	public UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if(user.getUsertype()==null) {
			
			user.setUsertype(usertype.USER);
		}
		if (user != null) {
			userDTO = new UserDTO(user.getId(),user.getUsername(),user.getPassword(),user.getUsertype(), user.getName(), user.getEmail());
			
		}
		return userDTO;
	}
}