package it.contrader.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import it.contrader.dto.StatsboxDTO;
import it.contrader.service.StatsboxService;


@RestController
@RequestMapping("/statsbox")
@CrossOrigin(origins = "http://localhost:4200")
public class StatsboxController extends AbstractController<StatsboxDTO>{
	
	@Autowired
	private StatsboxService service;
	
	@GetMapping("/readByName")
	public List<StatsboxDTO> readByName(@RequestParam("name") String name, @RequestParam("surname") String surname) {
		return this.service.findByName(name, surname);
	}
}

