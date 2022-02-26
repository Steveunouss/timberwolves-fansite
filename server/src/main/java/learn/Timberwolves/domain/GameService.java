package learn.Timberwolves.domain;

import learn.Timberwolves.data.GameRepository;
import learn.Timberwolves.data.TeamRepository;
import learn.Timberwolves.model.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    private final TeamRepository teamRepository;

    public GameService(GameRepository gameRepository, TeamRepository teamRepository) {
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game findById(int gameId){
        return gameRepository.findById(gameId);
    }

    public Result<Game> add(Game game) {

        Result<Game> result = new Result<>();
        result.setPayload(game);
        result = validate(result);
        if (!result.isSuccess()){
            return result;
        }

        Game added = gameRepository.add(game);
        if (game == null) {
            result.addMessage(ActionStatus.INVALID, "Insert Failed");
        }
        else{
            result.setPayload(added);
        }

        return result;
    }

    public Result<Game> update(Game game) {

        Result<Game> result = new Result<>();
        result.setPayload(game);
        result = validate(result);
        if (!result.isSuccess()) {
            return result;
        }

        if (!gameRepository.update(game)) {
            result.addMessage(ActionStatus.NOT_FOUND, "game id `" + game.getGameId() + "` not found.");
        }

        return result;

    }

    public Result deleteById(int gameId) {

        Result result = new Result();

        boolean deleted = gameRepository.deleteById(gameId);
        if (!deleted){
            result.addMessage(ActionStatus.NOT_FOUND, "Game Id `" + gameId + "` not found.");
        }
        return result;
    }

    private Result<Game> validate(Result<Game> result) {

        if(result.getPayload() == null) {
            result.addMessage(ActionStatus.INVALID, "Game must exist");
            return result;
        }

        if (result.getPayload().getOpponentId() <= 0) {
            result.addMessage(ActionStatus.INVALID, "Game must have an opponent");
        }

        if(result.getPayload().getDate() == null) {
            result.addMessage(ActionStatus.INVALID, "Game must have a date");
        }

        if(!result.isSuccess()) {
            return result;
        }

        return result;
    }

}
