package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

/**
 * Contains methods to generate images with rainbow stripes or a checkerboard pattern.
 */
public class GenerateImage implements IGenerateImage {

  /**
   * Generates an image with horizontal rainbow stripes.
   * @param sc User defined width and height.
   * @throws IOException Thrown at IOException.
   */
  @Override
  public void generateHorizontalRainbow(Scanner sc) throws IOException  {
    System.out.println("Rainbow Image with Horizontal Stripes");
    System.out.println("Enter the stripe thickness and total width of the image:");
    int stripHeight = sc.nextInt() + '\n';
    int totalWidth = sc.nextInt() + '\n';

    System.out.println("Enter the required Image Format:");
    //String format = sc.nextLine();
    String format = "jpg";
    int totalHeight = stripHeight * 7;

    BufferedImage bufferedImage = new BufferedImage(totalWidth, totalHeight, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = bufferedImage.createGraphics();

    Color violet = new Color(147, 32,255);
    g2d.setColor(violet);
    g2d.fillRect(0, 0, totalWidth, stripHeight);

    Color indigo = new Color(75, 55,255);
    g2d.setColor(indigo);
    g2d.fillRect(0, stripHeight, totalWidth, stripHeight);

    g2d.setColor(Color.blue);
    g2d.fillRect(0, stripHeight * 2, totalWidth, stripHeight);

    g2d.setColor(Color.green);
    g2d.fillRect(0, stripHeight * 3, totalWidth, stripHeight);

    g2d.setColor(Color.yellow);
    g2d.fillRect(0, stripHeight * 4, totalWidth, stripHeight);

    g2d.setColor(Color.orange);
    g2d.fillRect(0, stripHeight * 5, totalWidth, stripHeight);

    g2d.setColor(Color.red);
    g2d.fillRect(0, stripHeight * 6, totalWidth, stripHeight);

    g2d.dispose();

    if (format == "png" || format == "jpg" || format == "bmp") {
      File file = new File("Horizontal Rainbow." + format);
      ImageIO.write(bufferedImage, format, file);
    }
    else {
      System.out.println("There is no such image format.");
    }
  }

  /**
   * Generates an image with vertical rainbow stripes.
   * @param sc User defined width and height.
   * @throws IOException Thrown at IOException.
   */
  @Override
  public void generateVerticalRainbow(Scanner sc) throws IOException{
    System.out.println("Rainbow Image with Vertical Stripes ");
    System.out.println("Enter the width and height of the image:");
    int stripWidth = sc.nextInt() + '\n';
    int totalHeight = sc.nextInt() + '\n';
    System.out.println("Enter the required Image Format: ");
    //String format = sc.nextLine() + '\n';
    String format = "png";
    int totalWidth = stripWidth * 7;

    BufferedImage bufferedImage = new BufferedImage(totalWidth, totalHeight, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = bufferedImage.createGraphics();

    Color violet = new Color(147, 32,255);
    g2d.setColor(violet);
    g2d.fillRect(0, 0, stripWidth, totalHeight);

    Color indigo = new Color(75, 55,255);
    g2d.setColor(indigo);
    g2d.fillRect(stripWidth, 0, stripWidth, totalHeight);

    g2d.setColor(Color.blue);
    g2d.fillRect(stripWidth * 2, 0, stripWidth, totalHeight);

    g2d.setColor(Color.green);
    g2d.fillRect(stripWidth * 3, 0, stripWidth, totalHeight);

    g2d.setColor(Color.yellow);
    g2d.fillRect(stripWidth * 4, 0, stripWidth, totalHeight);

    g2d.setColor(Color.orange);
    g2d.fillRect(stripWidth * 5, 0, stripWidth, totalHeight);

    g2d.setColor(Color.red);
    g2d.fillRect(stripWidth * 6, 0, stripWidth, totalHeight);

    g2d.dispose();

    if (format == "png" || format == "jpg" || format == "bmp") {
      File file = new File("Vertical Rainbow." + format);
      ImageIO.write(bufferedImage, format, file);
    }
    else {
      System.out.println("There is no such image format.");
    }
  }

  /**
   * Generates an image with checkerboard pattern.
   * @param sc User defined width and height of the squares.
   * @throws IOException Thrown at IOException.
   */
  @Override
  public void generateCheckerBoard(Scanner sc) throws IOException{
    GenerateImageHelper helper = new GenerateImageHelper();
    System.out.println("Enter square width and height of 1,2 or 4:");
    int dimension = sc.nextInt();
    if (dimension == 1) {
      helper.checkerBoardTimes8();
    }
    else if (dimension == 2) {
      helper.checkerBoardTimes4();
    }
    else if (dimension == 4) {
      helper.checkerBoardTimes2();
    }
    else {
      throw new IOException();
    }
  }

  public static void main(String[] args) throws IOException{
    GenerateImage g = new GenerateImage();
    Scanner sc = new Scanner(System.in);
    g.generateVerticalRainbow(sc);
    //g.generateHorizontalRainbow(sc);
    //g.generateCheckerBoard(sc);
  }
}
