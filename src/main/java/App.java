import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

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

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/results.vtl");

      String player1choice = request.queryParams("choice1");
      String player2choice = request.queryParams("choice2");

      System.out.println(player1choice);
      System.out.println(player2choice);

      model.put("player1choice", player1choice);
      model.put("player2choice", player2choice);

      Integer winnerNumber = checkWinner(player1choice, player2choice);
      String winnerName;

      if (winnerNumber == 1) {
        winnerName = "Player 1";
      } else if (winnerNumber == 2) {
        winnerName = "Player 2";
      } else {
        winnerName = "There was a tie!";
      }

      model.put ("winnerName", winnerName);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



  }

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
