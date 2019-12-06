import org.junit.Test;

public class MainTest {

  @Test (expected = IllegalArgumentException.class)
  public void mainTest(){
    Main.main(new String[]{"-new_controller"});
  }



}
