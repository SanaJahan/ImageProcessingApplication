package model;

/**
 * Converts the image to Grayscale.
 */
public class GreyScale extends AbstractColorTransformation {

  /**
   * Constructor that calls the constructor of the ImageData class to set the rgb,height and width.
   * @param rgb The pixel information of r,g and b as a 3D matrix.
   * @param height Height of the image.
   * @param width Width of the image.
   * @throws IllegalArgumentException Thrown at IllegalArgumentException.
   */
  public GreyScale(int[][][] rgb, int height, int width) throws IllegalArgumentException {
    super(rgb, height, width);
    if (height < 1 || width < 1) {
      throw new IllegalArgumentException("Height/Width of the image is too less");
    }
  }

  /**
   * This will store the blur 3D matrix values into the ImageData rgb value.
   * @return The final 3D matrix.
   */
  @Override
  public int[][][] storeRGB() {
    float[][] grayScale = {{0.2126f, 0.7152f, 0.0722f},
            {0.2126f, 0.7152f, 0.0722f},
            {0.2126f, 0.7152f, 0.0722f}};
    return getOutput(grayScale);
  }
}
