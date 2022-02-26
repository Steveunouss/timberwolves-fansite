package learn.Timberwolves.data;

import learn.Timberwolves.model.Team;

public interface TeamRepository
{
	Team findById(int teamId);

	Team findByName(String teamShortName);
}
