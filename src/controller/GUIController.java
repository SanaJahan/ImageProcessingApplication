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

/**
 * Contoller that deals with the interactive user experience, rather than reading the text file.
 */
public class GUIController  {

  private static int[][][] img = null;
  private static int height = -1;
  private static int width = -1;
  private ImageUtil imageUtil = new ImageUtil();


  /**
   * Will change the look and feel of the application.
   * @param args String args.
   */
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

  /**
   * Loads the image selected by the user.
   * @param filename File to be selected by the user.
   * @throws IOException Throws IOException.
   */
  public void loadImage(String filename) throws IOException {
    img = imageUtil.readImage(filename);
    height = imageUtil.getHeight();
    width = imageUtil.getWidth();

  }

  /**
   * After performing operations on the image, the user can save the image to a specific file,
   * location.
   * @param filePath File path to which the new image will be saved.
   */
  public void saveImage(String filePath) {
    imageUtil.writeImage(filePath,img,width,height);
  }


  /**
   * Based on the effect selected by the user, the corresponding operation is passed as a string,
   * to this method, and the functions are carried out for it.
   * @param effect String format of the effect requested.
   * @return Transformed new image.
   */
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

  /**
   * For generating a horizontal or vertical VIBGYOR image based on the inputs provided,
   * by the user.
   * @param direction Orientation of the colored stripes in the newly generated image.
   * @param heightStr Height of  the new image.
   * @param widthStr Width of the new image.
   * @return Newly generated VIBGYOR image.
   */
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
      GenerateVibgyorStripes verticalVibgyor =
              new GenerateVibgyorStripes(direction, height, width);
      img = verticalVibgyor.storeRGB();
    }
    return img;
  }

  /**
   * For generating a checkerboard image based on the inputs provided by the user.
   * @param squareSize Size of the squares in the checkerboard.
   * @return Newly generated checkerboard image.
   */
  public int[][][] generateCheckerboard(int squareSize) {
    IImage checkerboard = new GenerateCheckerBoard(squareSize);
    height = checkerboard.getHeight();
    width = checkerboard.getWidth();
    img = checkerboard.storeRGB();
    return img;
  }

  /**
   * Applies the mosaic transformation on the image.
   * @param seeds Number of seeds to affect the mosaic transformation.
   * @return The newly transformed mosaic image.
   */
  public int[][][] applyMosaicEffect(int seeds) {
      System.out.println("Applying mosaic for the image");
      IImage mosaicImage = new MosaicImage(img, height, width, seeds);
      img = mosaicImage.storeRGB();
      return img;
    }
}
