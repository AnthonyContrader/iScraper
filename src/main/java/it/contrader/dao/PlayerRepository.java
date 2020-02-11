package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Player;
import it.contrader.model.User;

@Repository
@Transactional
public interface PlayerRepository extends CrudRepository<Player, Integer>{
	
	public List<Player> getAll();
	public boolean insert(Player player);
	public Player read(int id);
	public boolean update(Player player);
	public boolean delete(int id);

}
