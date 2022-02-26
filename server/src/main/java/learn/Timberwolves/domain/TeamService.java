package learn.Timberwolves.domain;

import learn.Timberwolves.data.TeamRepository;
import learn.Timberwolves.model.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team findById(int teamId) {
        return teamRepository.findById(teamId);
    }
}
