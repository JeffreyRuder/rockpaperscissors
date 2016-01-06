import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {

  @Test
  public void checkWinner_recognizesPaperBeatsRock_1() {
    App app = new App();
    Integer winner = 1;
    assertEquals(winner, app.checkWinner(11, 9));
  }

  @Test
  public void checkWinner_recognizesScissorsBeatsPaper_2() {
    App app = new App();
    Integer winner = 2;
    assertEquals(winner, app.checkWinner(11, 10));
  }

  @Test
  public void checkWinner_recognizesScissorsBeatsPaper_1() {
    App app = new App();
    Integer winner = 1;
    assertEquals(winner, app.checkWinner(10, 11));
  }

  @Test
  public void checkWinner_recognizesRockBeatsScissors_1() {
    App app = new App();
    Integer winner = 1;
    assertEquals(winner, app.checkWinner(9, 10));
  }

  @Test
  public void checkWinner_recognizesSameChoiceEqualsTie_3() {
    App app = new App();
    Integer winner = 3;
    assertEquals(winner, app.checkWinner(9, 9));
  }

  @Test
  public void checkWinner_recognizesRockBeatsScissors_2() {
    App app = new App();
    Integer winner = 2;
    assertEquals(winner, app.checkWinner(10, 9));
  }
}
