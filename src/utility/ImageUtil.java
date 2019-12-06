package utility;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Contains methods to help in reading and writing the images when the operation is called by the,
 * user in the script/text file.
 */
public class ImageUtil {

  private int height;
  private int width;

  /**
   *Reads the source image.
   */
  public int[][][] readImage(String term) throws IOException {
    ClassLoader classLoader = new ImageUtil().getClass().getClassLoader();
    BufferedImage image = ImageIO.read(classLoader.getResource(term));
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

  /**
   * Writes the target image.
   */
  public void writeImage(String filePath, int[][][] rgb, int width, int height) {
    try {
      String extension = filePath.substring(filePath.indexOf(".") + 1);
      ImageIO.write(getTransformedImage(rgb, width, height), extension, new FileOutputStream(filePath));
    } catch (IOException e) {
      System.out.println("Error Occurred!\n" + e);
    }
  }

  /**
   * Gets the height of the image.
   * @return Height of the image.
   */
  public int getHeight() {
    return height;
  }

  /**
   * Gets the width of the image.
   * @return Width of the image.
   */
  public int getWidth() {
    return width;
  }

  public BufferedImage getTransformedImage(int[][][] rgb, int width, int height) {
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
    return output;
  }
}
