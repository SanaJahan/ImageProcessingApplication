package utility;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScriptHelper {

  private int height;
  private int width;

  /**
   *
   */
  public int[][][] readImage(BufferedImage image) {
    if (image == null) {
      throw new IllegalArgumentException();
    }
    int[][][] result = new int[image.getHeight()][image.getWidth()][3];
    this.height = image.getHeight();
    this.width = image.getWidth();
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        int color = image.getRGB(j, i);
        Color c = new Color(color);
        result[i][j][0] = c.getRed();
        result[i][j][1] = c.getGreen();
        result[i][j][2] = c.getBlue();
      }
    }
    return result;

  }

  public void writeImage(String filePath, int[][][] rgb, int width, int height) {
    try {
      BufferedImage output = new BufferedImage(
              width,
              height,
              BufferedImage.TYPE_INT_RGB);

      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          int red = rgb[i][j][0];
          int green = rgb[i][j][1];
          int blue = rgb[i][j][2];
          int color = (red << 16) + (green << 8) + blue;
          output.setRGB(j, i, color);
        }
      }
      String extension = filePath.substring(filePath.indexOf(".") + 1);
      ImageIO.write(output, extension, new FileOutputStream(filePath));
    } catch (IOException e) {
      System.out.println("Error Occurred!\n" + e);
    }
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }
}
