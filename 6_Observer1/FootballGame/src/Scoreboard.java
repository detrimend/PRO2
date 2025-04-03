import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Scoreboard implements PropertyChangeListener
{
  private FootballGame game;

  public Scoreboard(FootballGame game)
  {
    game.addListener(this);
    this.game = game;
    showScore(game.getScore());
  }

  public void showScore(String score)
  {
    System.out.println("SCOREBOARD: " + score);
  }

  public void propertyChange(PropertyChangeEvent evt)
  {
    showScore(evt.getNewValue().toString());
  }
}
