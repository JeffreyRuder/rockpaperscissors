import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {
  @Test
  public void checkWinner_recognizesPaperBeatsRock_1() {
    App app = new App();
    Integer winner = 1;
    assertEquals(winner, app.checkWinner("paper", "rock"));
  }
  @Test
  public void checkWinner_recognizesScissorsBeatsPaper_2() {
    App app = new App();
    Integer winner = 2;
    assertEquals(winner, app.checkWinner("paper", "scissors"));
  }
  @Test
  public void checkWinner_recognizesRockBeatsScissors_1() {
    App app = new App();
    Integer winner = 1;
    assertEquals(winner, app.checkWinner("rock", "scissors"));
  }
  @Test
  public void checkWinner_recognizesSameChoiceEqualsTie_3() {
    App app = new App();
    Integer winner = 3;
    assertEquals(winner, app.checkWinner("rock", "rock"));
  }
  @Test
  public void checkWinner_recognizesRockBeatsScissors_2() {
    App app = new App();
    Integer winner = 2;
    assertEquals(winner, app.checkWinner("scissors", "rock"));
  }
}
