import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class FizzBuzzSteps {
    private App game;
    private ByteArrayOutputStream output;
    private PrintStream originalOut;
    private PrintStream capturedOut;

    @Given("a new two-player FizzBuzz game")
    public void aNewGame() {
        game = new App();
        output = new ByteArrayOutputStream();
        originalOut = System.out;
        capturedOut = new PrintStream(output, true, StandardCharsets.UTF_8);
        System.setOut(capturedOut);
    }

    @When("player {int} answers {string}")
    public void playerAnswers(int player, String answer) {
        assertEquals("The expected player should be taking this turn",
            player, game.playerWhosUp());
        game.takeTurn(answer);
    }

    @Then("player {int} should have {int} point(s)")
    public void playerHasPoints(int player, int points) {
        assertEquals(points, game.ScorePlayer(player));
    }

    @Then("player {int} should be next")
    public void playerIsNext(int player) {
        assertEquals(player, game.playerWhosUp());
    }

    @Then("the game should display:")
    public void gameDisplays(String expected) {
        // Doc strings use LF; println uses the operating system's line separator.
        String actual = output.toString(StandardCharsets.UTF_8)
            .replace(System.lineSeparator(), "\n");
        assertEquals(expected + "\n", actual);
    }

    @After
    public void restoreConsole() {
        if (originalOut != null) {
            System.setOut(originalOut);
            capturedOut.close();
        }
    }
}
