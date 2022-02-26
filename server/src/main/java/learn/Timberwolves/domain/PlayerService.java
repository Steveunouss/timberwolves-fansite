package learn.Timberwolves.domain;

import learn.Timberwolves.data.PlayerRepository;
import learn.Timberwolves.data.TeamRepository;
import learn.Timberwolves.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService
{
	private final PlayerRepository repository;

	private final TeamRepository teamRepository;

	public PlayerService(PlayerRepository repository, TeamRepository teamRepository)
	{
		this.teamRepository = teamRepository;
		this.repository = repository;
	}

	public List<Player> findAll()
	{
		return repository.findAll();
	}

	public Player findById(int playerId)
	{
		return repository.findById(playerId);
	}

	public Result<Player> add(Player player)
	{
		Result<Player> result = new Result<>();
		result.setPayload(player);
		result = validate(result);
		if (!result.isSuccess())
		{
			return result;
		}

		result = validateAdd(result);
		if (!result.isSuccess())
		{
			return result;
		}

		Player added = repository.add(player);
		if (player == null)
		{
			result.addMessage(ActionStatus.INVALID, "insert failed");
		}
		else
		{
			result.setPayload(added);
		}

		return result;
	}

	public Result<Player> update(Player player)
	{
		Result<Player> result = new Result();
		result.setPayload(player);
		result = validate(result);
		if (!result.isSuccess())
		{
			return result;
		}

		result = validateUpdate(result);
		if (!result.isSuccess())
		{
			return result;
		}

		if (!repository.update(player))
		{
			result.addMessage(ActionStatus.NOT_FOUND, "player id `" + player.getPlayerId() + "` not found.");
		}


		return result;
	}

	public Result deleteById(int playerId)
	{
		Result result = new Result();

		boolean deleted = repository.deleteById(playerId);
		if( !deleted)
		{
			result.addMessage(ActionStatus.NOT_FOUND, "player id `" + playerId + "` not found.");
		}
		return result;
	}

	private Result<Player> validateUpdate(Result<Player> result)
	{
		List<Player> all = findAll();
		for (Player p : all)
		{
			if (p.getJerseyNumber() == result.getPayload().getJerseyNumber())
			{
				result.addMessage(ActionStatus.DUPLICATE, "jersey number must be unique");
			}
		}
		return result;
	}

	private Result<Player> validateAdd(Result<Player> result)
	{
		if (repository.findById(result.getPayload().getPlayerId()) != null)
		{
			result.addMessage(ActionStatus.DUPLICATE,"player must have a unique jersey number");
		}

		return result;
	}

	private Result<Player> validate(Result<Player> result)
	{
		if (result.getPayload() == null)
		{
			result.addMessage(ActionStatus.INVALID, "Player must exist.");
			return result;
		}

		if (result.getPayload().getFirstName() == null)
		{
			result.addMessage(ActionStatus.INVALID,"Player must have a first name.");
		}

		if (result.getPayload().getLastName() == null)
		{
			result.addMessage(ActionStatus.INVALID, "Player must have a last name.");
		}

		if (result.getPayload().getJerseyNumber() < 0)
		{
			result.addMessage(ActionStatus.INVALID, "Player must have a valid jersey number.");
		}

		if (result.getPayload().getHeight() <= 0)
		{
			result.addMessage(ActionStatus.INVALID, "Player must have a valid height.");
		}

		if (result.getPayload().getWeight() <= 0)
		{
			result.addMessage(ActionStatus.INVALID, "Player must have a valid weight.");
		}

		if (!result.isSuccess())
		{
			return result;
		}


		if(result.getPayload().getFirstTeamName() != null)
		{
			if (teamRepository.findByName(result.getPayload().getFirstTeamName()) == null)
			{
				result.addMessage(ActionStatus.DUPLICATE,"Must have a valid team short name.");
			}
		}
		//todo add repository check for the first team value

		return result;
	}

}
