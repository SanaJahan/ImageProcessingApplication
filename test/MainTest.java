import org.junit.Test;

/**
 * Tests for making sure the right controller is called on execution of the application.
 */
public class MainTest {

  /**
   * test that throws the IllegalArgumentException,
   * when wrong options are passed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void mainTest() {
    Main.main(new String[]{"-new_controller"});
  }


}
