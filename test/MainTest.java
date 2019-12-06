import org.junit.Test;

/**
 * Tests for making sure the right controller is called on execution of the application.
 */
public class MainTest {

  @Test (expected = IllegalArgumentException.class)
  public void mainTest(){
    Main.main(new String[]{"-new_controller"});
  }



}
