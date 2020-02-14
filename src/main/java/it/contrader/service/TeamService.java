package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.TeamConverter;
import it.contrader.dao.TeamRepository;
import it.contrader.dto.TeamDTO;
import it.contrader.model.Team;



@Service
public class TeamService extends AbstractService<Team,TeamDTO>{
	@Autowired
	private TeamConverter converter;
	
	@Autowired
	private TeamRepository repository;
	
	public TeamDTO findByName(String name) {
		return converter.toDTO(repository.findByName(name));}
//	public List<TeamDTO> findByName(String name) {
//		return converter.toListDTO(repository.findByName(name));
//	}
//	public TeamDTO findByNameDTO(String name) {
//		return converter.toDTO(repository.findByNameOne(name));
//	}
}
