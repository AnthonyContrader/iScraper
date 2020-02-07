package it.contrader.service;

import it.contrader.converter.SearchConverter;
import it.contrader.dao.SearchDAO;
import it.contrader.dto.SearchDTO;
import it.contrader.model.Search;

public class SearchService extends AbstractService<Search, SearchDTO>{
	
	public SearchService() {
		this.dao = new SearchDAO();
		this.converter = new SearchConverter();
	}

	@Override
	public SearchDTO read(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
