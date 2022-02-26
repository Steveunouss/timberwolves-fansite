package learn.Timberwolves.control;


import learn.Timberwolves.domain.Result;
import learn.Timberwolves.domain.PlayerService;
import learn.Timberwolves.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;



@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/team")
public class PlayerController
{
	private final PlayerService service;

	public PlayerController(PlayerService service)
	{
		this.service = service;
	}


	@GetMapping
	public List<Player> findAll()
	{
		return service.findAll();
	}

	@GetMapping("/{playerId}")
	public ResponseEntity<Player> findById(@PathVariable int playerId)
	{
		Player player = service.findById(playerId);
		if (player == null)
		{
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(player);
	}

	@PostMapping
	public ResponseEntity<?> add(@RequestBody Player player)
	{
		Result<Player> result = service.add(player);
		if (result.isSuccess())
		{
			return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
		}
		return ErrorResponse.build(result);
	}

	@PutMapping("/{playerId}")
	public ResponseEntity<?> update(@PathVariable int playerId, @RequestBody Player player)
	{
		if ( player.getPlayerId() != playerId)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		Result result = service.update(player);
		if(result.isSuccess())
		{
			return new ResponseEntity<>(getStatus(result, HttpStatus.NO_CONTENT));
		}
		return ErrorResponse.build(result);
	}

	@DeleteMapping("/{playerId}")
	public ResponseEntity<Void> delete(@PathVariable int playerId)
	{
		Result result = service.deleteById(playerId);
		if (result.isSuccess())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(getStatus(result, HttpStatus.NOT_FOUND));
	}

	private HttpStatus getStatus(Result result, HttpStatus status)
	{
		switch (result.getStatus())
		{
			case INVALID -> {return HttpStatus.PRECONDITION_FAILED;}
			case DUPLICATE -> {return HttpStatus.FORBIDDEN;}
			case NOT_FOUND -> {return HttpStatus.NOT_FOUND;}
		}
		return status;
	}


}
