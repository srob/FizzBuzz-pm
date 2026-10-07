import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import io.cucumber.java.After;
import io.cucumber.datatable.DataTable;
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
        captureConsole();
    }

    private void captureConsole() {
        output = new ByteArrayOutputStream();
        originalOut = System.out;
        capturedOut = new PrintStream(output, true, StandardCharsets.UTF_8);
        System.setOut(capturedOut);
    }

    @Given("a two-player FizzBuzz game with {int} turns per player")
    public void aGameWithTurnsPerPlayer(int turnsPerPlayer) {
        game = new App(turnsPerPlayer);
        captureConsole();
    }

    @When("player {int} answers {string}")
    public void playerAnswers(int player, String answer) {
        assertEquals("The expected player should be taking this turn",
            player, game.playerWhosUp());
        game.takeTurn(answer);
    }

    @When("the players answer in this order:")
    public void playersAnswerInOrder(DataTable answers) {
        for (java.util.Map<String, String> row : answers.asMaps()) {
            playerAnswers(Integer.parseInt(row.get("player")), row.get("answer"));
        }
    }

    @Then("the final scoreboard should not be displayed yet")
    public void finalScoreboardIsNotDisplayedYet() {
        org.junit.Assert.assertFalse("The scoreboard appeared before the final turn",
            output.toString(StandardCharsets.UTF_8).contains("Final scoreboard"));
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

    @Then("the game should display the final scoreboard:")
    public void gameDisplaysFinalScoreboard(String expected) {
        String actual = output.toString(StandardCharsets.UTF_8)
            .replace(System.lineSeparator(), "\n");
        int scoreboardStart = actual.indexOf("Final scoreboard\n");
        org.junit.Assert.assertTrue("Expected a final scoreboard, but output was:\n"
            + actual, scoreboardStart >= 0);
        assertEquals(expected + "\n", actual.substring(scoreboardStart));
    }

    @After
    public void restoreConsole() {
        if (originalOut != null) {
            System.setOut(originalOut);
            capturedOut.close();
        }
    }
}
