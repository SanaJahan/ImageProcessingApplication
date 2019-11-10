package model;

/**
 * Interface the has a method to apply the sharpening filter on an image.
 */
public interface ISharpen {
  /**
   * method that implements the logic to apply the sharpening effect on any given image.
   */
  int[][][] applySharpeningEffect();
}
