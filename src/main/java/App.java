public class App {
    private int player = 1;
    private int turns = 1;
    private int scoreplayer1 = 0;
    private int scoreplayer2 = 0;
    private final int turnsPerPlayer;

    public App() {
        // Existing examples have no configured turn limit.
        this(0);
    }

    public App(int turnsPerPlayer) {
        this.turnsPerPlayer = turnsPerPlayer;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(FizzBuzz(3));
        System.out.println(FizzBuzz(5));
        System.out.println(FizzBuzz(15));
        System.out.println(FizzBuzz(14));
    }

    public static String FizzBuzz(int number) {
        String result = "";
        if (number % 3 == 0) {
            result += "Fizz";
        }
        if (number % 5 == 0) {
            result += "Buzz";
        }
        if (result.equals("")) {
            result += number;
        }
        return result;
    }

    public int playerWhosUp() {
      return player;
    }

    public String takeTurn(String guess) {
        String result = FizzBuzz(turns);
        if (guess.equals(result)) {
            if (player == 1)
                scoreplayer1++;
            else
                scoreplayer2++;
        }
        System.out.println("Turn " + turns++ + " by Player " + player + ": " + result + " (ScorePlayer1: " + scoreplayer1 + ", ScorePlayer2: " + scoreplayer2 + ")");
        player = player == 1 ? 2 : 1;
        if (turnsPerPlayer > 0 && turns - 1 == 2L * turnsPerPlayer) {
            displayFinalScoreboard();
        }
        return result;
    }

    private void displayFinalScoreboard() {
        System.out.println("Final scoreboard");
        System.out.println("Player 1: " + scoreplayer1 + pointLabel(scoreplayer1)
            + (scoreplayer1 > scoreplayer2 ? " - Winner!" : ""));
        System.out.println("Player 2: " + scoreplayer2 + pointLabel(scoreplayer2)
            + (scoreplayer2 > scoreplayer1 ? " - Winner!" : ""));
        if (scoreplayer1 == scoreplayer2) {
            System.out.println("It's a tie!");
        }
    }

    private String pointLabel(int score) {
        return score == 1 ? " point" : " points";
    }

    public int turn() {
      return turns;
    }

    public int ScorePlayer(int player) {
        return player == 1 ? scoreplayer1 : scoreplayer2;
    }
}
