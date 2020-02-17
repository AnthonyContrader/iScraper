package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.SearchConverter;
import it.contrader.dao.SearchRepository;
import it.contrader.dto.SearchDTO;
import it.contrader.model.User;
import it.contrader.model.Search;
import java.util.List;

@Service
public class SearchService extends AbstractService<Search, SearchDTO> {
	
	@Autowired
	private SearchConverter converter;
	@Autowired
	private SearchRepository repository;
	
	public List<SearchDTO> findByUser(User user) {
		return converter.toDTOList(repository.findByUser(user));
	}
}
