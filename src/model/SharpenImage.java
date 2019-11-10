package model;

public class SharpenImage extends ImageData implements ISharpen{

  public SharpenImage(int[][][] rgb, int height, int width) throws IllegalArgumentException {
    super(rgb, height, width);
  }

  @Override
  public int[][][] applySharpeningEffect() {
    double[][] sharpen = {{-1.0f/8.0f, -1.0f/8.0f, -1.0f/8.0f, -1.0f/8.0f, -1.0f/8.0f},
            {-1.0f/8.0f, 1.0f/4.0f, 1.0f/4.0f, 1.0f/4.0f, -1.0f/8.0f},
            {-1.0f/8.0f, 1.0f/4.0f, 1.0f, 1.0f/4.0f, -1.0f/8.0f},
            {-1.0f/8.0f, 1.0f/4.0f, 1.0f/4.0f, 1.0f/4.0f, -1.0f/8.0f},
            {-1.0f/8.0f, -1.0f/8.0f, -1.0f/8.0f, -1.0f/8.0f, -1.0f/8.0f}};
    return initializeRGBValues(sharpen);
  }


  /**
   * This will store the blur 3D matrix values into the ImageData rgb value.
   * @return The final 3D matrix.
   */
  @Override
  public int[][][] storeRGB() {
    return applySharpeningEffect();
  }
}
