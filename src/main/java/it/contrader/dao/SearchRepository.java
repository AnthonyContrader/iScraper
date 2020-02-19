package it.contrader.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;
import it.contrader.model.Search;

@Repository
@Transactional
public interface SearchRepository extends CrudRepository<Search, Long> {

	List<Search> findByUser(User user);
	
}
