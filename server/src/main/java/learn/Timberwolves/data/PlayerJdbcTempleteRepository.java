package learn.Timberwolves.data;


import learn.Timberwolves.data.mapper.PlayerMapper;
import learn.Timberwolves.model.Player;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class PlayerJdbcTempleteRepository implements PlayerRepository
{
	private final JdbcTemplate jdbcTemplate;

	public PlayerJdbcTempleteRepository(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<Player> findAll()
	{
		final String sql = "select p.player_id, p.firstName, p.lastName, " +
				"p.nicknames, p.heightInInches, p.weightInPounds, " +
				"t.shortName, p.jerseyNumber, p.image " +
				"from player p " +
				"left outer join team t on t.team_id = p.previousTeamId;";
		return jdbcTemplate.query(sql, new PlayerMapper());
	}

	@Override
	@Transactional
	public Player findById(int playerId)
	{
		final String sql = "select p.player_id, p.firstname, p.lastName, " +
				"p.nicknames, p.heightInInches, p.weightInPounds, " +
				"t.shortName, p.jerseyNumber, p.image " +
				"from player p " +
				"left outer join team t on t.team_id = p.previousTeamId " +
				"where p.player_id = ?;";
		return jdbcTemplate.query(sql, new PlayerMapper(), playerId).stream()
				.findFirst().orElse(null);
	}

	@Override
	public Player add(Player player)
	{
		final String sql = "insert into player " +
				"(firstName, " +
				"lastName, " +
				"nicknames, " +
				"jerseyNumber, " +
				"heightInInches, " +
				"weightInPounds, " +
				"image) " +
				"values (?, ?, ?, ?, ?, ?, ?);";
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		int rowsAffected = jdbcTemplate.update(con->
		{
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, player.getFirstName());
			ps.setString(2, player.getLastName());
			ps.setString(3, player.getAlias());
			ps.setInt(4, player.getJerseyNumber());
			ps.setInt(5, player.getHeight());
			ps.setInt(6, player.getWeight());
			ps.setString(7, player.getImage());
			return ps;
		}, keyHolder);

		if (rowsAffected <= 0)
		{
			return null;
		}

		player.setPlayerId(keyHolder.getKey().intValue());

		return player;
	}

	@Override
	public boolean update(Player player)
	{
		final String sql = "update player set " +
				"firstName = ?, " +
				"lastName = ?, " +
				"jerseyNumber = ?, " +
				"nicknames = ?, " +
				"heightInInches = ?, " +
				"weightInPounds = ?, " +
				"image = ? " +
				"where player_id = ?;";
		return jdbcTemplate.update(sql,
				player.getFirstName(),
				player.getLastName(),
				player.getJerseyNumber(),
				player.getAlias(),
				player.getHeight(),
				player.getWeight(),
				player.getImage(),
				player.getPlayerId()) > 0;
	}

	@Override
	@Transactional
	public boolean deleteById(int playerId)
	{
		final String sql = "delete from player where player_id = ?;";
		return jdbcTemplate.update(sql, playerId) > 0;
	}
}
