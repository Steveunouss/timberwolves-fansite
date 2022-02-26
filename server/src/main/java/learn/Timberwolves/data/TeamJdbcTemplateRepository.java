package learn.Timberwolves.data;

import learn.Timberwolves.data.mapper.TeamMapper;
import learn.Timberwolves.model.Team;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TeamJdbcTemplateRepository implements TeamRepository
{
	private final JdbcTemplate jdbcTemplate;

	public TeamJdbcTemplateRepository(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Team findById(int teamId)
	{
		final String sql = "select shortName, nickName, team_id, logoUrl, location " +
				"from team " +
				"where team_id = ?;";
		return jdbcTemplate.query(sql, new TeamMapper(), teamId).stream()
				.findFirst().orElse(null);
	}

	@Override
	public Team findByName(String teamShortName)
	{
		final String sql = "select shortName, nickName, team_id, logoUrl, location " +
				"from team " +
				"where shortName = ?;";
		return jdbcTemplate.query(sql, new TeamMapper(), teamShortName).stream()
				.findFirst().orElse(null);
	}


}
