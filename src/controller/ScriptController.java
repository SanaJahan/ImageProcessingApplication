package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import model.BlurImage;
import model.DitherImage;
import model.FranceFlag;
import model.GenerateCheckerBoard;
import model.GenerateVibgyorStripes;
import model.GreeceFlag;
import model.GreyScale;
import model.IImage;
import model.MosaicImage;
import model.SepiaTone;
import model.SharpenImage;
import utility.ImageUtil;

/**
 * Controller that handles the script provided by the user, and performs the respective operations,
 * requested by them.
 */
public class ScriptController {

  private static int[][][] img = null;
  private static int height = -1;
  private static int width = -1;

  /**
   * This is the main driver method to read the script files if it is chosen as the type, of user
   * interaction with the application.
   * @param args The script file.
   */
  public static void main(String[] args) {
    File filename = new File(args[0]);
    try {
      Scanner sc = new Scanner(filename);
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] terms = line.split(" ");
        processTerms(terms);
      }
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
      System.out.println("File not found.");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  /**
   * Performs the operations requested by the user based on the lines given in the script.
   * @param terms All possible request terms made by the user.
   * @throws IOException Thrown at IOException.
   */
  public static void processTerms(String[] terms) throws IOException {
    ImageUtil imageUtil = new ImageUtil();
    switch (terms[0]) {
      case "load": {
        System.out.println("Loading the image");
        img = imageUtil.readImage(terms[1]);
        height = imageUtil.getHeight();
        width = imageUtil.getWidth();
        break;
      }
      case "generate": {
        switch (terms[1]) {
          case "flag": {
            if (terms.length < 5) {
              throw new IllegalArgumentException("Add more arguments");
            }
            height = Integer.parseInt(terms[3]);
            width = Integer.parseInt(terms[4]);
            if (terms[2].equals("france")) {
              System.out.println("Creating the flag of France.");
              IImage france = new FranceFlag(width, height);
              img = france.storeRGB();
            } else if (terms[2].equals("greece")) {
              System.out.println("Creating the flag of Greece.");
              IImage greece = new GreeceFlag(height, width);
              img = greece.storeRGB();
            }
            break;
          }
          case "vibgyor": {
            if (terms.length < 5) {
              throw new IllegalArgumentException("Add more arguments");
            }
            height = Integer.parseInt(terms[3]);
            width = Integer.parseInt(terms[4]);
            if ((terms[2]).equals("horizontal")) {
              System.out.println("Creating a horizontal VIBGYOR.");
              GenerateVibgyorStripes vibgyorHorizontalStripes =
                      new GenerateVibgyorStripes(terms[2],height, width);
              img = vibgyorHorizontalStripes.storeRGB();
            } else if ((terms[2]).equals("vertical")) {
              System.out.println("Creating a vertical VIBGYOR.");
              GenerateVibgyorStripes vibgyorVerticalStripes =
                      new GenerateVibgyorStripes(terms[2], height, width);
              img = vibgyorVerticalStripes.storeRGB();
            }
            break;
          }
          case "checkerboard": {
            System.out.println("Creating a checkerboard image for you.");
            int squareSize = Integer.parseInt(terms[2]);
            if (terms.length < 3) {
              throw new IllegalArgumentException("Add more arguments");
            }
            IImage checkerboard = new GenerateCheckerBoard(squareSize);
            img = checkerboard.storeRGB();
            break;
          }
          default:
            System.out.println("Generate operation does not work for the given inputs.");
        }
        break;
      }
      case "blur": {
        System.out.println("Applying blur to the image");
        IImage blur = new BlurImage(img, height, width);
        img = blur.storeRGB();
        break;
      }
      case "sharpen": {
        IImage sharpen = new SharpenImage(img, height, width);
        img = sharpen.storeRGB();
        break;
      }
      case "greyscale": {
        IImage greyScale = new GreyScale(img, height, width);
        img = greyScale.storeRGB();
        break;
      }
      case "sepia": {
        System.out.println("Applying sepia for the image");
        IImage sepiaTone = new SepiaTone(img, height, width);
        img = sepiaTone.storeRGB();
        break;
      }
      case "mosaic": {
        System.out.println("Applying mosaic for the image");
        int seeds = Integer.parseInt(terms[1]);
        IImage mosaicImage = new MosaicImage(img, height, width, seeds);
        img = mosaicImage.storeRGB();
        break;
      }
      case "dither": {
        System.out.println("Dithering the image");
        IImage dither = new DitherImage(img, height, width);
        img = dither.storeRGB();
        break;
      }
      case "save": {
        System.out.println("Saving your image");
        imageUtil.writeImage("res/" + terms[1], img, width, height);
        break;
      }
      default:
        System.out.println("Operation not supported");
    }

  }
}

