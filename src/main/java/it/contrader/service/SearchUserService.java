package it.contrader.service;

import it.contrader.converter.SearchUserConverter;
import it.contrader.dao.SearchDAO;
import it.contrader.dto.SearchUserDTO;
import it.contrader.model.Search;

public class SearchUserService extends AbstractService<Search, SearchUserDTO>{
	
	public SearchUserService() {
		this.dao = new SearchDAO();
		this.converter = new SearchUserConverter();
	}
}
