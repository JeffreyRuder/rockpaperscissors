import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {
  @Test
  public void checkWinner_recognizesPaperBeatsRock_1() {
    App app = new App();
    Integer winner = 1;
    assertEquals(winner, app.checkWinner("paper", "rock"));
  }
}
