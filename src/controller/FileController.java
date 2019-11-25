package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


import model.BlurImage;
import model.DitherImage;
import model.GreyScale;
import model.IImage;
import model.MosaicImage;
import model.SepiaTone;
import model.SharpenImage;
import utility.ScriptHelper;

public class FileController {

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
        img = scriptHelper.readImage(terms[1]);
        height = scriptHelper.getHeight();
        width = scriptHelper.getWidth();
        break;
      }
      case "generate": {
        switch (terms[1]) {

          case "flag": {
            switch (terms[2]) {
              case "france":{
              }
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
        IImage sepiaTone = new SepiaTone(img, height, width);
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

