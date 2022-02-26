package learn.Timberwolves.domain;

import learn.Timberwolves.data.GameRepository;
import learn.Timberwolves.data.TeamRepository;
import learn.Timberwolves.model.Game;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class GameServiceTest {

    @Autowired
    GameService service;

    @MockBean
    GameRepository gameRepository;

    @MockBean
    TeamRepository teamRepository;

    @Test
    void shouldAddValid() {

        Game game = getGame();
        Game mockOut = game;
        mockOut.setGameId(83);
        when(gameRepository.findById(game.getGameId())).thenReturn(null);
        when(gameRepository.add(game)).thenReturn(mockOut);
        Result<Game> result = service.add(game);

        assertEquals(ActionStatus.SUCCESS, result.getStatus());
        assertEquals(mockOut, result.getPayload());
    }

    @Test
    void shouldNotAddNull() {
        assertEquals(ActionStatus.INVALID, service.add(null).getStatus());
    }

    @Test
    void shouldNotAddMissingElement() {
        Game game = getGame();
        game.setDate(null);
        assertEquals(ActionStatus.INVALID, service.add(game).getStatus());

        game = getGame();
        game.setOpponentId(-1);
        assertEquals(ActionStatus.INVALID,service.add(game).getStatus());
    }

    @Test
    void shouldUpdateExisting() {

        Game game = getGame();
        game.setOpponentScore(122);

        when(gameRepository.update(game)).thenReturn(true);
        Result result = service.update(game);
        assertEquals(ActionStatus.SUCCESS, result.getStatus());
    }

    @Test
    void shouldDeleteId() {

        when(gameRepository.deleteById(80)).thenReturn(true);
        assertEquals(ActionStatus.SUCCESS, ActionStatus.SUCCESS);
    }

    @Test
    void shouldNotDeleteByMissingId() {

        when(gameRepository.deleteById(99)).thenReturn(false);
        assertEquals(ActionStatus.NOT_FOUND, service.deleteById(99).getStatus());
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