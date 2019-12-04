package controller;

import java.io.IOException;

import javax.swing.*;

import model.BlurImage;
import model.DitherImage;
import model.GenerateCheckerBoard;
import model.GenerateVibgyorStripes;
import model.GreyScale;
import model.IImage;
import model.MosaicImage;
import model.SepiaTone;
import model.SharpenImage;
import utility.ImageUtil;
import view.ImageViewImpl;

public class GUIController  {

  private static int[][][] img = null;
  private static int height = -1;
  private static int width = -1;
  private ImageUtil imageUtil = new ImageUtil();




  public static void main(String[] args) {
    ImageViewImpl.setDefaultLookAndFeelDecorated(false);
    ImageViewImpl imageViewFrame = new ImageViewImpl();

    imageViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    imageViewFrame.setVisible(true);
    try {
      // Set cross-platform Java L&F (also called "Metal")
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (UnsupportedLookAndFeelException e) {
      // handle exception
      System.out.println("Unsupported feature");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }


  }

  public void loadImage(String filename) throws IOException {
    img = imageUtil.readImage(filename);
    height = imageUtil.getHeight();
    width = imageUtil.getWidth();

  }

  public void saveImage(String filePath) {
    imageUtil.writeImage(filePath,img,width,height);
  }


  public int[][][] applyEffect(String effect) {
    switch (effect) {
      case "blur": {
        System.out.println("Applying blur to the image");
        IImage blur = new BlurImage(img, height, width);
        img = blur.storeRGB();
        return img;
      }
      case "sharpen": {
        IImage sharpen = new SharpenImage(img, height, width);
        img = sharpen.storeRGB();
        return img;
      }
      case "greyscale": {
        IImage greyScale = new GreyScale(img, height, width);
        img = greyScale.storeRGB();
        return img;
      }
      case "sepia": {
        System.out.println("Applying sepia for the image");
        IImage sepiaTone = new SepiaTone(img, height, width);
        img = sepiaTone.storeRGB();
        return img;
      }
      case "dither": {
        System.out.println("Dithering the image");
        IImage dither = new DitherImage(img, height, width);
        img = dither.storeRGB();
        return img;
      }
      default:
        System.out.println("Operation not supported");
        throw new IllegalArgumentException("Operation not supported");
    }
  }

  public int getHeight(){
    return height;
  }
  public int getWidth(){
    return width;
  }

  public int[][][] generateVibgyor(String direction, int heightStr, int widthStr) {
    height = heightStr;
    width = widthStr;
    if (direction.equals("horizontal")) {
      System.out.println("Creating a horizontal VIBGYOR.");
      GenerateVibgyorStripes horizontalVibgyor =
              new GenerateVibgyorStripes(direction,height, width);
      img = horizontalVibgyor.storeRGB();
    } else if (direction.equals("vertical")) {
      System.out.println("Creating a vertical VIBGYOR.");
      GenerateVibgyorStripes vibgyorVerticalStripes =
              new GenerateVibgyorStripes(direction, height, width);
      img = vibgyorVerticalStripes.storeRGB();
    }
    return img;
  }

  public int[][][] generateCheckerboard(int squareSize) {
    IImage checkerboard = new GenerateCheckerBoard(squareSize);
    height = checkerboard.getHeight();
    width = checkerboard.getWidth();
    img = checkerboard.storeRGB();
    return img;
  }

  public int[][][] applyMosaicEffect(int seeds) {
      System.out.println("Applying mosaic for the image");
      IImage mosaicImage = new MosaicImage(img, height, width, seeds);
      img = mosaicImage.storeRGB();
      return img;
    }
}
