package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;
import it.contrader.model.Team;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TeamRepository extends CrudRepository<Team, Long>{

	List<Team> findByName(String name);
}
