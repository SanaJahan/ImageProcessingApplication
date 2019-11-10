package model;

public abstract class ImageData implements IImage {


  protected int height;

  protected int width;

  protected int[][][] rgb;


  public ImageData(int[][][] rgb, int height, int width) throws IllegalArgumentException {

    if (rgb == null) {
      throw new IllegalArgumentException("Cannot take null parameters");
    }

    this.rgb = rgb;
    this.height = height;
    this.width = width;
  }

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


  protected int[][][] copyColors(int[][][] rgb) {
    return new int[rgb.length][rgb[0].length][3];
  }

  protected int clampValue(double value) {
    int intValue = (int) Math.round(value);
    if (intValue > 255) {
      intValue = 255;
    } else if (intValue < 0) {
      intValue = 0;
    }
    return intValue;
  }

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
