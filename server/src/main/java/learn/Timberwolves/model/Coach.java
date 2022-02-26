package learn.Timberwolves.model;

import java.util.Objects;

public class Coach {

    private int coachId;
    private String firstName;
    private String lastName;
    private int previousTeamId;

    public Coach () {

    }

    public Coach(int coachId, String firstName, String lastName, int previousTeamId) {
        this.coachId = coachId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.previousTeamId = previousTeamId;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPreviousTeamId() {
        return previousTeamId;
    }

    public void setPreviousTeamId(int previousTeamId) {
        this.previousTeamId = previousTeamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return coachId == coach.coachId && firstName.equals(coach.firstName) && lastName.equals(coach.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coachId, firstName, lastName);
    }
}
