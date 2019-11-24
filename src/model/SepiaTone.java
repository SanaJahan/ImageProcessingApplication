package model;

/**
 * Applies the sepia tone filter on an image.
 */
public class SepiaTone extends AbstractColorTransformation {

  /**
   * Constructor that calls the constructor of the ImageData class to set the rgb,height and width.
   * @param rgb The pixel information of r,g and b as a 3D matrix.
   * @param height Height of the image.
   * @param width Width of the image.
   * @throws IllegalArgumentException Thrown at IllegalArgumentException.
   */
  public SepiaTone(int[][][] rgb, int height, int width) throws IllegalArgumentException {
    super(rgb, height, width);
  }
  /**
   * Converts image to Sepia.
   * @return 3D matrix output.
   */
  public int[][][] applySepiaTransformation() {
    float[][] sepiaTone = {{0.393f, 0.769f, 0.189f}, {0.349f, 0.686f, 0.168f},
            {0.272f, 0.534f, 0.131f}};
    return getOutput(sepiaTone);
  }
  /**
   * This will store the blur 3D matrix values into the ImageData rgb value.
   * @return The final 3D matrix.
   */
  @Override
  public int[][][] storeRGB() {
    return applySepiaTransformation();
  }


}
