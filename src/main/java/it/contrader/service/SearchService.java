package it.contrader.service;

import it.contrader.converter.SearchConverter;
import it.contrader.dao.SearchDAO;
import it.contrader.dto.SearchDTO;

import java.util.List;

public class SearchService {

	private SearchDAO searchDAO;
	private SearchConverter searchConverter;
	
	public SearchService() {
		searchDAO = new SearchDAO();
		searchConverter = new SearchConverter();
	}
	
	public List<SearchDTO> getAll(){
		return searchConverter.toDTOList(searchDAO.getAll());
	}
	
	public SearchDTO read(long id) {
		return searchConverter.toDTO(searchDAO.read(id));
	}
	
	public boolean insert(SearchDTO dto) {
		return searchDAO.insert(searchConverter.toEntity(dto));
	}
	public boolean update(SearchDTO dto) {
		return searchDAO.update(searchConverter.toEntity(dto));
	}
	
	public boolean delete(long id) {
		return searchDAO.delete(id);
	}	
}
