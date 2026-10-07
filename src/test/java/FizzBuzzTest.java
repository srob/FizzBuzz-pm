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
    assertEquals(1, app.playersTurn());
  }

  @Test 
  public void afterPlayer1Played_Player2IsUp() {
    App app = new App();
    app.takeTurn();
    assertEquals(2, app.playersTurn());
  }

  @Test 
  public void afterPlayer1And2Played_Player1IsUpAgain() {
    App app = new App();
    app.takeTurn();
    app.takeTurn();
    assertEquals(1, app.playersTurn());
  }

  @Test 
  public void afterPlayer1Played_TurnsIs2() {
    App app = new App();
    app.takeTurn();
    assertEquals(2, app.turn());
  }
  @Test 
  public void after3TimesTakingTurn_TurnsIs4() {
    App app = new App();
    app.takeTurn();
    app.takeTurn();
    app.takeTurn();
    assertEquals(4, app.turn());
  }
}
