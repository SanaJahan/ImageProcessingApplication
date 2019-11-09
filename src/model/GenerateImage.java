package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class GenerateImage implements IGenerateImage{

  @Override
  public void generateHorizontalRainbow(Scanner sc) throws IOException {
    System.out.println("Rainbow Image with Horizontal Stripes");
    System.out.println("Enter the width and height of the image:");
    int width = sc.nextInt();
    int height = sc.nextInt();
    int stripeThickness = height / 7;

    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = bufferedImage.createGraphics();

    Color violet = new Color(147, 32,255);
    g2d.setColor(violet);
    g2d.fillRect(0, 0, width, stripeThickness);

    Color indigo = new Color(75, 55,255);
    g2d.setColor(indigo);
    g2d.fillRect(0, stripeThickness, width, stripeThickness);

    g2d.setColor(Color.blue);
    g2d.fillRect(0, stripeThickness * 2, width, stripeThickness);

    g2d.setColor(Color.green);
    g2d.fillRect(0, stripeThickness * 3, width, stripeThickness);

    g2d.setColor(Color.yellow);
    g2d.fillRect(0, stripeThickness * 4, width, stripeThickness);

    g2d.setColor(Color.orange);
    g2d.fillRect(0, stripeThickness * 5, width, stripeThickness);

    g2d.setColor(Color.red);
    g2d.fillRect(0, stripeThickness * 6, width, stripeThickness);

    g2d.dispose();

    // Save as PNG
    File file = new File("myimage.png");
    ImageIO.write(bufferedImage, "png", file);
  }

  @Override
  public void generateVerticalRainbow(Scanner sc) {

  }

  @Override
  public void generateCheckerBoard(Scanner sc) {

  }
}
