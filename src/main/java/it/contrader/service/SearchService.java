package it.contrader.service;

import it.contrader.converter.SearchConverter;
import it.contrader.dao.SearchDAO;
import it.contrader.dto.SearchDTO;

import java.util.List;

public class SearchService extends AbstractService{

	private SearchDAO searchDAO;
	private SearchConverter searchConverter;
	
	public SearchService() {
		searchDAO = new SearchDAO();
		searchConverter = new SearchConverter();
	}
}
