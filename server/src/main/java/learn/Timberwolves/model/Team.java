package learn.Timberwolves.model;

import java.util.Objects;

public class Team {

    private int teamId;
    private String location;
    private String nickName;
    private String shortName;
    private String logoUrl;




    public Team(){

    }

    public Team(int teamId, String location, String nickName, String shortName, String logoUrl) {
        this.teamId = teamId;
        this.shortName = shortName;
        this.location = location;
        this.nickName = nickName;
        this.logoUrl = logoUrl;
    }

    public String getShortName()
    {
        return shortName;
    }

    public void setShortName(String shortName)
    {
        this.shortName = shortName;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return teamId == team.teamId && location.equals(team.location) && nickName.equals(team.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, location, nickName);
    }
}
