package it.contrader.dto;

import javax.persistence.Entity;

import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class UserDTO {

	private Long id;

	private String username;

	private String password;

	private Usertype usertype;

}
