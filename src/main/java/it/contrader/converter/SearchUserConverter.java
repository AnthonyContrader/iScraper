package it.contrader.converter;

import it.contrader.dto.SearchUserDTO;
import it.contrader.model.Search;

import java.util.ArrayList;
import java.util.List;


public class SearchUserConverter implements Converter<Search, SearchUserDTO>{



	public SearchUserDTO toDTO(Search search) {
		SearchUserDTO searchUserDTO = new SearchUserDTO(search.getID(), search.getDate(), search.getValue(), search.getIndex(), search.getPlayer());
		return searchUserDTO;
	}
	
	public Search toEntity(SearchUserDTO searchUserDTO) {
		Search search = new Search(searchUserDTO.getID(), searchUserDTO.getDate(), searchUserDTO.getValue(), searchUserDTO.getIndex(), 0, searchUserDTO.getPlayer());
		return search;
	}
	
	public Search toEntity(SearchUserDTO searchUserDTO, int user_id) {
		Search search = toEntity(searchUserDTO);
		search.setUser(user_id);
		return search;
	}
	
	public List<SearchUserDTO> toDTOList(List<Search> searchList){
		List<SearchUserDTO> searchUserDTOList = new ArrayList<SearchUserDTO>();
		
		for (Search search : searchList) {
			searchUserDTOList.add(toDTO(search));
		}
		return searchUserDTOList;
	}
}
