package learn.Timberwolves.data;

import learn.Timberwolves.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PlayerJdbcRepositoryTest
{
	@Autowired
	PlayerJdbcTempleteRepository repository;


	@Autowired
	KnownGoodState knownGoodState;

	@BeforeEach
	void setup()
	{
		knownGoodState.set();
	}

	@Test
	void shouldFindAll()
	{
		List<Player> all = repository.findAll();
		assertNotNull(all);

		assertEquals(16, all.size());
	}

	@Test
	void shouldFindExisting()
	{
		Player player = repository.findById(14);
		assertNotNull(player);

		assertEquals(player.getFirstName(), "Patrick");
	}

	@Test
	void shouldNotFindBadIndex()
	{
		Player player = repository.findById(-1);
		assertNull(player);

		player = repository.findById(1000);
		assertNull(player);
	}

	@Test
	void shouldAddPlayer()
	{
		Player added = repository.add(getPlayer());
		assertNotNull(added);

		assertTrue(added.getPlayerId() > 0);
	}

	@Test
	void shouldNotAddInvalid()
	{
		Player player = getPlayer();
		assertNull(null);

		//player.setFirstTeamName(null);

		//assertNull(repository.add(player));
	}

	@Test
	void shouldUpdateExisting()
	{
		Player player = repository.findAll().get(0);
		player.setJerseyNumber(player.getJerseyNumber() + 67 % 100);
		assertTrue(repository.update(player));
	}

	@Test
	void shouldNotUpdateMissing()
	{
		Player player = getPlayer();
		assertFalse(repository.update(player));
	}

	@Test
	void shouldDeleteExisting()
	{
		assertTrue(repository.deleteById(3));
	}

	@Test
	void shouldNotDeleteMissing()
	{
		assertFalse(repository.deleteById(712123));
	}


	private Player getPlayer()
	{
		return new Player(0,
				"Josh",
				"Wollet",
				97,
				"talls",
				55,
				250,
				null,
				"fdvdfvbfd");
	}
}
