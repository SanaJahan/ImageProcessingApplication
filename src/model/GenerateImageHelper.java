package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GenerateImageHelper {

  int width = 8;
  int height = 8;
  BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
  Graphics2D g2d = bufferedImage.createGraphics();

  public void evenRowTimes8(int y) {
    g2d.setColor(Color.white);
    g2d.fillRect(0, y, 1, 1);

    g2d.setColor(Color.white);
    g2d.fillRect(2, y, 1, 1);

    g2d.setColor(Color.white);
    g2d.fillRect(4, y, 1, 1);

    g2d.setColor(Color.white);
    g2d.fillRect(6, y, 1, 1);
  }

  public void oddRowTimes8(int y) {
    g2d.setColor(Color.white);
    g2d.fillRect(1, y, 1, 1);

    g2d.setColor(Color.white);
    g2d.fillRect(3, y, 1, 1);

    g2d.setColor(Color.white);
    g2d.fillRect(5, y, 1, 1);

    g2d.setColor(Color.white);
    g2d.fillRect(7, y, 1, 1);
  }

  public void evenRowTimes4(int y) {
    g2d.setColor(Color.white);
    g2d.fillRect(0, y, 2, 2);

    g2d.setColor(Color.white);
    g2d.fillRect(4, y, 2, 2);
  }

  public void oddRowTimes4(int y) {
    g2d.setColor(Color.white);
    g2d.fillRect(2, y, 2, 2);

    g2d.setColor(Color.white);
    g2d.fillRect(6, y, 2, 2);
  }

  public void evenRowTimes2(int y) {
    g2d.setColor(Color.white);
    g2d.fillRect(0, y, 4, 4);
  }

  public void oddRowTimes2(int y) {
    g2d.setColor(Color.white);
    g2d.fillRect(4, y, 4, 4);
  }

  public void checkerBoardTimes8() throws IOException{
    int temp = 0;
    for (int i = 0; i < 8; i++) {
      if (i % 2 == 0) {
        evenRowTimes8(temp);
        temp ++;
      }
      else {
        oddRowTimes8(temp);
        temp ++;
      }
    }
    g2d.dispose();

    File file = new File("checkerboard1.png");
    ImageIO.write(bufferedImage, "png", file);
  }

  public void checkerBoardTimes4() throws IOException{
    int temp = 0;
    for (int i = 0; i < 4; i++) {
      if (i % 2 == 0) {
        evenRowTimes4(temp);
        temp += 2;
      }
      else {
        oddRowTimes4(temp);
        temp += 2;
      }
    }
    g2d.dispose();

    File file = new File("checkerboard2.png");
    ImageIO.write(bufferedImage, "png", file);
  }

  public void checkerBoardTimes2() throws IOException {
    int temp = 0;
    for (int i = 0; i < 2; i++) {
      if (i % 2 == 0) {
        evenRowTimes2(temp);
        temp += 4;
      }
      else {
        oddRowTimes2(temp);
        temp += 4;
      }
    }
    g2d.dispose();

    File file = new File("checkerboard4.png");
    ImageIO.write(bufferedImage, "png", file);
  }
}
