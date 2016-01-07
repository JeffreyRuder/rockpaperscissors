import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

import org.junit.*;
import static org.junit.Assert.*;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
    public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Rock Paper Scissors");
    }
  @Test
    public void checkHiddenValue() {
      goTo("http://localhost:4567");
      click("#scissors");
      submit(".btn");
      String valueTest = find("#hiddenPlayerChoice").getValue();
      Integer valueTestAsInt = Integer.parseInt(valueTest);
      assertEquals((Integer)valueTestAsInt, (Integer)10);
    }
  @Test
    public void checkGameWinner() {
      goTo("http://localhost:4567");
      click("#scissors");
      submit(".btn");
      click("#paper");
      submit(".btn-default");
      assertThat(pageSource()).contains("Player 1 Wins!");
    }
  @Test
    public void checkComputerPlayer() {
      goTo("http://localhost:4567");
      click("#scissors");
      submit(".btn");
      submit(".btn-danger");
      assertThat(pageSource()).contains("Computer");
    }
}
