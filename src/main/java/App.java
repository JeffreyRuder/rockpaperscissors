public class App {
  public static void main(String[] args) {}

  public static Integer checkWinner(String playerOneChoice, String playerTwoChoice) {

    Integer winner = 0;

    switch (playerOneChoice) {
      case "paper":
        if(playerTwoChoice == "rock") {
          winner = 1;
        } else if(playerTwoChoice == "scissors") {
          winner = 2;
        }
        break;
      case "rock":
        if(playerTwoChoice == "scissors") {
          winner = 1;
        }
        break;
      default: break;
    }

    return winner;

  }
}
