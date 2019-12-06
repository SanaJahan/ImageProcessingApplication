import org.junit.Test;

import java.io.IOException;

import controller.ScriptController;
import utility.ImageUtil;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

/**
 * Tests for the generation, transformation and filtering operations that can be performed on the,
 * image if the type of user interaction is through a script, like a text file.
 */
public class ScriptControllerTest {


  /**
   * test that throws IllegalArgumentException, if file is not present.
   * @throws IOException for file read.
   */
  @Test(expected = IllegalArgumentException.class)
  public void loadFailed() throws IOException {
    ScriptController.processTerms(new String[]{"load","image-not-there"});
  }

  /**
   * test to check generation of flags.
   * @throws IOException if image cannot be read.
   */
  @Test
  public void testGenerateFlag() throws IOException {
    ScriptController.processTerms(new String[]{"generate","flag","greece","200","300"});
    ScriptController.processTerms(new String[]{"save", "greece-flag.png"});
    ImageUtil imageUtil = new ImageUtil();
    assertNotNull(imageUtil.readImage("greece-flag.png"));
  }

  /**
   * test to check generation of vibgyor.
   * @throws IOException if image cannot be read.
   */
  @Test
  public void testVibgyor() throws IOException {
    ScriptController.processTerms(new String[]{"generate","vibgyor","horizontal","500","400"});
    ScriptController.processTerms(new String[]{"save", "horizontal.png"});
    ImageUtil imageUtil = new ImageUtil();
    assertNotNull(imageUtil.readImage("horizontal.png"));
  }

  /**
   * test to check if blur effect works on an image.
   * @throws IOException if image cannot be read.
   */
  @Test
  public void testBlur() throws IOException {
    ScriptController.processTerms(new String[]{"load","cat.png"});
    ScriptController.processTerms(new String[]{"blur"});
    ScriptController.processTerms(new String[]{"save", "catblur.png"});
    ImageUtil imageUtil = new ImageUtil();
    assertNotSame(imageUtil.readImage("cat.png"),imageUtil.readImage("catblur.png"));
  }

}
