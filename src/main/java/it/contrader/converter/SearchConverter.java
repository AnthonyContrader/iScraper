package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.SearchDTO;
import it.contrader.model.Search;
import java.util.List;
import java.util.ArrayList;

@Component
public class SearchConverter extends AbstractConverter<Search, SearchDTO> {

	@Override
	public Search toEntity(SearchDTO searchDTO) {
		Search search = null;
		if (searchDTO!=null) {
			search = new Search(searchDTO.getId(), searchDTO.getSearch_date(), searchDTO.getValue(), searchDTO.getPlayer_index(), searchDTO.getUser(), searchDTO.getPlayer());		
		}
		return search;
	}
	
	@Override
	public SearchDTO toDTO(Search search) {
		SearchDTO searchDTO = null;
		if (search != null) {
			searchDTO = new SearchDTO(search.getId(), search.getSearch_date(), search.getValue(), search.getPlayer_index(), search.getUser(), search.getPlayer());		
		}
		return searchDTO;
	}
	
	public List<SearchDTO> toListDTO(List<Search> searchList){
		List<SearchDTO> searchDTOList = new ArrayList<SearchDTO>();
		for (Search search : searchList) {
			searchDTOList.add(toDTO(search));
		}
		return searchDTOList;
	}
}