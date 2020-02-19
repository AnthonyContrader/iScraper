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
		
//		Team team=new Team();
//		team.setName("Milan");
//		PlayerService service=new PlayerService();
//		PlayerDTO playerDTO= new PlayerDTO( 3,"adas","ada",2,2,2,"www",team);
//		service.update(playerDTO);
		SpringApplication.run(SpringWebApplication.class, args);
	}
}
