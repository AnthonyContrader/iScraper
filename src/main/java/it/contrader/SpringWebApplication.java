package it.contrader;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.contrader.dto.PlayerDTO;
import it.contrader.model.Team;
import it.contrader.service.PlayerService;

import org.springframework.boot.SpringApplication;

/**
 * 
 * Da qui parte l'applicazione SpringBoot.
 * 
 * @author SpringBoot
 *
 */
@SpringBootApplication
public class SpringWebApplication {

	public static void main(String[] args) {
		

		SpringApplication.run(SpringWebApplication.class, args);
	}
}
