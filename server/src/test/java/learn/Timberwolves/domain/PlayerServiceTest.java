package learn.Timberwolves.domain;

import learn.Timberwolves.data.PlayerRepository;
import learn.Timberwolves.data.TeamRepository;
import learn.Timberwolves.model.Player;
import learn.Timberwolves.model.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PlayerServiceTest
{

	@Autowired
	PlayerService service;

	@MockBean
	PlayerRepository repository;

	@MockBean
	TeamRepository teamRepository;



	@Test
	void shouldAddValid()
	{
		Player player = getPlayer();
		Player mockOut = player;
		mockOut.setPlayerId(17);
		when(repository.findById(player.getPlayerId())).thenReturn(null);
		when(repository.add(player)).thenReturn(mockOut);
		when(teamRepository.findByName(player.getFirstTeamName())).thenReturn(new Team());
		Result<Player> result = service.add(player);

		assertEquals(ActionStatus.SUCCESS, result.getStatus());
		assertEquals(mockOut, result.getPayload());
	}

	@Test
	void shouldNotAddNull()
	{
		assertEquals(ActionStatus.INVALID, service.add(null).getStatus());
	}

	@Test
	void shouldNotAddMissingElement()
	{
		Player player = getPlayer();
		player.setFirstName(null);
		assertEquals(ActionStatus.INVALID, service.add(player).getStatus());

		player = getPlayer();
		player.setJerseyNumber(-1);
		assertEquals(ActionStatus.INVALID, service.add(player).getStatus());

		player = getPlayer();
		player.setWeight(-1);
		assertEquals(ActionStatus.INVALID, service.add(player).getStatus());

		player = getPlayer();
		player.setHeight(-1);
		assertEquals(ActionStatus.INVALID, service.add(player).getStatus());
	}

	@Test
	void shouldNotAddDuplicate()
	{
		Player player = getPlayer();
		when(repository.findById(player.getPlayerId())).thenReturn(player);

		assertEquals(ActionStatus.DUPLICATE, service.add(player).getStatus());
	}

	@Test
	void shouldUpdateExisting()
	{
		Player player = getPlayer();
		player.setPlayerId(3);

		when(repository.update(player)).thenReturn(true);
		when(teamRepository.findByName(player.getFirstTeamName())).thenReturn(new Team());
		Result result = service.update(player);
		assertEquals(ActionStatus.SUCCESS, result.getStatus());
	}

	@Test
	void shouldNotUpdateMissing()
	{
		Player player = getPlayer();
		player.setPlayerId(1000);
		when(repository.update(player)).thenReturn(false);
		when(teamRepository.findByName(player.getFirstTeamName())).thenReturn(new Team());
		Result result = service.update(player);
		assertEquals(ActionStatus.NOT_FOUND, result.getStatus());
	}

	@Test
	void shouldNotUpdateInvalid()
	{
		Player player = getPlayer();
		player.setFirstName(null);
		assertEquals(ActionStatus.INVALID, service.update(player).getStatus());

		player = getPlayer();
		player.setJerseyNumber(-1);
		assertEquals(ActionStatus.INVALID, service.update(player).getStatus());

		player = getPlayer();
		player.setWeight(-1);
		assertEquals(ActionStatus.INVALID, service.update(player).getStatus());

		player = getPlayer();
		player.setHeight(-1);
		assertEquals(ActionStatus.INVALID, service.update(player).getStatus());
	}

	@Test
	void shouldNotUpdateDuplicate()
	{
		Player player = getPlayer();
		player.setJerseyNumber(20);
		when(repository.findById(player.getPlayerId())).thenReturn(player);
		Result result = service.update(player);
		assertEquals(ActionStatus.DUPLICATE, result.getStatus());
	}

	@Test
	void shouldDeleteById()
	{
		when(repository.deleteById(15)).thenReturn(true);
		assertEquals(ActionStatus.SUCCESS, ActionStatus.SUCCESS);
	}

	@Test
	void shouldNotDeleteByMissingId()
	{
		when(repository.deleteById(99)).thenReturn(false);
		assertEquals(ActionStatus.NOT_FOUND, service.deleteById(99).getStatus());
	}

	private Player getPlayer()
	{
		return new Player(
				0,
				"Johnny",
				"Steinbeck",
				49,
				"Shorts",
				48,
				100,
				"LAL",
				"vhjjhmfgvjhmgjmgv");
	}
}