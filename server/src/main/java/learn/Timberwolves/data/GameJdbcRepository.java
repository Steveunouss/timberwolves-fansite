package learn.Timberwolves.data;

import learn.Timberwolves.data.mapper.GameMapper;
import learn.Timberwolves.model.Game;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.nimbus.State;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class GameJdbcRepository implements GameRepository {

    private final JdbcTemplate jdbcTemplate;

    public GameJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Game> findAll() {
        final String sql = "select * from game;";

        return jdbcTemplate.query(sql, new GameMapper());
    }

    @Override
    @Transactional
    public Game findById(int gameId) {

        final String sql = "select game_id, `date`, opponentId, wolvesScore, opponentScore " +
                "from game " +
                "where game_id = ?;";
        return jdbcTemplate.query(sql, new GameMapper(), gameId)
                .stream().findFirst().orElse(null);
    }

    @Override
    public Game add(Game game) {
        final String sql = "insert into game " +
                "(`date`, " +
                "opponentId, " +
                "wolvesScore, " +
                "opponentScore) " +
                "values (?, ?, ?, ?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, game.getDate().toString());
            ps.setInt(2, game.getOpponentId());
            ps.setInt(3, game.getWolvesScore());
            ps.setInt(4, game.getOpponentScore());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0){
            return null;
        }

        game.setGameId(keyHolder.getKey().intValue());

        return game;
    }

    @Override
    public boolean update(Game game) {

        final String sql = "update game set "
                + "`date` = ?, "
                + "opponentId = ?, "
                + "wolvesScore = ?, "
                + "opponentScore = ? "
                + "where game_id = ?;";

        return jdbcTemplate.update(sql,
                game.getDate(),
                game.getOpponentId(),
                game.getWolvesScore(),
                game.getWolvesScore(),
                game.getGameId()) > 0;
    }

    @Override
    @Transactional
    public boolean deleteById(int gameId) {

        final String sql = "delete from game where game_id = ?;";
        return jdbcTemplate.update(sql, gameId) > 0;
    }
}
