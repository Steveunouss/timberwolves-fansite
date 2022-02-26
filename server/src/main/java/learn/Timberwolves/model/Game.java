package learn.Timberwolves.model;

import java.time.LocalDate;
import java.util.Objects;

public class Game {

    private int gameId;
    private LocalDate date;
    private int opponentId;
    private int wolvesScore;
    private int opponentScore;

    public Game(){

    }

    public Game(int gameId, LocalDate date, int opponentId, int wolvesScore, int opponentScore) {
        this.gameId = gameId;
        this.date = date;
        this.opponentId = opponentId;
        this.wolvesScore = wolvesScore;
        this.opponentScore = opponentScore;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(int opponentId) {
        this.opponentId = opponentId;
    }

    public int getWolvesScore() {
        return wolvesScore;
    }

    public void setWolvesScore(int wolvesScore) {
        this.wolvesScore = wolvesScore;
    }

    public int getOpponentScore() {
        return opponentScore;
    }

    public void setOpponentScore(int opponentScore) {
        this.opponentScore = opponentScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return gameId == game.gameId && opponentId == game.opponentId && date.equals(game.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, date, opponentId);
    }
}
