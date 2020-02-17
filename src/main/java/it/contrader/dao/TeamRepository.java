package it.contrader.dao;

import javax.transaction.Transactional;
import it.contrader.model.Team;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TeamRepository extends CrudRepository<Team, Long>{

	Team findByName(String name);
	//List<Team> findByName(String name);
	//Team findByNameOne(String name);
}
