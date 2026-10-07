import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FizzBuzzTest {

  @Test
  public void test() {
    assertEquals("Fizz", App.FizzBuzz(3));
    assertEquals("Buzz", App.FizzBuzz(10));
    assertEquals("FizzBuzz", App.FizzBuzz(15));
    assertEquals("4", App.FizzBuzz(4));
  }

  @Test
  public void player1IsUp() {
    App app = new App();
    assertEquals(1, app.playerWhosUp());
  }

  @Test 
  public void afterPlayer1Played_Player2IsUp() {
    App app = new App();
    assertEquals("1", app.takeTurn("1"));
    assertEquals(2, app.playerWhosUp());
  }

  @Test
  public void afterPlayer1And2Played_Player1IsUpAgain() {
    App app = new App();
    assertEquals("1", app.takeTurn("1"));
    assertEquals("2", app.takeTurn("1"));
    assertEquals(1, app.playerWhosUp());
  }

  @Test
  public void afterPlayer1Played_TurnsIs2() {
    App app = new App();
    assertEquals("1", app.takeTurn("1"));
    assertEquals(2, app.turn());
  }

  @Test
  public void after3TimesTakingTurn_TurnsIs4() {
    App app = new App();
    assertEquals("1", app.takeTurn("1"));
    assertEquals("2", app.takeTurn("1"));
    assertEquals("Fizz", app.takeTurn("1"));
    assertEquals(4, app.turn());
  }

  @Test
  public void afterPlayer1GuessedCorrectly_ScoreIsOne() {
    App app = new App();
    app.takeTurn("1");
    assertEquals(1, app.ScorePlayer(1));
  }

  @Test
  public void afterPlayersGuess_ScoreIsCorrect() {
    App app = new App();
    app.takeTurn("1");
    assertEquals(1, app.ScorePlayer(1));
    assertEquals(0, app.ScorePlayer(2));
    app.takeTurn("2");
    assertEquals(1, app.ScorePlayer(1));
    assertEquals(1, app.ScorePlayer(2));
    app.takeTurn("3");
    assertEquals(1, app.ScorePlayer(1));
    assertEquals(1, app.ScorePlayer(2));
    app.takeTurn("4");
    assertEquals(1, app.ScorePlayer(1));
    assertEquals(2, app.ScorePlayer(2));
    app.takeTurn("Buzz");
    assertEquals(2, app.ScorePlayer(1));
    assertEquals(2, app.ScorePlayer(2));
  }
}
