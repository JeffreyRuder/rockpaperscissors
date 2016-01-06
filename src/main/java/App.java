import java.util.Map;
import java.util.HashMap;
import java.util.Random;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

//Rock is 9
//Scissors is 10
//Paper is 11

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/player2page", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/player2page.vtl");

      String player1choice = request.queryParams("choice");

      model.put("player1choice", player1choice);
      model.put("player1choice2", player1choice);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/results.vtl");

      Integer player1choice = Integer.parseInt(request.queryParams("choice1"));
      Integer player2choice = Integer.parseInt(request.queryParams("choice2"));

      Integer winnerNumber = checkWinner(player1choice, player2choice);

      String playerOneChoiceInWords;
      String playerTwoChoiceInWords;
      String winnerName;

      HashMap<Integer, String> choiceKey = new HashMap<Integer, String>();
      choiceKey.put(9, "Rock");
      choiceKey.put(10, "Scissors");
      choiceKey.put(11, "Paper");

      playerOneChoiceInWords = choiceKey.get(player1choice);
      playerTwoChoiceInWords = choiceKey.get(player2choice);

      model.put("player1choice", playerOneChoiceInWords);
      model.put("player2choice", playerTwoChoiceInWords);

      if (winnerNumber == 1) {
        winnerName = "Player 1 Wins!";
      } else if (winnerNumber == 2) {
        winnerName = "Player 2 Wins!";
      } else {
        winnerName = "There was a tie!";
      }

      model.put("winnerName", winnerName);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/computer-results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/computer-results.vtl");

      Integer player1choice = Integer.parseInt(request.queryParams("choice3"));
      Random computerPlayer = new Random();

      Integer player2choice = (computerPlayer.nextInt(3)) + 9;

      Integer winnerNumber = checkWinner(player1choice, player2choice);

      String playerOneChoiceInWords;
      String playerTwoChoiceInWords;
      String winnerName;

      HashMap<Integer, String> choiceKey = new HashMap<Integer, String>();
      choiceKey.put(9, "Rock");
      choiceKey.put(10, "Scissors");
      choiceKey.put(11, "Paper");

      playerOneChoiceInWords = choiceKey.get(player1choice);
      playerTwoChoiceInWords = choiceKey.get(player2choice);

      model.put("player1choice", playerOneChoiceInWords);
      model.put("player2choice", playerTwoChoiceInWords);

      if (winnerNumber == 1) {
        winnerName = "Player 1 Wins!";
      } else if (winnerNumber == 2) {
        winnerName = "Computer Wins!";
      } else {
        winnerName = "There was a tie!";
      }

      model.put("winnerName", winnerName);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



  }

  public static Integer checkWinner(Integer playerOneChoice, Integer playerTwoChoice) {



    System.out.println("Inside check winner 1 " + playerOneChoice);
    System.out.println("Inside check winner 2 " + playerTwoChoice);

    Integer winner = 0;

    switch (playerOneChoice) {
      case 11:
        if (playerTwoChoice == 9) {
          winner = 1;
        } else if (playerTwoChoice == 10) {
          winner = 2;
        } else {
          winner = 3;
        }
        break;
      case 9:
        if (playerTwoChoice == 10) {
          winner = 1;
        } else if (playerTwoChoice == 11) {
          winner = 2;
        } else {
          winner = 3;
        }
        break;
      case 10:
        if (playerTwoChoice == 11) {
          winner = 1;
        } else if (playerTwoChoice == 9) {
          winner = 2;
        } else {
          winner = 3;
        }
        break;
      default: break;
    }

    return winner;

  }
}
