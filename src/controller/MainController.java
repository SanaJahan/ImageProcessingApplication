package controller;

import java.util.Arrays;

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
