package controller;

import java.util.Arrays;

/**
 * Controller for supporting the type of user interaction with this application through the,
 * command line arguments.
 * Currently, it only support any kind of file reading.
 */
public class MainController {
  public static void main(String[] args) {
    if (args == null || args.length == 0) {
      System.out.println("Please pass arguments");
      System.exit(-1);
    }

    switch (args[0]) {
      case "script" : {
        String[] arr = Arrays.copyOfRange(args, 1, args.length);
        FileController.main(arr);
        break;
      }
      default:
        System.out.println("Operation not supported");
    }
  }
}
