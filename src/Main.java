import java.util.Arrays;

import controller.GUIController;
import controller.ScriptController;

/**
 * Controller for supporting the type of user interaction with this application through the, command
 * line arguments. Currently, it only support any kind of file reading.
 */

public class Main {
  /**
   * This is the driver method to start the application. The type of user interaction is determined
   * by this main driver method.
   *
   * @param args The type of user interaction with the application, like a text file.
   */
  public static void main(String[] args) {
    if (args == null || args.length == 0) {
      System.out.println("Please pass arguments");
      System.exit(-1);
    }

    String[] arr = Arrays.copyOfRange(args, 1, args.length);

    if (args[0].equals("-script")) {
      ScriptController scriptController = new ScriptController();
      scriptController.main(arr);
    } else if (args[0].equals("-interactive")) {
      GUIController guiController = new GUIController();
      guiController.main(arr);
    } else {
      System.out.println("Operation not supported");
    }
  }
}
