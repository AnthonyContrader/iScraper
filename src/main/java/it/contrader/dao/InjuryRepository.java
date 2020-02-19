package it.contrader.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Injury;
import it.contrader.model.Player;

@Repository
@Transactional
public interface InjuryRepository extends CrudRepository<Injury, Long>{

	List<Injury> findByPlayer(Player player);
}
