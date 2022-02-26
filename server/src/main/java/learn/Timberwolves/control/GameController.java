package learn.Timberwolves.control;

import learn.Timberwolves.domain.GameService;
import learn.Timberwolves.domain.Result;
import learn.Timberwolves.model.Game;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/games")
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping
    public List<Game> findAll() {

        return  service.findAll();
    }

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody Game game) {

        Result<Game> result = service.add(game);
        if (result.isSuccess()) {

            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }

    @PutMapping("/{gameId}")
    public ResponseEntity<?> update(@PathVariable int gameId, @RequestBody Game game) {

        if (game.getGameId() != gameId) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        Result result = service.update(game);
        if (result.isSuccess()){
            return new ResponseEntity<>(getStatus(result, HttpStatus.NO_CONTENT));
        }

        return ErrorResponse.build(result);
    }

    @DeleteMapping("/{gameId}")
    public ResponseEntity<Void> delete(@PathVariable int gameId) {

        Result result = service.deleteById(gameId);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getStatus(result, HttpStatus.NOT_FOUND));
    }

    private HttpStatus getStatus(Result result, HttpStatus status) {
        switch (result.getStatus())
        {
            case INVALID -> {return HttpStatus.PRECONDITION_FAILED;}
            case DUPLICATE -> {return HttpStatus.FORBIDDEN;}
            case NOT_FOUND -> {return HttpStatus.NOT_FOUND;}
        }

        return status;
    }



}

















