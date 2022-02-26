package learn.Timberwolves.data.mapper;

import learn.Timberwolves.model.Game;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameMapper implements RowMapper<Game> {

    @Override
    public Game mapRow(ResultSet resultSet, int i) throws SQLException {
        Game game = new Game();
        game.setGameId(resultSet.getInt("game_id"));
        game.setDate(resultSet.getDate("date").toLocalDate());
        game.setOpponentId(resultSet.getInt("opponentId"));
        game.setWolvesScore(resultSet.getInt("wolvesScore"));
        game.setOpponentScore(resultSet.getInt("opponentScore"));
        return game;
    }
}
