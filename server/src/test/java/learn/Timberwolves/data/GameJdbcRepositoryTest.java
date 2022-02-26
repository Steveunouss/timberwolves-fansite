package learn.Timberwolves.data;

import learn.Timberwolves.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GameJdbcRepositoryTest {

    @Autowired
    GameJdbcRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindAll(){
        List<Game> all = repository.findAll();
        assertNotNull(all);

        assertEquals(82, all.size());
    }

    @Test
    void shouldFindExisting() {
        Game game = repository.findById(22);
        assertNotNull(game);

        assertEquals(game.getOpponentId(), 30);
    }

    @Test
    void shouldNotFindBadIndex() {
        Game game = repository.findById(-1);
        assertNull(game);

        game = repository.findById(9999);
        assertNull(game);
    }

    @Test
    void shouldAddGame() {
        Game added = repository.add(getGame());
        assertNotNull(added);

        assertTrue(added.getGameId() > 0);
    }

    @Test
    void shouldNotAddInvalid() {
        Game game = getGame();
        assertNull(null);
    }

    @Test
    void shouldUpdateExisting() {
        Game game = repository.findAll().get(70);
        game.setOpponentScore(99);
        game.setWolvesScore(100);
        assertTrue(repository.update(game));
    }

    @Test
    void shouldNotUpdateMissing() {
        Game game = getGame();
        assertFalse(repository.update(game));
    }

    @Test
    void shouldDeleteExisting() {
        assertTrue(repository.deleteById(1));
    }

    @Test
    void shouldNotDeleteMissing() {
        assertFalse(repository.deleteById(44444));
    }

    private Game getGame() {

        LocalDate date = LocalDate.parse("2022-05-05");

        return new Game(0,
                date,
                10,
                0,
                0);
    }

}