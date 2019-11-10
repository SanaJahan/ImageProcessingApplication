package model;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Contains methods used for performing Color Transformation operations, like grayscale and sepia,
 * on the image.
 */
public class ColorTransformation implements IColorTransformation {

  /**
   * Converts image to grayscale.
   * @param imageData Image in consideration.
   */
  @Override
  public void applyGreyScale(BufferedImage imageData) {
    if (imageData == null) {
      return;
    }
    for (int i = 0; i < imageData.getHeight(); i++) {
      for (int j = 0; j < imageData.getWidth(); j++) {
        Color imageColor = new Color(imageData.getRGB(j, i));
        int rgb = (int) (imageColor.getRed() * 0.2126)
                + (int) (imageColor.getGreen() * 0.7152)
                + (int) (imageColor.getBlue() * 0.0722);
        Color newColor = new Color(rgb, rgb, rgb);
        imageData.setRGB(j, i, newColor.getRGB());
      }
    }
  }

  /**
   * Converts image to sepia tone.
   * @param imageData Image in consideration.
   */
  @Override
  public void applySepiaTone(BufferedImage imageData) {
    int width = imageData.getWidth();
    int height = imageData.getHeight();

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int p = imageData.getRGB(x, y);

        int a = (p >> 24) & 0xff;
        int r = (p >> 16) & 0xff;
        int g = (p >> 8) & 0xff;
        int b = p & 0xff;

        //calculate tr, tg, tb
        int tr = (int) (0.393 * r + 0.769 * g + 0.189 * b);
        int tg = (int) (0.349 * r + 0.686 * g + 0.168 * b);
        int tb = (int) (0.272 * r + 0.534 * g + 0.131 * b);

        //check condition
        if (tr > 255) {
          r = 255;
        } else {
          r = tr;
        }

        if (tg > 255) {
          g = 255;
        } else {
          g = tg;
        }

        if (tb > 255) {
          b = 255;
        } else {
          b = tb;
        }

        //set new RGB value
        p = (a << 24) | (r << 16) | (g << 8) | b;

        imageData.setRGB(x, y, p);
      }
    }
  }

}
