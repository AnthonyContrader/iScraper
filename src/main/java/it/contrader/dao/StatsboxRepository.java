package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.dto.StatsboxDTO;
import it.contrader.model.Player;
import it.contrader.model.Statsbox;

@Repository
@Transactional
public interface StatsboxRepository extends CrudRepository<Statsbox, Long>{

	@Query(value="SELECT s FROM Statsbox s INNER JOIN Player p ON s.player = p.id WHERE p.player_name = ?1 AND p.player_surname= ?2")
	List<Statsbox> findByName(String name, String surname);
}
