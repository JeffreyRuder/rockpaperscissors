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
        } else {
          winner = 3;
        }
        break;
      case "rock":
        if(playerTwoChoice == "scissors") {
          winner = 1;
        } else if (playerTwoChoice == playerOneChoice){
          winner = 3;
        } else {
          winner = 2;
        }
        break;
      case "scissors":
        if(playerTwoChoice == "paper") {
          winner = 1;
        } else if (playerTwoChoice == playerOneChoice){
          winner = 3;
        } else {
          winner = 2;
        }
        break;
      default: break;
    }

    return winner;

  }
}
