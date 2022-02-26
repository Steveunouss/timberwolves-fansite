package learn.Timberwolves.data.mapper;

import learn.Timberwolves.model.Player;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerMapper implements RowMapper<Player>
{
	@Override
	public Player mapRow(ResultSet resultSet, int i) throws SQLException
	{
		Player player = new Player();
		player.setPlayerId((resultSet.getInt("player_id")));
		player.setFirstName(resultSet.getString("firstName"));
		player.setLastName(resultSet.getString("lastName"));
		player.setAlias(resultSet.getString("nicknames"));
		player.setHeight(resultSet.getInt("heightInInches"));
		player.setWeight(resultSet.getInt("weightInPounds"));
		player.setJerseyNumber(resultSet.getInt("jerseyNumber"));
		player.setFirstTeamName(resultSet.getString("shortName"));
		player.setImage(resultSet.getString("image"));
		return player;
	}
}
