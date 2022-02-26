package learn.Timberwolves.data;

import learn.Timberwolves.model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TeamJdbcTemplateRepositoryTest
{

	@Autowired
	TeamJdbcTemplateRepository repository;

	@Autowired
	KnownGoodState knownGoodState;

	@BeforeEach
	void setup()
	{
		knownGoodState.set();
	}

	@Test
	void shouldFindExisting()
	{
		Team team = repository.findById(29);
		assertNotNull(team);

		assertEquals("UTH", team.getShortName());
	}

	@Test
	void shouldFindExistingName()
	{
		Team team = repository.findByName("UTH");
		assertNotNull(team);

		assertEquals("Utah", team.getLocation());
	}
}
