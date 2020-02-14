package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.InjuryConverter;
import it.contrader.dao.InjuryRepository;
import it.contrader.dto.InjuryDTO;
import it.contrader.model.Player;
import it.contrader.model.Injury;
import java.util.List;

@Service
public class InjuryService extends AbstractService<Injury, InjuryDTO>{
	
	@Autowired
	private InjuryConverter converter;
	@Autowired
	private InjuryRepository repository;
	
	public List<InjuryDTO> findByPlayer(Player player) {
		return converter.toDTOList(repository.findByPlayer(player));
	}
}
