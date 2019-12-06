import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import controller.ScriptController;

/**
 * Tests for the generation, transformation and filtering operations that can be performed on the,
 * image if the type of user interaction is through a script, like a text file.
 */
public class ScriptControllerTest {


  // test for load fail and pass
  @Test(expected = IllegalArgumentException.class)
  public void loadFailed() throws IOException {
    ScriptController.processTerms(new String[]{"load","image-not-there"});
  }

  // test for generate flag
  @Test
  public void testGenerateFlag() throws IOException {
    ScriptController.processTerms(new String[]{"generate","flag","greece","200","300"});
    ScriptController.processTerms(new String[]{"save", "greece-flag.png"});
  }

  // test for vibgyor
  @Test
  public void testVibgyor() throws IOException {
    ScriptController.processTerms(new String[]{"generate","vibgyor","horizontal","500","400"});
    ScriptController.processTerms(new String[]{"save", "horizontal.png"});

  }

  // test for blur
  @Test
  public void testBlur() throws IOException {
    ScriptController.processTerms(new String[]{"load","cat.png"});
    ScriptController.processTerms(new String[]{"blur"});
    ScriptController.processTerms(new String[]{"save", "catblur.png"});
  }

}
