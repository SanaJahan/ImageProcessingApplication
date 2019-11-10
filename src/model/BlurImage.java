package model;

/**
 * Class that imposes the blur filter on an image.
 */
public class BlurImage extends ImageData implements IBlur {

  /**
   * Constructor that calls the constructor of the ImageData class to set the rgb,height and width.
   * @param rgb The pixel information of r,g and b as a 3D matrix.
   * @param height Height of the image.
   * @param width Width of the image.
   * @throws IllegalArgumentException Thrown at IllegalArgumentException.
   */
  public BlurImage(int[][][] rgb, int height, int width) {
    super(rgb, height, width);
  }

  /**
   * Creates a blur filter to impose on the image.
   * @return The 3D matrix output.
   */
  public int[][][] applyBlurringEffect() {
    double[][] blurKernel = {{1.0f/16.0f, 1.0f/8.0f, 1.0f/16.0f},
            {1.0f/8.0f, 1.0f/4.0f, 1.0f/8.0f},
            {1.0f/16.0f, 1.0f/8.0f, 1.0f/16.0f}};
    return initializeRGBValues(blurKernel);
  }

  /**
   * This will store the blur 3D matrix values into the ImageData rgb value.
   * @return The final 3D matrix.
   */
  @Override
  public int[][][] storeRGB() {
    return applyBlurringEffect();
  }
}
