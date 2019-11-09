package model;

import java.awt.image.BufferedImage;

/**
 * Filtering interface to apply various filtering operation on images.
 */
public interface IFiltering {

  /**
   * method that implements the logic to apply the blur effect on any given image.
   * @param img on which the blur effect is to be applied.
   */
  void applyBlurringEffect(ImageData img, int maskSize);

  /**
   * method that implements the logic to apply the sharpening effect on any given image.
   * @param image on which the sharpening effect is to be applied.
   */
  void applySharpeningEffect(BufferedImage image);
}
