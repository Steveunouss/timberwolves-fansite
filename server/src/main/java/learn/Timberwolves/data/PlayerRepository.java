package learn.Timberwolves.data;

import learn.Timberwolves.model.Player;

import java.util.List;

public interface PlayerRepository
{
	List<Player> findAll();

	Player findById(int playerId);

	Player add(Player player);

	boolean update(Player player);

	boolean deleteById(int playerId);
}
