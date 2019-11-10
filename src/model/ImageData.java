package model;

/**
 * Abstract that sets the essential information of an image.
 */
public abstract class ImageData implements IImage {

  protected int height;

  protected int width;

  protected int[][][] rgb;


  /**
   * Sets values for the width,height and rgb value given any kind of filter, color transformation,
   * or image generation.
   * @param rgb The pixel information of r,g and b as a 3D matrix.
   * @param height Height of the image.
   * @param width Width of the image.
   * @throws IllegalArgumentException Thrown at IllegalArgumentException.
   */
  public ImageData(int[][][] rgb, int height, int width) throws IllegalArgumentException {

    if (rgb == null) {
      throw new IllegalArgumentException("Cannot take null parameters");
    }
    if (height <= 0) {
      throw new IllegalArgumentException(" Height is too small");
    }
    if (width <= 0) {
      throw new IllegalArgumentException(" Width is too small");
    }

    this.rgb = rgb;
    this.height = height;
    this.width = width;
  }

  /**
   * Gets the height of the image that is getting altered.
   * @return Height.
   */
  public int getHeight() {
    return height;
  }

  /**
   * Public getter method takes in no arguments as parameters and returns the width of the image
   * that is being altered.
   *
   * @return the width of the image as an int data type.
   */
  public int getWidth() {
    return width;
  }


  /**
   * For creating a new matrix to initialize the values of a new image.
   * @param rgb Initial rgb matrix.
   * @return Newly initialized matrix.
   */
  protected int[][][] copyColors(int[][][] rgb) {
    return new int[rgb.length][rgb[0].length][3];
  }

  /**
   * For clamping or thresholding the pixels of the image.
   * @param value The pixel to be checked against the threshold.
   * @return The clamped pixel value.
   */
  protected int clampValue(double value) {
    int intValue = (int) Math.round(value);
    if (intValue > 255) {
      intValue = 255;
    } else if (intValue < 0) {
      intValue = 0;
    }
    return intValue;
  }

  /**
   * Uses the copyColor method and initializes the new rgb matrix by performing convolution.
   * @param imageKernel The kernel used for convolution.
   * @return New 3D rgb matrix.
   */
  protected int[][][] initializeRGBValues(double[][] imageKernel) {
    double[][] kernel = imageKernel;
    double value;
    int num1;
    int num2;
    int[][][] newRGB = copyColors(rgb);

    int startIndex = (imageKernel.length - 1) / 2;
    for (int c = 0; c < 3; c++) {
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          value = 0;
          num1 = i - startIndex;
          num2 = j - startIndex;
          for (int a = 0; a < imageKernel.length; a++) {
            for (int b = 0; b < imageKernel.length; b++) {
              if (num1 < 0 || num2 < 0 || num1 >= height || num2 >= width) {
                continue;
              } else {
                value += kernel[a][b] * (double) rgb[num1][num2][c];
              }
              num2++;
            }
            num2 = j - startIndex;
            num1++;
          }
          newRGB[i][j][c] = clampValue(value);
        }
      }
    }
    return newRGB;
  }

}
