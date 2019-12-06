import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import controller.ScriptController;

public class ScriptControllerTest {

  private ScriptController scriptController;

  @Before
  public void setUp() {
    scriptController = new ScriptController();
  }

  // test for load fail and pass
  @Test(expected = IllegalArgumentException.class)
  public void loadFailed() throws IOException {
    scriptController.processTerms(new String[]{"load","image-not-there"});
  }

  // test for generate flag
  @Test
  public void testGenerateFlag() throws IOException {
    scriptController.processTerms(new String[]{"generate","flag","greece","200","300"});
    scriptController.processTerms(new String[]{"save", "greece-flag.png"});
  }

  // test for vibgyor
  @Test
  public void testVibgyor() throws IOException {
    scriptController.processTerms(new String[]{"generate","vibgyor","horizontal","500","400"});
    scriptController.processTerms(new String[]{"save", "horizontal.png"});

  }

  // test for blur
  @Test
  public void testBlur() throws IOException {
    scriptController.processTerms(new String[]{"load","cat.png"});
    scriptController.processTerms(new String[]{"blur"});
    scriptController.processTerms(new String[]{"save", "catblur.png"});
  }

}
