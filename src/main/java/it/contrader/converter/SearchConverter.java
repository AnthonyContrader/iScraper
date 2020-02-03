package it.contrader.converter;

import it.contrader.dto.SearchDTO;
import it.contrader.model.Search;

import java.util.ArrayList;
import java.util.List;


public class SearchConverter implements Converter<Search, SearchDTO>{



	public SearchDTO toDTO(Search search) {
		SearchDTO searchDTO = new SearchDTO(search.getID(), search.getDate(), search.getValue(), search.getIndex(), search.getUser(), search.getPlayer());
		return searchDTO;
	}
	
	public Search toEntity(SearchDTO searchDTO) {
		Search search = new Search(searchDTO.getID(), searchDTO.getDate(), searchDTO.getValue(), searchDTO.getIndex(), searchDTO.getUser(), searchDTO.getPlayer());
		return search;
	}
	
	public List<SearchDTO> toDTOList(List<Search> searchList){
		List<SearchDTO> searchDTOList = new ArrayList<SearchDTO>();
		
		for (Search search : searchList) {
			searchDTOList.add(toDTO(search));
		}
		return searchDTOList;
	}
}
