public class App {
    private int player = 1;
    private int turns = 1;

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
        if (result == "") {
            result += number;
        }
        return result;
    }

    public int playersTurn() {
      return player;
    }

    public void takeTurn() {
        System.out.println("Turn " + turns + " by Player " + player + " : " + FizzBuzz(turns++));
        player = player == 1 ? 2 : 1;
    }

    public int turn() {
      return turns;
    }
}
