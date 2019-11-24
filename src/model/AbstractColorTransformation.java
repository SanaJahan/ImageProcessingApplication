package model;

/**
 * Contains abstract methods for converting image to GrayScale or Sepia.
 */
public abstract class AbstractColorTransformation extends ImageData {

  /**
   * Constructor that calls the constructor of the ImageData class to set the rgb,height and width.
   * @param rgb The pixel information of r,g and b as a 3D matrix.
   * @param height Height of the image.
   * @param width Width of the image.
   * @throws IllegalArgumentException Thrown at IllegalArgumentException.
   */
  protected AbstractColorTransformation(int[][][] rgb, int height, int width)
          throws IllegalArgumentException {
    super(rgb, height, width);
  }

  /**
   * Performs the convolution specific to the grayscale and sepia transformations without the,
   * kernel.
   * @param transform
   * @return
   */
  protected int[][][] getOutput(float[][] transform) {
    int[][][] output = initializeArray(rgb);
    for (int c = 0; c < 3; c++) {
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          float value = (transform[c][0] * rgb[i][j][0]) + (transform[c][1] * rgb[i][j][1])
                  + (transform[c][2] * rgb[i][j][2]);
          output[i][j][c] = clampValue(value);
        }
      }
    }
    return output;
  }


}
