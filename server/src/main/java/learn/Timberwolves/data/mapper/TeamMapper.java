package learn.Timberwolves.data.mapper;

import learn.Timberwolves.model.Team;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamMapper implements RowMapper<Team>
{
	@Override
	public Team mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Team team = new Team();
		team.setTeamId(rs.getInt("team_id"));
		team.setLocation(rs.getString("location"));
		team.setNickName(rs.getString("nickName"));
		team.setShortName(rs.getString("shortName"));
		team.setLogoUrl(rs.getString("logoUrl"));
		return team;
	}
}
