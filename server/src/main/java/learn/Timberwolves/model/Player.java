package learn.Timberwolves.model;
import java.util.Objects;


public class Player
{

	private int jerseyNumber;
	private String firstName;
	private String lastName;
	private int playerId;
	private String alias;
	private int height;
	private int weight;
	private String firstTeamName;



	private String image;

	public Player(int playerId, String firstName, String lastName, int jerseyNumber, String alias, int height, int weight, String firstTeamName, String image)
	{
		this.jerseyNumber = jerseyNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.playerId = playerId;
		this.alias = alias;
		this.height = height;
		this.weight = weight;
		this.firstTeamName = firstTeamName;
		this.image = image;
	}

	public Player()
	{

	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public int getJerseyNumber()
	{
		return jerseyNumber;
	}

	public void setJerseyNumber(int jerseyNumber)
	{
		this.jerseyNumber = jerseyNumber;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public int getPlayerId()
	{
		return playerId;
	}

	public void setPlayerId(int playerId)
	{
		this.playerId = playerId;
	}

	public String getAlias()
	{
		return alias;
	}

	public void setAlias(String alias)
	{
		this.alias = alias;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getWeight()
	{
		return weight;
	}

	public void setWeight(int weight)
	{
		this.weight = weight;
	}

	public String getFirstTeamName()
	{
		return firstTeamName;
	}

	public void setFirstTeamName(String firstTeamName)
	{
		this.firstTeamName = firstTeamName;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Player player = (Player) o;
		return jerseyNumber == player.jerseyNumber && Objects.equals(firstName, player.firstName) && Objects.equals(lastName, player.lastName);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(jerseyNumber, firstName, lastName);
	}
}
