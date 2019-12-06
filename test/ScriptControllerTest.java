import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import controller.ScriptController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ScriptControllerTest {

  private ScriptController scriptController;

  @Before
  public void setUp() {
    scriptController = new ScriptController();
  }

  // test when file is missing
  @Test
  public void testFileMissing(){
    scriptController.main(new String[]{"filenotexist"});
    
  }
  // test for load fail and pass
  // test for generate flag
  // test for vibgyor
  // test for checkerboard
  // test for blur
  //test for sharpen
  //test for sepia
  //test for greyscale
  // test for mosaic
  // test for dither
  //test for save

}
