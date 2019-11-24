package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import model.BlurImage;
import model.DitherImage;
import model.GreyScale;
import model.IBlur;
import model.IImage;
import model.ISharpen;
import model.MosaicImage;
import model.SepiaTone;
import model.SharpenImage;
import utility.ScriptHelper;

public class StartController {

  private static int[][][] img = null;
  private static int height = -1;
  private static int width = -1;


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
      System.out.println("File not found.");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void processTerms(String[] terms) throws IOException {
    ScriptHelper scriptHelper = new ScriptHelper();
    switch (terms[0]) {
      case "load": {
        BufferedImage input = ImageIO.read(new FileInputStream("res/" + terms[1]));
        img = scriptHelper.readImage(input);
        height = scriptHelper.getHeight();
        width = scriptHelper.getWidth();
        break;
      }
      case "generate": {
        switch (terms[1]) {

          case "flag": {
            switch (terms[2]) {
              case "france":{}
            }
          }

          // If y == 3
          case "vibgyor":
            {}
          case "checkerboard":{}
        }
        break;

      }
      case "blur": {
        IBlur blur = new BlurImage(img, height, width);
        img = blur.applyBlurringEffect();
        break;
      }
      case "sharpen": {
        ISharpen sharpen = new SharpenImage(img, height, width);
        img = sharpen.applySharpeningEffect();
        break;
      }
      case "greyscale": {
        GreyScale greyScale = new GreyScale(img, height, width);
        img = greyScale.storeRGB();
        break;
      }
      case "sepia": {
        SepiaTone sepiaTone = new SepiaTone(img, height, width);
        img = sepiaTone.storeRGB();
        break;
      }
      case "mosaic": {
        IImage mosaicImage = new MosaicImage(img, height, width,8000);
        img = mosaicImage.storeRGB();
        break;
      }
      case "dither": {
        IImage dither = new DitherImage(img,height,width);
        img = dither.storeRGB();
        break;
      }
      case "save": {
        scriptHelper.writeImage("res/" + terms[1], img, width, height);
        break;
      }
      default:
        System.out.println("Operation not supported");
    }

  }
}

