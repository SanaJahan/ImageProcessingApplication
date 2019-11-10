package model;

/**
 * Filtering interface to apply various filtering operation on images.
 */
public interface IBlur {

  /**
   * method that implements the logic to apply the blur effect on any given image.
   */
  int[][][] applyBlurringEffect();
}
