package model;

/**
 * Interface with methods to be used by the ImageData class to set the rgb, height and width value.
 */
public interface IImage {

  /**
   * This will store the 3D matrix values into the ImageData rgb value.
   * @return The final 3D matrix.
   */
  int[][][] storeRGB();

  /**
   * Height of the image.
   * @return Height.
   */
  int getHeight();

  /**
   * Width of the image.
   * @return Width.
   */
  int getWidth();

}
