import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FootballGame implements UnnamedPropertyChangeSubject
{
  private PropertyChangeSupport property;
  private String homeTeam;
  private String awayTeam;
  private int homeTeamGoal;
  private int awayTeamGoal;

  public FootballGame(String homeTeam, String awayTeam)
  {
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.homeTeamGoal = 0;
    this.awayTeamGoal = 0;
    this.property = new PropertyChangeSupport(this);
  }

  public String getHomeTeam()
  {
    return homeTeam;
  }

  public String getAwayTeam()
  {
    return awayTeam;
  }

  public void scoreGoal(String team)
  {
    if (team.equals(homeTeam))
    {
      homeTeamGoal++;
    }
    else if (team.equals(awayTeam))
    {
      awayTeamGoal++;
    }
    String score = getScore();
    property.firePropertyChange("Goal scored", team, score);
  }

  public String getScore()
  {
    return homeTeamGoal + " - " + awayTeamGoal;
  }

  public String endGame()
  {
    return getScore();
  }

  public void addListener(PropertyChangeListener listener)
  {
    property.addPropertyChangeListener(listener);
  }

  public void removeListener(PropertyChangeListener listener)
  {
    property.removePropertyChangeListener(listener);
  }


}
