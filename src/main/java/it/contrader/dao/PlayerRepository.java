package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Player;
import it.contrader.model.Team;


@Repository
@Transactional
public interface PlayerRepository extends CrudRepository<Player, Integer>{
	
	List<Player> findByTeam(Team team);
}
