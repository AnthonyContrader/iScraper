package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.StatsboxConverter;
import it.contrader.dao.StatsboxRepository;
import it.contrader.dto.StatsboxDTO;
import it.contrader.model.Statsbox;

@Service
public class StatsboxService extends AbstractService<Statsbox, StatsboxDTO>{

	@Autowired
	private StatsboxConverter converter;
	@Autowired
	private StatsboxRepository repository;
	
	public List<StatsboxDTO> findByName(String name, String surname) {
		return converter.toListDTO(repository.findByName(name, surname));
	}
}
